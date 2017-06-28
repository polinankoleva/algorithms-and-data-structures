package com.algorithms;

import org.junit.Assert;
import org.junit.Test;
import static com.algorithms.BinarySearch.bs;

/**
 * Test cases for {@link BinarySearch}.
 * 
 * @author Polina Koleva
 *
 */
public class BinarySearchTest {

	@Test
	public void bsTest() {
		int[] arr = { 1, 3, 5, 7 };
		Assert.assertTrue(bs(arr, 0, arr.length - 1, 1));
		Assert.assertTrue(bs(arr, 0, arr.length - 1, 3));
		Assert.assertTrue(bs(arr, 0, arr.length - 1, 5));
		Assert.assertTrue(bs(arr, 0, arr.length - 1, 7));

		Assert.assertFalse(bs(arr, 0, arr.length - 1, 11));
		Assert.assertFalse(bs(arr, 0, arr.length - 1, 2));
		Assert.assertFalse(bs(arr, 0, arr.length - 1, 6));

	}
}
