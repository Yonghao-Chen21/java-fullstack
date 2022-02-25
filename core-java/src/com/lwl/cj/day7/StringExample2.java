package com.lwl.cj.day7;

public class StringExample2 {

	public static void main(String[] args) {

		String name = "COREJAVA";
		System.out.println(name.length());

		for (int i = name.length() - 1; i >= 0; i--) {
			System.out.println(name.charAt(i));
		}

		String str = "One,123,12321, MOM ,liriL ,Johoj,charan";
		String delimiter = ",";
		
		String data = "KRISH,Charan,Jayesh,Mahesh,Suresh";
		
		for(String ele:data.split(",")) {
			System.out.println(ele.substring(0, 3).toUpperCase());
		}
		
		
	}
	
	public static void subString(String data,int size) {
		//data = "javaisfun" size = 5; javai, avais,vasis,aisfu,isfun 
	}

	public static int countPalindrome(String data, String delimiter) {
		int count = 0;
		String[] arr = data.split(delimiter);
		for (String ele : arr) {
			String name = ele.trim().toLowerCase();
			if (isPalindrome(name)) {
				count++;
			}
		}
		return count;
	}

	public static boolean isPalindrome(String str) {

		for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}
