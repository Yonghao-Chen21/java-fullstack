package com.lwl.cj.two;

import com.lwl.cj.one.One;

public class Five extends One {
	One obj = new One();
	public void showValues() {
		System.out.println(obj.pub_a);
		//System.out.println(obj.pro_b);
		//System.out.println(obj.def_c);
		//System.out.println(obj.pri_d);
	}
}
