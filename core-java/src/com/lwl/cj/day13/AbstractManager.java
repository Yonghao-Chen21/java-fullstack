package com.lwl.cj.day13;

abstract class Three {
	abstract void m2();
}

// abstract class doesn't have to have an abstract method
// if one abstract class extends a abstract class, it doesn't have to override its method  
abstract class One extends Three {

	private int x = 10;

	One(){
		System.out.println("One empty Constructor");
	}
	
	One(int x) {
		this.setX(x);
		System.out.println("One Constructor");
	}

	public void m1() {
		System.out.println("M1 of One + x");
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
}

class Two extends One {
	private int x = 100;

	Two() {
		//super(999);
		//setX(90);
		System.out.println("Two Constructor");
	}

	public void m1() {
		System.out.println("M1 of Two + " + getX() + " " + this.x);
		// if u add setter and getter , get 100 for both
	}

	@Override
	void m2() {
		System.out.println("M2 of Two + " + getX() + " " + this.x);
	}
}

class Four extends Three {
	int x = 100;
	
	public void m1() {
		System.out.println("M1 of Two + " + x);
	}

	@Override
	void m2() {
		System.out.println("M2 of Two + " + x);
	}
}

public class AbstractManager {

	public static void main(String[] args) {

		Three obj = getInstance();
		
		if (obj instanceof Two) {
			Two ref = (Two)obj;
			ref.m1();
			ref.m2();
			System.out.println(ref.getX());// because local variable x is not override,  so it's bound with x in super class, getX() return 10
			System.out.println("----------------------------");
		}
		
		One obj1 = new Two();
		System.out.println(obj1.getX());
		obj1.m1();
		obj1.m2();		
		System.out.println(((Two)obj1).getX()); // type casting
		
	}

	private static Three getInstance() {
		
		return new Two();
		//return new Four();
	}
}
