package com.distributedhashtable.nodefactory;

import java.util.HashMap;

import org.jeromq.ZMQ;

public class UserProgram {

	public static void main(String args[]) {
	NodeFactoryPattern Obj = new NodeFactoryPattern();
	//enter 0 for adding New node 1 for deleting Node
	NodeFactory Obj1 = Obj.getInstance(0);
	Obj1.addNode();
	
	ExposedDHTApiPattern Obj2 = new ExposedDHTApiPattern();
	ExposedDHTApi Obj3 = Obj2.getInstance();
	System.out.println("Calling Dispatcher");
	Obj3.putData("Put", "Data");
	HashMap<String,String> temp = Obj3.getData("Put");
	System.out.println("Key and value " + temp.values());
	
	while(true);
	/*ExposedDHTApi obj = new Dispatcher();
	
	 ZMQ.Context context = ZMQ.context(1);
	    //  Socket to talk to clients
	 ZMQ.Socket socket = context.socket(ZMQ.REP);
	 socket.connect("tcp://*:5555"); 
	   
	    	
	    	//perform some broadcast operation the first time it logs i
     
     //all the code goes here
     socket.send("SENDING MTU".getBytes (), 0);
     
     byte[] reply = socket.recv(0);
     System.out.println("Received Hello");
     String request = "World" ;

     socket.close();
     context.term(); */
	
}}
