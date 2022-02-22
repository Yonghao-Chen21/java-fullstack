package com.lwl.cj.day2;

import java.util.Scanner;

public class BiggestOfThreeNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the num1:");
		int num1 = sc.nextInt();
		System.out.println("Enter the num2: ");
		int num2 = sc.nextInt();
		System.out.println("Enter the num3: ");
		int num3 = sc.nextInt();
		int res = biggest(num1, num2, num3);
		System.out.println("Biggest is: " + res);
		sc.close();
	}

	public static int biggest(int a, int b, int c) {

//		int big = 0;
//		if (a > b && a > c) {
//			big = a;
//		} else if (b > c) {
//			big = b;
//		} else {
//			big = c;
//		}
//		return big;

		return (a > b && a > c) ? a : (b > c) ? b : c;

	}
}
