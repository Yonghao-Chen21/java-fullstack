package com.lwl.cj.day2;

import java.util.Scanner;

public class SumAndAverageOfThreeNumbers {

		public static void main(String[] args) {
			
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the num1:");
				int num1 = sc.nextInt();
				System.out.println("Enter the num2: ");
			    int num2 = sc.nextInt();
			    System.out.println("Enter the num3: ");
			    int num3 = sc.nextInt();
			    int sum = num1 + num2 + num3;
				float avg = sum /(float)3;
				System.out.println("Sum the is :"+sum);
				System.out.println("Average is :"+avg);
				sc.close();
		}
}
