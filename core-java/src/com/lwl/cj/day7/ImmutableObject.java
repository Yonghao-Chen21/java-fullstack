package com.lwl.cj.day7;

public class ImmutableObject {

		public static void main(String[] args) {
			
				String[] names = "Krish,Manoj,Jayesh,Suresh,Charan,Kiran".split(",");
				
				StringBuilder message = new StringBuilder("");
				
				for(String name:names) {
					message.append("Welcome "+name+"\n");
				}
				System.out.println(message);
				
				
				
		}
}
