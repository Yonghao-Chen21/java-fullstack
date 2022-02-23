package com.lwl.cj.day5;

import java.util.Scanner;

public class SwitchExample {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the num1 :");
		int num1 = sc.nextInt();
		System.out.println("Enter the num2 :");
		int num2 = sc.nextInt();

		while (true) {
			System.out.println("1.Add 2.Sub 3.Mul 4.Exit");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				int sum = add(num1,num2);
				System.out.println(num1 + " + " + num2 + " = " + sum);
				break;
			case 2 :
				int sub = num1 - num2;
				System.out.println(num1 + " - " + num2 + " = " + sub);
				break;
			case 3:
				int mul = num1 * num2;
				System.out.println(num1 + " * " + num2 + " = " + mul);
				break;
			case 4:
				sc.close();
				System.exit(0);
			default:
				System.out.println("Please enter only 1-4");

			}
		}
	}

	public static int add(int num1,int num2) {
		return num1 + num2;
	}
}
