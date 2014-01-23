package com.distributedhashtable.nodefactory;

import org.jeromq.ZMQ;

public class CreateContextVariables {

	public ZMQ.Context context = null;
	public ZMQ.Socket socket = null;
	public ZMQ.Socket socketREQ = null;
	public String request,response;

	
}
