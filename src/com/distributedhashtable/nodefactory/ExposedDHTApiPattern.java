package com.distributedhashtable.nodefactory;

public class ExposedDHTApiPattern {
	
	public ExposedDHTApi getInstance() {
		
		return Dispatcher.getInstance();
	}

}
