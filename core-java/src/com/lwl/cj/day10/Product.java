package com.lwl.cj.day10;

public class Product {

	private int pid;
	private String pname;
	private double price;
	private double discount;
	private String description;
	private static int count = 0;

	{
		System.out.println("IIB");
		count++;
	}
	static {
		System.out.println("Static Block");
	}
	public Product(int pid, String pname, double price) {
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}

	public Product(int pid, String pname, double price, double discount) {
		this(pid, pname, price);
		this.discount = discount;
	}
	
	public Product(int pid, String pname, double price, double discount,String description) {
		this(pid, pname, price, discount);
		this.setDescription(description);
	}

	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static int getCount() {
		return count;
	}

}
