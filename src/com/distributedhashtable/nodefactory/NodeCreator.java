package com.distributedhashtable.nodefactory;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class NodeCreator implements NodeFactory {

	static NodeCreator instance = null;
	static int processID;
	static List<Process> allProcesses = null;
	HashMap<Integer,ArrayList<Integer>> nodesInformation = null;
	
	NodeCreator() {
		nodesInformation = new HashMap<Integer,ArrayList<Integer>>();
		processID=1;
		allProcesses = new ArrayList<Process>();
	}
	
	public static NodeCreator getInstance() {
		if(instance==null) {
			instance = new NodeCreator();
		}
			return instance;
	}
	
	private Integer getRandomNode() {
		return new Random().nextInt();
	}
	
	@Override
	public int addNode() {
		
		Integer nodeHashValue = HashingFunction.HashValue(getRandomNode().toString());
		HashingFunction.numberOfNodes++;
		Integer ip = HashingFunction.generateRandomSocket();
		ArrayList<Integer> insert = new ArrayList<Integer>();
		insert.add(nodeHashValue);
		insert.add(ip);
		nodesInformation.put(processID++, insert);
		allProcesses.add(SpawnNewProcess.spawnNewProcess(processID++,nodesInformation,nodeHashValue,ip.toString()));
		System.out.println("Process Created!");
		Dispatcher.getInstance().addEntryToNodeTable(nodeHashValue,ip.toString());
		
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteNode() {
		// TODO Auto-generated method stub
		return 0;
	}

}
