package com.lwl.cj.day14;

interface One {
	//data field : public static final by default
	public static int x = 1;
	void m1();  // method: public abstract by default
	// if u add default before a method in interface, 
	// you could implement it or not, and the concrete subclass
	// doesn't have to override this method. 
	default void m3() {
		m1();
	}
}

class OneImpl implements One{

	@Override
	public void m1() {
		System.out.println("M1 Method of OneImpl");
	}

}

abstract class AbstractGame{
		
		public abstract void start();
		public void play() {
			start();
			//Logic
			stop();
		}
		public abstract void stop();
		
}
class Bike extends AbstractGame{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	
}

public class InterfaceManager {

		public static void main(String[] args) {
			
			One obj = new OneImpl();
			obj.m3();
		}
}
