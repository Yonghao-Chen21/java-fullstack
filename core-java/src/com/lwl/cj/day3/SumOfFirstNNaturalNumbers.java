package com.lwl.cj.day3;

import java.util.Scanner;

public class SumOfFirstNNaturalNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the num:");
		int num = sc.nextInt();

		System.out.println("Sum =" + sum(num));
		int fact = factorial(num);
		System.out.println("Factorial of = "+num+" is " + fact);
		sc.close();
	}

	public static int sum(int num) {
		int res = 0;
		for (int i = 1; i <= num; i++) {
			res += i;
			// sum = sum + i;
		}
		return res;
	}
	public static int factorial(int num) {
		int fact = 1;
		for(int i=num;i>=1;i--) {
			fact *=  i;
		}
		return fact;
	}
	public static int evenSum(int lb,int ub) {
		int sum = 0;
		for(int i=lb;i<=ub;i++) {	
			
				if(i % 2 == 0) {
					sum = sum + i;
				}
		}
		return sum;
	}
}
