package com.lwl.cj.day18;

import java.util.HashMap;
import java.util.Map;

public class WordCountManager {

	public static void main(String[] args) {

		String data = "Java,Python,Java,Python,Java,.Net,MongoDB,MySQL,Java,Java,.Net,Python";

		// Count the occurrence of each word

		String[] arr = data.split(",");

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String ele : arr) {
			map.putIfAbsent(ele, 0);
			map.put(ele,map.get(ele)+1);
		}
		map.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + "   " + entry.getValue());
		});
	}
}
