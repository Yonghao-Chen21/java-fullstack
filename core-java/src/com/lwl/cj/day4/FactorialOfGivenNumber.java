package com.lwl.cj.day4;

import java.util.Scanner;

public class FactorialOfGivenNumber {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the N value :");
			int N = sc.nextInt();
			
			int fact = 1;
			int i= N;
			while(i>=2) {
				fact = fact * i;
				i--;
			}
			
			System.out.println("Factorial of :"+N+" is "+fact);
			sc.close();
		}
}
