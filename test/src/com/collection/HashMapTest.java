package com.collection;

import java.util.HashMap;
import java.util.Iterator;

public class HashMapTest {
	public static void main(String[] args){
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		hm.put("1", 1);
		hm.put("2", 2);
		hm.put("3", 3);
		
		System.out.println(hm.size());
		System.out.println(hm.get("1")); //输出null
		
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			System.out.println("Key=" + key + " value=" + hm.get(key));
		}
		
				
				
	}
}
