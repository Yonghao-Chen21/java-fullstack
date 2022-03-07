package com.lwl.cj.day11;

class One{
	
	public A showShape() throws RuntimeException{
		System.out.println("Some shape");
		return null;
	}
}
class Two extends One{
	
	@Override
	public C showShape() throws ArithmeticException{
		System.out.println("Some shape");
		return null;
	}
	
	public void showShape(String color) {
		System.out.println("Circle");
	}
	
}


class A{
	
}
class B extends A{
	
}
class C extends B{
	
}

class D{
	
}
// covarient

class Three extends One{
	@Override
	public B showShape() {
		System.out.println("Triangle");
		return null;
	}
}



public class Employee{

			private int empno;
			private String name;
			private double salary;
			
			public Employee(int empno, String name, double salary) {
				this.empno = empno;
				this.name = name;
				this.salary = salary;
			}
			
			@Override
			public String toString() {
				return String.format("[Employee - Empno %s,Name %s and Salary %s]",empno, name,salary); 
			}
			
			public static void main(String[] args) {
				
					Two obj = new Two();
					obj.showShape();
			}
			
}
