package com.lwl.cj.day12;

class C1 {
	static{
		System.out.println("Static C1");
	}
	int x = 10;
	{
		System.out.println("IIB C1" + x);
	}
	C1() {
		super();
		//IIB
		System.out.println("Constructor of c1");
	}
}

class C2 extends C1 {
	static{
		System.out.println("Static C2");
	}
	int x = 20; // Instance variables
	{
		System.out.println("IIB C2" + x);
	}
	C2() {
		super();
		//IIB
		System.out.println("Constructor of c2");
	}
}

public class ConstructorChainManager {

		public static void main(String[] args) {
			
				C1 obj1 = new C2();
				//C2 obj2 = new C2();
				
		}
}
