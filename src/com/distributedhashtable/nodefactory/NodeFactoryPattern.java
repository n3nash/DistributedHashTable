package com.distributedhashtable.nodefactory;

import com.distributedhashtable.nodefactory.*;

public class NodeFactoryPattern {

	public NodeFactory getInstance(Integer createOrDelete) {
		
		if(createOrDelete.equals(0))
			return NodeCreator.getInstance();
		else
			return NodeDeletor.getInstance();
	}
	
}
