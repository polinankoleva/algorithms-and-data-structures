package com.algorithms.data.structures.heap;

import org.junit.Assert;
import org.junit.Test;

import com.data.structures.heap.MaxHeap;

/**
 * Test cases for {@link MaxHeap}.
 * 
 * @author Polina Koleva
 *
 */
public class MaxHeapTest {

	@Test
	public void buildMaxHeapTest() {
		int[] actual = { 1, 3, 5, 7 };
		MaxHeap maxheap = new MaxHeap(actual);
		int[] expected = { 7, 3, 5, 1 };
		Assert.assertArrayEquals(expected, actual);
		

		actual = new int[] { 16, 14, 10, 8, 7, 9, 3, 2, 4, 1 };
		
		expected = new int[] { 16, 14, 10, 8, 7, 9, 3, 2, 4, 1 };
		Assert.assertArrayEquals(expected, actual);

		actual = new int[] { 45, 13, 2, 4, 7, 3, 25, 8, 15, 1 };
		maxheap = new MaxHeap(actual);
		expected = new int[] { 45, 15, 25, 13, 7, 2, 3, 4, 8, 1 };
		Assert.assertArrayEquals(expected, actual);

	}
}
