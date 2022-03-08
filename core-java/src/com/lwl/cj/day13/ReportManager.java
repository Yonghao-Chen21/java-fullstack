package com.lwl.cj.day13;


// static,default -> 1.8

interface Greetings{
		void greet();
}
class BirthdayGreetings implements Greetings{
	
		@Override
		public void greet() {
			System.out.println("Many many happy returns of the day!");
			
		}
}
class GenericGreetings implements Greetings{

	@Override
	public void greet() {
			System.out.println("Congratulations...... ");
	}
	
}


public class ReportManager {

		public static void main(String[] args) {
			
				Greetings obj = new GenericGreetings(); //new BirthdayGreetings();
				obj.greet();
		}
}
