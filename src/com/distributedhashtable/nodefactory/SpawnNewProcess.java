package com.distributedhashtable.nodefactory;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class SpawnNewProcess {
	
	static Process spawnNewProcess(Integer processID,HashMap<Integer,ArrayList<Integer>> nodesInformation, Integer nodeHashValue, String ipaddress) {
		
		try {
		    String classpath = System.getProperty("java.class.path");
		    String path = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
		    String passArgs[] = new String[] {path, "-cp", classpath, ProcessPerformTasks.class.getName(),nodeHashValue.toString(),processID.toString(),ipaddress};
		    ProcessBuilder processBuilder = new ProcessBuilder(passArgs);
		    System.out.println("Spawning new process!");
			Process process = processBuilder.start();
			return process;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
		
	}

}
