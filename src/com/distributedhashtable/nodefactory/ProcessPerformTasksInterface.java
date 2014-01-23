package com.distributedhashtable.nodefactory;

import java.util.ArrayList;
import java.util.HashMap;

import com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution;
import com.distributedhashtable.messageexchange.TransferMessages.Messages;

public interface ProcessPerformTasksInterface {

	public static HashMap<String,String> nodeList = null;
	public boolean isShutdown();
	public void setShutdown(boolean shutdown);
	public void interProcessListener();
	public void interProcessSender();
	public void interProcessSender(String response);
	public void findNextNode();
	public void transferDataStore(Messages data);
	public void insertIntoDataStore();
	public <T> T retrieveFromDataStore();
	public void setProcessID(Integer processID);
	public int getProcessID(); 
	public void setNodeHashValue(Integer nodeHashValue);
	public int getNodeHashValue(); 
}
