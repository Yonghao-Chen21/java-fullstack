package com.lwl.cj.day13;

abstract class Three {
	abstract void m2();
}

abstract class One extends Three {

	int x = 10;

	One(int x) {
		this.x = x;
		System.out.println("One");
	}

	public void m1() {
		System.out.println("M1 of One");
	}
}

class Two extends One {
	int x = 100;

	Two() {
		super(999);
		this.x = 90;
	}

	public void m1() {
		System.out.println("M1 of Two");
	}

	@Override
	void m2() {
		System.out.println("M2 of Two");
	}
}

class Four extends Three {
	int x = 100;
	
	public void m1() {
		System.out.println("M1 of Two");
	}

	@Override
	void m2() {
		System.out.println("M2 of Two");
	}
}

public class AbstractManager {

	public static void main(String[] args) {

		Three obj = getInstance();
		
		if (obj instanceof Two) {
			Two ref = (Two)obj;
			ref.m1();
			ref.m2();
		}
		
		One obj1 = new Two();
		System.out.println(obj1.x);
		
	}

	private static Three getInstance() {
		
		return new Two();
		//return new Four();
	}
}
