package com.lwl.cj.day8;

class One{
	 void showGreetings() {
		System.out.println("Hello");
	}
}
class Two extends One{
	void showGreetings() {
		System.out.println("Welcome to java world");
	}
}

public class StaticFinalVariables {
	
		
		static final int maxCount;

		static int num= 10;
		final int sum;
		static {
			maxCount = 3;
		}
		public StaticFinalVariables() {
			sum = 10;
			System.out.println("Constructor");
		}
		public static void main(final String[] args) {
		
			int num = 100;
			System.out.println("Main method");
			StaticFinalVariables obj1 = new StaticFinalVariables();
			StaticFinalVariables obj2 = new StaticFinalVariables();
			System.out.println(num);
			
			
		}
		
		public final int sum(int a,int b) {
			return a + b;
		}
		
		
		
		
		public static int getConnectionCount() {
			return 10;
		}
		
}
