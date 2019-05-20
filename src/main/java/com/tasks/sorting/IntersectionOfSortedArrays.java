package com.tasks.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program which takes as input two sorted arrays, and returns a new
 * array containing elements that are present in both of the input arrays. The
 * input arrays may have duplicate entries, but the returned array should be
 * free of duplicates. For example, the input is (2, 3, 3, 5, 5, 6, 7, 7, 8, 12}
 * and (5,5,6,8,8,9,10,10), your output should be (5, 6, 8). Task 14.1, EPI book
 * 
 * @author Polina Koleva
 *
 */
public class IntersectionOfSortedArrays {
	// O(m+n) complexity
	// if one array is way smaller that the other, for each unique value in the
	// smaller array,
	// we can do binary search in the longer array - time complexity O(nlogm)
	public static List<Integer> intersection(int[] a, int[] b) {
		List<Integer> result = new ArrayList<>();
		if (a == null || b == null)
			return result;
		if (b.length > 0 && a[a.length - 1] < b[0])
			return result;
		Integer lastAdded = null;
		int aPointer = 0;
		int bPointer = 0;
		while (aPointer < a.length && bPointer < b.length) {
			int aCurrent = a[aPointer];
			int bCurrent = b[bPointer];
			if (aCurrent == bCurrent) {
				if (lastAdded == null) {
					lastAdded = aCurrent;
					result.add(aCurrent);
				} else {
					if (lastAdded != aCurrent) {
						lastAdded = aCurrent;
						result.add(aCurrent);
					}
				}
				aPointer++;
				bPointer++;
			} else if (aCurrent < bCurrent) {
				aPointer++;
			} else {
				bPointer++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 2, 4 };
		int[] b = new int[] { 2, 3, 4, 4 };
		// expected 2,4
		List<Integer> result = intersection(a, b);
		for (Integer i : result) {
			System.out.println(i);
		}
		System.out.println("-------");
		a = new int[] { 2, 3, 3, 5, 5, 6, 7, 7, 8, 12 };
		b = new int[] { 5, 5, 6, 8, 8, 9, 10, 10 };
		// expected 5,6,8
		result = intersection(a, b);
		for (Integer i : result) {
			System.out.println(i);
		}

		System.out.println("-------");
		a = new int[] {};
		b = new int[] {};
		// expected nothing
		result = intersection(a, b);
		for (Integer i : result) {
			System.out.println(i);
		}
		System.out.println("-------");
		a = new int[] { 1, 2, 2, 3 };
		b = new int[] {};
		// expected nothing
		result = intersection(a, b);
		for (Integer i : result) {
			System.out.println(i);
		}
		System.out.println("-------");
		a = new int[] { 1, 2, 2, 3 };
		b = new int[] {};
		// expected nothing
		result = intersection(a, b);
		for (Integer i : result) {
			System.out.println(i);
		}
	}

}
