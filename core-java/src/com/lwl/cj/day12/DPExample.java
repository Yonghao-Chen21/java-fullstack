package com.lwl.cj.day12;

class M1 {

	void m1() {
		System.out.println("M1 of m1");
	}
}

class M2 extends M1 {
	
	void m2() {
		System.out.println("M2 of m2");
	}
}

class M3 extends M2 {

}

public class DPExample {

		public static void main(String[] args) {
			
				M1 obj1 = new M2();
				
				M2 obj2 = (M2) obj1;
				obj2.m1();
				obj2.m2();
				
				
		}
}
