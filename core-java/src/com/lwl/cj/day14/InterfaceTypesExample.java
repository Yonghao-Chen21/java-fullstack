package com.lwl.cj.day14;

// Marker interfaces 
interface I1 {

}

// Cloneable is a marker interface
class Product implements Cloneable {
	int pid;
	String pname;
	double price;

	public Product(int pid, String pname, double price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}

@FunctionalInterface
//lambda expression can only work on functional interface
interface I2 {

	int biggest(int a, int b);
	// use default and it could be materialized 
	default void m1() {
		System.out.println("m1");
	}

}



public class InterfaceTypesExample {

	public static void main(String[] args) throws CloneNotSupportedException {

//		Product p1 = new Product(1, "Dell XPS", 45000);
//		Product p2 = (Product) p1.clone();
//		System.out.println(p1);
//		System.out.println(p2);
		
		I2 obj = (a,b)-> a > b ? a:b; //only if interface has just one abstract method; use this to create an object of subclass with the method quickly.
		System.out.println(obj.biggest(3, 5));
		obj.m1();
	}
}
