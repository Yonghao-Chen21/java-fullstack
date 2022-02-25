package com.lwl.cj.day7;

public class StringExample1 {

		public static void main(String[] args) {
				
				
				String stocks="  INFY   -10,TCS  -5,  HCL-8,TATAELAXI-5,GMR   -4,KVRM-6";
				
				String[] data = stocks.split(",");
				
				for(String ele:data) {
					String[] arr = ele.split("-");
					int price = Integer.parseInt(arr[1]);
					
					if(price > 5) {
						System.out.println(arr[0].trim()+"-"+price);
					}
				}
				
				
				
				
				
		}
}
