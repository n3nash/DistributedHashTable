package com.distributedhashtable.nodefactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;

public class HashingFunction {

	final static private int hashRange = 1<<160;
	static int numberOfNodes = 0;
	
	public static int HashValue(String randInt) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1"); 
			//BigInteger bigInteger = BigInteger.valueOf(randInt);
			byte [] hash = randInt.getBytes();//toByteArray();
			return Integer.parseInt(digest.digest(hash).toString());//hashRange % numberOfNodes;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return numberOfNodes;
		
	}
	
	public static int generateRandomSocket() {
		Random random = new Random();
		return Math.abs(random.nextInt()%65536);
	}
	
}
