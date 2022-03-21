package com.lwl.cj.day21;

public enum TaskManager {
instance;
	
	int value = 10;
	void increment() {
		value++;
	}
	
	void showValue() {
		System.out.println(value);
	}
	public static void main(String[] args) {

			TaskManager obj1 = TaskManager.instance;
			obj1.increment();
			obj1.increment();
			obj1.showValue();
			
			TaskManager obj2 = TaskManager.instance;
			obj2.increment();
			obj2.increment();
			
			obj2.showValue();
	}
}
