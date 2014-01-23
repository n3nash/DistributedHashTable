package com.distributedhashtable.nodefactory;

import java.util.HashMap;

public interface ExposedDHTApi {
	public int putData(String key,String value);
	public HashMap<String,String> getData(String key);
}
