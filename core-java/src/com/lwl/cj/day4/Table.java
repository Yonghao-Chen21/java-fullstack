package com.lwl.cj.day4;

import java.util.Scanner;

public class Table {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the N value :");
		int n = sc.nextInt();
		
		int i=1;
		while(i<=10) {
			System.out.println(n+" * "+i+" = "+(n*i));
			i++;
		}
		
		sc.close();
	}
}
