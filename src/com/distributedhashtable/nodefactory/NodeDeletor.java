package com.distributedhashtable.nodefactory;

public class NodeDeletor implements NodeFactory {

	
	static NodeDeletor instance = null;
	
	public static NodeDeletor getInstance() {
		if(instance==null)
			instance = new NodeDeletor();
		return instance;
	}
	@Override
	public int addNode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteNode() {
		// TODO Auto-generated method stub
		NodeCreator.getInstance().nodesInformation.remove("key");
		return 0;
	}

}
