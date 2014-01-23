package com.distributedhashtable.nodefactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Random;
import com.distributedhashtable.messageexchange.*;
import com.distributedhashtable.messageexchange.TransferMessages.Messages;

import org.jeromq.ZMQ;

public class Dispatcher implements ExposedDHTApi {
	
	static ArrayList<Integer[]> dispatcherNodeTable;
	private static Dispatcher instance=null;
	CreateContextVariables contextVariables;
	LinkedList<NodeHashIPValue> nodeList;
	
	private Dispatcher() {
		dispatcherNodeTable = new ArrayList<Integer[]>();
		contextVariables = new CreateContextVariables();
		contextVariables.context = ZMQ.context(1);
		contextVariables.socket = contextVariables.context.socket(ZMQ.REP);
		contextVariables.socketREQ = contextVariables.context.socket(ZMQ.REQ);
		nodeList = new LinkedList<NodeHashIPValue>();
	}

	static Dispatcher getInstance() {
		if(instance==null)
			instance = new Dispatcher();
		return instance;
	}
	private NodeHashIPValue getNode(String key) {
		NodeHashIPValue node;
		ListIterator<NodeHashIPValue> itr = nodeList.listIterator();
		//hash the key
		Integer keyHash = HashingFunction.HashValue(key);
		while(itr.hasNext()) {
			if(keyHash > itr.next().nodeHashValue) {
				itr.previous();
				node = itr.next();
				return node;
			}
			if(!itr.hasNext()) {
				return nodeList.getFirst();
			}
		}
		return null;
	}
	
	public void updateNextNodeValue(LinkedList<NodeHashIPValue> nodeListToUpdate) {  //simple O(n) solution
		
		ListIterator<NodeHashIPValue> itr = nodeList.listIterator();
		while(itr.hasNext()) {
		
		String ipaddress = itr.next().Ipaddress;
		contextVariables.socketREQ.connect ("tcp://localhost:"+ipaddress);
		Messages message = Messages.newBuilder().setTypeOfMessage("addNode").setIpaddress(itr.next().Ipaddress).build();	
		contextVariables.socketREQ.send(message.toByteArray(),0); //Use proto buf to send this hashmap data
		byte[] reply = contextVariables.socketREQ.recv(0);
		String response = "Done After sending new Data" ;
		System.out.println(response);
		if(itr.hasNext())
			itr.previous();
		}

	}
	public void addEntryToNodeTable(Integer nodeHashValue, String Ipaddress) {  //simple O(n) solution
		dispatcherNodeTable.add(new Integer[] {nodeHashValue,Integer.parseInt(Ipaddress)});
		LinkedList<NodeHashIPValue> nodeListToUpdate = new LinkedList<NodeHashIPValue>();
		NodeHashIPValue nodehashipvalue = new NodeHashIPValue();
		nodehashipvalue.Ipaddress = Ipaddress;
		nodehashipvalue.nodeHashValue = nodeHashValue;
		ListIterator<NodeHashIPValue> itr = nodeList.listIterator();
		
		if(nodeList.isEmpty()) {
			nodeList.add(nodehashipvalue);
			nodeListToUpdate.add(nodehashipvalue);
			//updateNextNodeValue(nodeListToUpdate);
			return;
		}
			
		while(itr.hasNext()) {
			if(nodeList.size()==1) {
				if(nodehashipvalue.nodeHashValue > nodeList.getFirst().nodeHashValue){
					itr.next();
					itr.add(nodehashipvalue);
					nodeListToUpdate.add(nodeList.getFirst());
				}
				else{
					itr.add(nodehashipvalue);
					nodeListToUpdate.add(nodehashipvalue);
				}
				return;
			}
			else if(nodehashipvalue.nodeHashValue > itr.next().nodeHashValue) {
				itr.add(nodehashipvalue);
				itr.previous();
				nodeListToUpdate.add(itr.next());
				nodeListToUpdate.add(itr.next());
				if(itr.hasNext())
					nodeListToUpdate.add(itr.next());
				updateNextNodeValue(nodeListToUpdate);
				return;
		}
			}
	}
		
	
	
	private int getRandomNode() {
		return new Random().nextInt();
	}
	
	private void sendDataToNode(String key,String value,NodeHashIPValue nodeDetails){
		contextVariables.socketREQ.connect ("tcp://localhost:"+nodeDetails.Ipaddress);
		System.out.println("passed key value " + key + value);
		Messages message = Messages.newBuilder().setTypeOfMessage("put").setKey(key).setValue(value).setTransferMessage("notransfer").build();
		contextVariables.socketREQ.send(message.toByteArray(),0); 
		byte[] reply = contextVariables.socketREQ.recv(0);
	}
	
	private String getDataFromNode(String key,NodeHashIPValue nodeDetails) {
		
		contextVariables.socketREQ.connect ("tcp://localhost:"+nodeDetails.Ipaddress);
		Messages message = Messages.newBuilder().setTypeOfMessage("get").setKey(key).setTransferMessage("notransfer").build();
		contextVariables.socketREQ.send(message.toByteArray(),0);
		byte[] reply = contextVariables.socketREQ.recv(0);
		System.out.println(new String(reply));
		return new String(reply);
	}
	
	@Override
	public int putData(String key, String value) {
		// TODO Auto-generated method stub
		HashMap <String,String> sendData = new HashMap<String,String>();
		sendData.put(key, value);
		//determine which node to put the data into
		sendDataToNode(key,value,getNode(key));
		String response = "Done After sending new Data" ;
		System.out.println(response);
		
		return 0;
	}

	@Override
	public HashMap<String, String> getData(String key) {
		// TODO Auto-generated method stub
		String response = "Done After sending new Data" ;
		System.out.println(response);
		NodeHashIPValue destNode = getNode(key);
		String reply = getDataFromNode(key,destNode);
		HashMap <String,String> sendData = new HashMap<String,String>();
		sendData.put((reply), (reply));
		return sendData;
	}

}
