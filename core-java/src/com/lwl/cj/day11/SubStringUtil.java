package com.lwl.cj.day11;

public class SubStringUtil {

	// For given string return first N characters
	// For given String return characters in range
	// For given String return characters from the given index
//	
//		"Corejava" , 3   => Cor
//		"Corejava" , 1,3 => ore
//		"CoreJava", 2 => reJava

	public String subString(String str, int n) {
		return str.substring(0,n+1);
	}

	public String subString(String str, int s, int e) {
		return str.substring(s,e+1);
	}

	public String subStringFromGivenIndex(String str, int n) {
		return str.substring(n);
	}

}
