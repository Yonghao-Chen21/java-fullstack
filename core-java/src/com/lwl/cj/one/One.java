package com.lwl.cj.one;

public class One {

	public int pub_a = 10;
	protected int pro_b = 20;
	int def_c = 30;
	private int pri_d = 40;
	
	public void showValues() {
		System.out.println(pub_a);
		System.out.println(pro_b);
		System.out.println(def_c);
		System.out.println(pri_d);
	}
}
