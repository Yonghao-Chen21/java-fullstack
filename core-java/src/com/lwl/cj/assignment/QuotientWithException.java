
package com.lwl.cj.assignment;

import java.util.Scanner;

public class QuotientWithException {
	public static int quotient(int number1, int number2) {
		if (number2 == 0)
			//The exception is an object created from an exception class
			throw new ArithmeticException("Divisor cannot be zero");

		return number1 / number2;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter two integers
		System.out.print("Enter two integers: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		input.close();

		try {
			int result = quotient(number1, number2);
			System.out.println(number1 + " / " + number2 + " is " + result);
		} catch (ArithmeticException ex) {
			//catch handle the exception. ex is the exception identifier, catch�block parameter
			System.out.println("Exception: an integer " + "cannot be divided by zero ");
			//after execution statements in catch block, statements after the catch block are executed
		}

		System.out.println("Execution continues ...");
	}
}