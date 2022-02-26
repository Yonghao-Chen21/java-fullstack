package com.lwl.cj.day8;

import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.System.out;


public class StaticBlockExample {
	

	static {
		out.println("Static Block-1");
	}
	static {
		out.println("Static Block-3");
	}

	public static void main(String[] args) {
		out.println("Main method");
		out.println(PI);
		out.println(sqrt(9));
		out.println(pow(2, 5));
		out.println("Some random text");
	}

	static {
		out.println("Static Block-2");
	}
	
	static class Inner{
		
	}
}
