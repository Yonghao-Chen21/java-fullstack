package com.lwl.cj.day7;

public class StringExample {
	public static void main(String[] args) {

			String name1 = "Core";
			String name2 = "Core";
			String name3 = new String("Core");
			String name4 = new String("Core");
			
			System.out.println(name1 == name2); //true because "Core" is anonymous object
			System.out.println(name2 == name3); //false because a new obj is created
			System.out.println(name3 == name4); //false 
			System.out.println(name3.equals(name4)); 
			System.out.println(name1.equals(name4));
	}
}
