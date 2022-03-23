package com.careerit.iplstat;

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
			
			
}
