package com.lwl.cj.day19;

import java.util.Scanner;



public class ExceptionsDemo {

	public static void main(String[] args) {

		
		
		try(Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the num1: ");
			int num1 = sc.nextInt();
			System.out.println("Enter the num2: ");
			int num2 = sc.nextInt();
			int res = num1 / num2;
			System.out.println("Result :" + res);
			System.out.println("End of main method");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
