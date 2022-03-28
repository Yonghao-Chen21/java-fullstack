package com.lwl.cj.day22;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class DateTimeExample {

	public static void main(String[] args) {

		String[] names = "SB-1001,SB-1002,SB-1003,SB-1004,SB-1005".split(",");

		for (int j = 0; j <= 22; j++) {
			LocalDate today = LocalDate.now().plusDays(j);
			String region = "SA";
			for (int i = 0; i < names.length; i++) {
				String name = names[i];
				float ret = ThreadLocalRandom.current().nextFloat();
				System.out.println(today+","+name+","+region+","+ret);
			}
		}

		// Name,amount (Per hour), whours

		// name,amount,stime,etime, payment

	}
}
