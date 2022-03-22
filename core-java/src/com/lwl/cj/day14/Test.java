package com.lwl.cj.day14;

class A {
    public static void display() {
        System.out.println("Inside static method of superclass");
    }
}

class B extends A {
    public void show() {
        display();
    }

	
//	  public static void display() {
//	  System.out.println("Inside static method of this class"); }
	 
}

public class Test {
    public static void main(String[] args) {

        // superclass static method could be hidden if there is the same signature  
    	// prints: Inside static method of this class
        B.display();
        B obj = new B();
        obj.show();

 
        // prints: Inside static method of superclass
        A.display();
    }
}