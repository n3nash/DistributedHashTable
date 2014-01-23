package com.distributedhashtable.nodefactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import org.jeromq.ZContext;
import org.jeromq.ZMQ;

import com.example.tutorial.AddressBookProtos;
import com.example.tutorial.AddressBookProtos.Person;
import com.google.protobuf.InvalidProtocolBufferException;
import com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution;
import com.distributedhashtable.messageexchange.TransferMessages.Messages;
import com.distributedhashtable.nodefactory.ProcessPerformTasksInterface;

public class ProcessPerformTasks implements ProcessPerformTasksInterface {

	
	public class DataToRedistribute implements Comparable<DataToRedistribute>{
		public String keyHash;
		public String Key;
		
		@Override
		public int compareTo(DataToRedistribute arg0) {
			// TODO Auto-generated method stu
		
		    if (this.keyHash.compareTo(arg0.keyHash) > 0 ){
		        return +1;
		    }
		    else if (this.keyHash.compareTo(arg0.keyHash) < 0){
		        return -1;
		    }
		    else {  // equal
		        return 0;
		}
	}}
	
	Integer processID;
	public HashMap<String,String> dataStore = null;
	ArrayList<String> usedForDataRedistribution = null;
	PriorityQueue<DataToRedistribute> dataRedistribution = null;
	HashMap<String,Integer> fingerTable;
	private Integer nodeHashValue;
	public String nextNode;
	private String ipaddress;
	private static boolean shutdown;
	CreateContextVariables contextVariables;
	Messages message;

	
	ProcessPerformTasks(Integer nodeHashValue, Integer processID,String ipaddress) {
		dataStore = new HashMap<String,String>();
		usedForDataRedistribution = new ArrayList<String>();
		this.processID=processID;
		this.nodeHashValue = nodeHashValue;
		this.ipaddress = ipaddress;
		dataRedistribution = new PriorityQueue<DataToRedistribute>();/*(new Comparator<DataToRedistribute>() {
	        public int compare(DataToRedistribute node1, DataToRedistribute node2) {
	            return (node1.keyHash == node2.keyHash) ? (Integer.valueOf(node1.keyHash).compareTo(node2.keyHash))
	                                                                              : (node1.keyHash ? -1 : 1);
	        }}*/
		contextVariables = new CreateContextVariables();
		contextVariables.context = ZMQ.context(1);
		contextVariables.socket = contextVariables.context.socket(ZMQ.REP);
		contextVariables.socketREQ = contextVariables.context.socket(ZMQ.REQ);
		contextVariables.socket.bind ("tcp://*:"+this.ipaddress); 
		System.out.println("New Process is Spawned!" + "Bound to tcp://*:5554");
	}
	
	private void interpretIPCMessages(byte [] messageData) {
        System.out.println("Recieved" + new String(messageData));
        String rep = new String(messageData);
        try {
			
        message = Messages.parseFrom(messageData);
        //implement a switch - case here
        if(message.getTypeOfMessage().equals("addNode"))   //remove these if - else and provide some clean architecture like one fucntion call with passed value and that function decides what to do
        	reDistributeData();
        
        if(message.getTypeOfMessage().equals("setNextNode"))
        	nextNode = message.getIpaddress();
        
        
        if(message.getTypeOfMessage().equals("deleteNode")) {
        	System.out.println("have to delete this process");
        	reDistributeData();
        	System.out.println("Shutdown initated");
        	shutdown=true;
        	setShutdown(shutdown);
        	
        }
        
        //if(message.getTypeOfMessage().equals("transferData")) 
        //	insertTransferedIntoDataStore();
        
        if(message.getTypeOfMessage().equals("put")){
        	insertIntoDataStore();}
        
        if(message.getTypeOfMessage().equals("get")) {
        	retrieveFromDataStore();}
        else
        	this.interProcessSender();
        }catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void reDistributeData() {
		
		ArrayList<String> keys = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		while(dataRedistribution.peek().keyHash.compareTo(message.getTransferMessage()) < 0) {
			DataToRedistribute data = dataRedistribution.remove();
			keys.add(data.Key);
			values.add(dataStore.get(data.Key));
			Messages transferData = Messages.newBuilder().setKey(data.Key).setValue(dataStore.get(data.Key)).setTypeOfMessage("Put").build();
			dataStore.remove(data.Key);
			//send the data to the other node
			transferDataStore(transferData);
		}
	}
	
	@Override
	public void interProcessListener() {
		// TODO Auto-generated method stub
		System.out.println("Listener Invoked");
	    
	    System.out.println("Socket is Null " + contextVariables.socket==null);
	    	//perform some broadcast operation the first time it logs in
        byte[] reply = contextVariables.socket.recv(0);
        
        interpretIPCMessages(reply);
        
	}
	@Override
	public void interProcessSender(String response) {
		// TODO Auto-generated method stub
		try{
		contextVariables.socket.send(response.getBytes (), 0);
		System.out.println("Sent response");
		}
		catch(Exception e){
		System.out.println(e);}
		
	}
	
	@Override
	public void interProcessSender() {
		// TODO Auto-generated method stub
		try{
		contextVariables.socket.send("DONE".getBytes (), 0);
		System.out.println("Sent response");
		}
		catch(Exception e){
		System.out.println(e);}
	}

	@Override
	public void findNextNode() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void transferDataStore(Messages data) {
		
		System.out.println("Transferrring to other Process");
	
		contextVariables.socketREQ.connect ("tcp://localhost:"+message.getIpaddress());
		
		contextVariables.socketREQ.send(data.toByteArray(),0);
		byte[] reply = contextVariables.socketREQ.recv(0);
		
		String response = "DoneAftersecond Process" ;
		contextVariables.socket.send(response.getBytes (), 0);
		// TODO Auto-generated method stub	
	}
	@Override
	public void insertIntoDataStore() {
		// TODO Auto-generated method stub
    	dataStore.put(message.getKey(), message.getValue());
    	DataToRedistribute queueElement = new DataToRedistribute();
    	queueElement.Key = message.getKey();
    	queueElement.keyHash = message.getKeyHash();
    	dataRedistribution.add(queueElement);
    	interProcessSender();
		return;	
	}
	@Override
	public <T> T retrieveFromDataStore() {
		String rep1 = dataStore.get(message.getKey());
    	System.out.println("Value retrived" + rep1);
    	interProcessSender(rep1);
		return (T) rep1;
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setShutdown(boolean setShutdown) {
		// TODO Auto-generated method stub
		shutdown=setShutdown;
		if(isShutdown()) {
			contextVariables.socket.close();
			contextVariables.socketREQ.close();
			contextVariables.context.term();
		}	
	}	
	@Override
	public boolean isShutdown() {
		// TODO Auto-generated method stub
		return shutdown;
	}
	@Override
	public void setProcessID(Integer processID) {
		// TODO Auto-generated method stub
		this.processID=processID;
		
	}
	@Override
	public int getProcessID() {
		// TODO Auto-generated method stub
		return this.processID;
	}
	
	@Override
	public void setNodeHashValue(Integer nodeHashValue) {
		// TODO Auto-generated method stub
		this.nodeHashValue = nodeHashValue;
	}

	@Override
	public int getNodeHashValue() {
		// TODO Auto-generated method stub
		return this.nodeHashValue;
	}
	
	
	
	public static void main(String args[])
	{
		Integer nodeHashValue = Integer.parseInt(args[0]);
		Integer processID = Integer.parseInt(args[1]);
		String ipaddress = args[2];
		ProcessPerformTasksInterface processPerformTasks=new ProcessPerformTasks(nodeHashValue,processID,ipaddress);
		
		
		while(!processPerformTasks.isShutdown())
		{
			processPerformTasks.interProcessListener();
			System.out.println("Came out once ");
		}
/*	    ZMQ.Context context = ZMQ.context(1);
	    //  Socket to talk to clients
	    ZMQ.Socket socket = context.socket(ZMQ.REP);
	    socket.bind ("tcp://*:5555"); 
	    
	    while(!processPerformTasks.isShutdown())
	    {
	    	
	    	//perform some broadcast operation the first time it logs in
        byte[] reply = socket.recv(0);
        System.out.println("Received Hello");
        String request = "World" ;
        
        //all the code goes here
        socket.send(request.getBytes (), 0);
	    }
        socket.close();
        context.term();*/
		System.out.println("New Process is spawned!");
		
		
	}

}
