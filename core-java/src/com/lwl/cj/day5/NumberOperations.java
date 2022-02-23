package com.lwl.cj.day5;

import java.util.Scanner;

public class NumberOperations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Enter the num :");
			int num = sc.nextInt();
			System.out.println("1.IsPrime 2. Factorial 3.Reverse 4. isAmstrong");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				boolean res=isPrime(num);
				System.out.println(num +" is prime :"+res);
				break;
			case 2:

				break;
				
			default:
				break;
			}
			
			System.out.println("Do you want to continue (0-Exit)");
			int choice = sc.nextInt();
			if(choice==0) {
				sc.close();
				System.out.println("Thank you...... ");
				break;
			}
			
		}
	}

	private static boolean isPrime(int num) {

		return true;
	}

	private static int factorial(int num) {

		return 0;
	}

	private static int reverse(int num) {

		return 0;
	}

	private static boolean isAmstrong(int num) {

		return true;
	}

}
