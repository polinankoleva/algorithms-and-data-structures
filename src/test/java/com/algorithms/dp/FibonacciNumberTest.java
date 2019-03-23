package com.algorithms.dp;

import static com.tasks.dp.FibonacciNumber.dpFibonacciNumber;
import static com.tasks.dp.FibonacciNumber.fibonacciNumber;

import org.junit.Assert;
import org.junit.Test;

import com.tasks.dp.FibonacciNumber;

/**
 * Test cases for {@link FibonacciNumber}.
 * 
 * @author Polina Koleva
 *
 */
public class FibonacciNumberTest {

	@Test
	public void fibonacciNumberTest() {
		// base cases
		Assert.assertEquals(1, fibonacciNumber(1));
		Assert.assertEquals(1, fibonacciNumber(2));

		// small number
		Assert.assertEquals(5, fibonacciNumber(5));
		// large number
		Assert.assertEquals(832040, fibonacciNumber(30));
	}

	@Test
	public void dpFibonacciNumberTest() {
		// base cases
		Assert.assertEquals(1, dpFibonacciNumber(1));
		Assert.assertEquals(1, dpFibonacciNumber(2));

		// small number
		Assert.assertEquals(5, dpFibonacciNumber(5));
		// large number
		Assert.assertEquals(832040, dpFibonacciNumber(30));

	}
}
