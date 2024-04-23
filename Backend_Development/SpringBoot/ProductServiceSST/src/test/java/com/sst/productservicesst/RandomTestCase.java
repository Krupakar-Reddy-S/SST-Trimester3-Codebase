package com.sst.productservicesst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomTestCase {

    @Test
	void sampleTestCase() {

	}

	@Test
	void testIsOnePlusOneTwo() {
		// 3 A's of Testing: Arrange, Act, Assert

		// Arrange + Act
		int i = 1 + 1;

		// Assert
		// assert i == 3;

		// if i is 2 assert will pass else it will fail
		assertEquals(2, i, "i value is not 2, thats why test is failing");

		// this throws an exception for the given condition
		// assertThrows(RuntimeException.class,
		// 		fun(100));

		// this will pass the test case
		// assertFalse(false);
	}

	@Test
	void testIsTwoIntoTwoFour() {
		int i = 2 * 2;

		assert i == 4;
	}

}
