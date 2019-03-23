package com.algorithms;

import static com.tasks.search.PeakSearch.recursiveFindPeak;
import static com.tasks.search.PeakSearch.recursiveFindPeakCopy;
import static com.tasks.search.PeakSearch.simpleFindPeak;

import org.junit.Assert;
import org.junit.Test;

import com.tasks.search.PeakSearch;

/**
 * Test cases for {@link PeakSearch} class functionality.
 * 
 * @author Polina Koleva
 *
 */
public class PeakSearchTest {

	@Test
	public void simpleFindPeakWithTwoElementsTest() {
		int[] arr1 = { 1, 2 };
		Assert.assertEquals(2, simpleFindPeak(arr1));

		int[] arr2 = { 1, 1 };
		Assert.assertEquals(1, simpleFindPeak(arr2));

		int[] arr3 = { 2, 1 };
		Assert.assertEquals(2, simpleFindPeak(arr3));
	}

	@Test
	public void simpleFindPeakTest() {
		int[] arr1 = { 1, 5, 7, 3 };
		Assert.assertEquals(7, simpleFindPeak(arr1));

		int[] arr2 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Assert.assertEquals(8, simpleFindPeak(arr2));
	}

	@Test
	public void recursiveFindPeakCopyWithTwoElementsTest() {
		int[] arr1 = { 1, 2 };
		Assert.assertEquals(2, recursiveFindPeakCopy(arr1));

		int[] arr2 = { 1, 1 };
		Assert.assertEquals(1, recursiveFindPeakCopy(arr2));

		int[] arr3 = { 2, 1 };
		Assert.assertEquals(2, recursiveFindPeakCopy(arr3));
	}

	@Test
	public void recursiveFindCopyPeakTest() {
		int[] arr1 = { 1, 5, 7, 3 };
		Assert.assertEquals(7, recursiveFindPeakCopy(arr1));

		int[] arr2 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Assert.assertEquals(8, recursiveFindPeakCopy(arr2));
	}

	@Test
	public void recursiveFindPeakWithTwoElementsTest() {
		int[] arr1 = { 1, 2 };
		Assert.assertEquals(2, recursiveFindPeak(arr1, 0, arr1.length - 1));

		int[] arr2 = { 1, 1 };
		Assert.assertEquals(1, recursiveFindPeak(arr2, 0, arr2.length - 1));

		int[] arr3 = { 2, 1 };
		Assert.assertEquals(2, recursiveFindPeak(arr3, 0, arr3.length - 1));
	}

	@Test
	public void recursiveFindPeakTest() {
		int[] arr1 = { 1, 5, 7, 3 };
		Assert.assertEquals(7, recursiveFindPeak(arr1, 0, arr1.length - 1));

		int[] arr2 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Assert.assertEquals(8, recursiveFindPeak(arr2, 0, arr2.length - 1));
	}
}
