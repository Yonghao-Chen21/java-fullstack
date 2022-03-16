package com.lwl.cj.day20;






public class ThrowExample {

	
		public static void main(String[] args) {
				System.out.println("Start of main method");
				try {
					int div = res(10,0);
					System.out.println(div);
				}catch (ArithmeticException e) {
					e.printStackTrace();
				}
				System.out.println("End of main method");
		}
		
		private static int res(int a,int b) {
			
				if(b == 0) {
					throw new ArithmeticException("Value of b can't be zero");
				}
				return a / b;
		}
}
