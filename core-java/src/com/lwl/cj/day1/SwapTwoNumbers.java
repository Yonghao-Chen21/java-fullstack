package com.lwl.cj.day1;

/*
 * Program to accept two numbers from the user and swap those numbers
 */
import java.util.Scanner;

public class SwapTwoNumbers {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the num1 :");
		int num1 = sc.nextInt();
		System.out.println("Enter the num2 :");
		int num2 = sc.nextInt();
		System.out.println("Before swap num1 = " + num1 + " and num2 = " + num2);

		// Logic to swap two numbers without temp variable
		num1 = num1 + num2;
		num2 = num1 - num2;
		num1 = num1 - num2;

		System.out.println("After swap num1 = " + num1 + " and num2 = " + num2);
		sc.close();
	}
}
