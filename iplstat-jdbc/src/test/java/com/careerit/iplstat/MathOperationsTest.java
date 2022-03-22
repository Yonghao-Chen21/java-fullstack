package com.careerit.iplstat;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MathOperationsTest {

	@Test
	public void maxWithFirstNumber() {
		MathOperations obj = new MathOperations();
		int a = 10;
		int b = 5;
		int expected = 10;
		assertEquals(expected, obj.max(a, b));
	}

	@Test
	public void maxWithSecondNumber() {
		MathOperations obj = new MathOperations();
		int a = 5;
		int b = 10;
		int expected = 10;
		assertEquals(expected, obj.max(a, b));
	}

	@Test
	public void maxWithEqualsNumbers() {
		MathOperations obj = new MathOperations();
		int a = 10;
		int b = 10;
		int expected = 10;
		assertEquals(expected, obj.max(a, b));
	}

	@Test
	public void maxWithThreeNumbers() {
		MathOperations obj = new MathOperations();
		int a = 4;
		int b = 10;
		int c = 8;
		int expected = 10;
		assertEquals(expected, obj.max(a, b, c));
	}

	@Test
	public void primesArray() {
		MathOperations obj = new MathOperations();
		int lb = 1;
		int ub = 10;
		int[] expected = { 2, 3, 5, 7 };
		assertArrayEquals(expected, obj.getPrimes(lb, ub));
	}
	
	@Test
	public void reverseTest() {
		MathOperations obj = new MathOperations();
		int n = 12345;
		int expected = 54321;
		assertEquals(expected, obj.reverse(n));
	}

}
