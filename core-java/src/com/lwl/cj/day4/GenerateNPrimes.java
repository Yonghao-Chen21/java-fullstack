package com.lwl.cj.day4;

import java.util.Scanner;

public class GenerateNPrimes {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the N value :");
		int N = sc.nextInt();
		int count = 0;
		for(int i=1;;i++) {
			if(isPrime(i)) {
				count++;
				System.out.print(i+" ");
			}
			if(count == N) {
				break;
			}
			
		}
		sc.close();
	}

	public static boolean isPrime(int num) {
		if (num < 2)
			return false;
	   if (num % 2 == 0 && num != 2)
			return false;
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
