package com.algorithms;

import org.junit.Assert;
import org.junit.Test;
import static com.algorithms.Sorting.vanillaInsertionSort;
import static com.algorithms.Sorting.merge;
import static com.algorithms.Sorting.mergeSort;
import static com.algorithms.Sorting.bubbleSort;
import static com.algorithms.Sorting.quickSort;
import static com.algorithms.Sorting.selectionSort;

/**
 * Test cases for {@link Sorting} class functionality.
 * 
 * @author Polina Koleva
 *
 */
public class SortingTest {

	@Test
	public void vanillaInsertionSortTest() {
		int[] arr = { 1, 7, 3, 5 };
		int[] expArr = { 1, 3, 5, 7 };
		Assert.assertArrayEquals(expArr, vanillaInsertionSort(arr));

		arr = new int[] { 2, 3, 4, 5, 6 };
		expArr = new int[] { 2, 3, 4, 5, 6 };
		Assert.assertArrayEquals(expArr, vanillaInsertionSort(arr));

		arr = new int[] { 6, 5, 4, 3, 2, 1 };
		expArr = new int[] { 1, 2, 3, 4, 5, 6 };
		Assert.assertArrayEquals(expArr, vanillaInsertionSort(arr));

		arr = new int[] { 2, 1 };
		expArr = new int[] { 1, 2 };
		Assert.assertArrayEquals(expArr, vanillaInsertionSort(arr));

		arr = new int[] { 1, 3, 1 };
		expArr = new int[] { 1, 1, 3 };
		Assert.assertArrayEquals(expArr, vanillaInsertionSort(arr));
	}

	@Test
	public void mergeTest() {
		int[] left = { 1, 3, 4, 5 };
		int[] right = { 1, 2, 5, 7 };
		int[] expArr = { 1, 1, 2, 3, 4, 5, 5, 7 };
		Assert.assertArrayEquals(expArr, merge(left, right));

		// single elements in the arrays
		left = new int[] { 1 };
		right = new int[] { 113 };
		expArr = new int[] { 1, 113 };
		Assert.assertArrayEquals(expArr, merge(left, right));

		// duplicates
		left = new int[] { 1 };
		right = new int[] { 1 };
		expArr = new int[] { 1, 1 };
		Assert.assertArrayEquals(expArr, merge(left, right));

		// two consecutive arrays
		left = new int[] { 5, 6, 7, 8, 9 };
		right = new int[] { 1, 2, 3, 4, 5 };
		expArr = new int[] { 1, 2, 3, 4, 5, 5, 6, 7, 8, 9 };
		Assert.assertArrayEquals(expArr, merge(left, right));

		// one empty array
		left = new int[] {};
		right = new int[] { 1 };
		expArr = new int[] { 1 };
		Assert.assertArrayEquals(expArr, merge(left, right));

		// empty arrays
		left = new int[] {};
		right = new int[] {};
		expArr = new int[] {};
		Assert.assertArrayEquals(expArr, merge(left, right));
	}
	
	@Test
	public void mergeSortTest() {
		int[] arr = { 1, 7, 3, 5 };
		int[] expArr = { 1, 3, 5, 7 };
		Assert.assertArrayEquals(expArr, mergeSort(arr, 0, arr.length - 1));

		arr = new int[] { 2, 3, 4, 5, 6 };
		expArr = new int[] { 2, 3, 4, 5, 6 };
		Assert.assertArrayEquals(expArr, mergeSort(arr, 0, arr.length - 1));

		arr = new int[] { 6, 5, 4, 3, 2, 1 };
		expArr = new int[] { 1, 2, 3, 4, 5, 6 };
		Assert.assertArrayEquals(expArr, mergeSort(arr, 0, arr.length - 1));

		arr = new int[] { 2, 1 };
		expArr = new int[] { 1, 2 };
		Assert.assertArrayEquals(expArr, mergeSort(arr, 0, arr.length - 1));

		arr = new int[] { 1, 3, 1 };
		expArr = new int[] { 1, 1, 3 };
		Assert.assertArrayEquals(expArr, mergeSort(arr, 0, arr.length - 1));
	}

	
	@Test
	public void bubleSortTest() {
		int[] arr = { 1, 7, 3, 5 };
		int[] expArr = { 1, 3, 5, 7 };
		Assert.assertArrayEquals(expArr, bubbleSort(arr));

		arr = new int[] { 2, 3, 4, 5, 6 };
		expArr = new int[] { 2, 3, 4, 5, 6 };
		Assert.assertArrayEquals(expArr, bubbleSort(arr));

		arr = new int[] { 6, 5, 4, 3, 2, 1 };
		expArr = new int[] { 1, 2, 3, 4, 5, 6 };
		Assert.assertArrayEquals(expArr, bubbleSort(arr));

		arr = new int[] { 2, 1 };
		expArr = new int[] { 1, 2 };
		Assert.assertArrayEquals(expArr, bubbleSort(arr));

		arr = new int[] { 1, 3, 1 };
		expArr = new int[] { 1, 1, 3 };
		Assert.assertArrayEquals(expArr, bubbleSort(arr));
	}
	
	@Test
	public void quickSortTest() {
		int[] arr = { 1, 7, 3, 5 };
		int[] expArr = { 1, 3, 5, 7 };
		quickSort(arr, 0 , arr.length - 1);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 2, 3, 4, 5, 6 };
		expArr = new int[] { 2, 3, 4, 5, 6 };
		quickSort(arr, 0 , arr.length - 1);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 6, 5, 4, 3, 2, 1 };
		expArr = new int[] { 1, 2, 3, 4, 5, 6 };
		quickSort(arr, 0 , arr.length - 1);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 2, 1 };
		expArr = new int[] { 1, 2 };
		quickSort(arr, 0 , arr.length - 1);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 1, 3, 1 };
		expArr = new int[] { 1, 1, 3 };
		quickSort(arr, 0 , arr.length - 1);
		Assert.assertArrayEquals(expArr, arr);
	}
	
	
	@Test
	public void selectionSortTest() {
		int[] arr = { 1, 7, 3, 5 };
		int[] expArr = { 1, 3, 5, 7 };
		selectionSort(arr);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 2, 3, 4, 5, 6 };
		expArr = new int[] { 2, 3, 4, 5, 6 };
		selectionSort(arr);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 6, 5, 4, 3, 2, 1 };
		expArr = new int[] { 1, 2, 3, 4, 5, 6 };
		selectionSort(arr);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 2, 1 };
		expArr = new int[] { 1, 2 };
		selectionSort(arr);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 1, 3, 1 };
		expArr = new int[] { 1, 1, 3 };
		selectionSort(arr);
		Assert.assertArrayEquals(expArr, arr);
	}
}
