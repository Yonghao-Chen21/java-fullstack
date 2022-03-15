package com.lwl.cj.day18;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapManager {

		public static void main(String[] args) {
			
			
				Map<String,Integer> map = new HashMap<String, Integer>();
				map.put("krish", 35);
				map.put("manoj", 38);
				map.put("krish", 37);
				map.put("john",  35);
				map.put("nareen", 38);
				
				Set<String> keys = map.keySet();
				for(String key : keys) {
					System.out.println(key+" "+map.get(key));
				}
				
				Collection<Integer> values = map.values();
				for(Integer val:values) {
					System.out.println(val);
				}
				
				Set<Entry<String, Integer>> entrySet = map.entrySet();
				for(Entry<String, Integer> entry:entrySet) {
					System.out.println(entry.getKey()+" "+entry.getValue());
				}
				
				map.entrySet().forEach(e->{
					System.out.println(e.getKey()+" "+e.getValue());
				});
				
				
				System.out.println(map.get("charan"));
				
				// If charan is not present add charan with age 37
				
				
				map.putIfAbsent("charan", 37);
				
				
				if(map.get("charan")==null) {
					map.put("charan", 37);
				}
				
				// If charan  present increment age by 2 years
				
				if(map.get("charan")!=null) {
					int val = map.get("charan");
					val += 2;
					map.put("charan", val);
				}
				
		}
}
