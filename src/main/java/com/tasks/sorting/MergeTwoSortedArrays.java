package com.tasks.sorting;

/**
 * Suppose you are given two sorted arrays of integers. If one array has enough
 * empty entries at its end, it can be used to store the combined entries of the
 * two arrays in sorted order. For example, consider (5, 13, 17) and
 * (3,7,11,19,_,_,_,_,_), where _ denotes an empty entry. Then the combined
 * sorted entries can be stored in the first array as (3, 5, 7, 11, 13, 17, 19,
 * _,_).
 * 
 * Write a program which takes as input two sorted arrays of integers, and
 * updates the first to the combined entries of the two arrays in sorted order.
 * Assume the first array has enough empty entries at its end to hold the
 * result.
 * 
 * Task 14.2, EPI book
 * 
 * @author Polina Koleva
 *
 */
public class MergeTwoSortedArrays {

	// O(m+n) complexity, where m and n are the size of the arrays
	public static int[] merge(int[] a, int aSize, int[] b, int bSize) {
		int insertPointer = aSize + bSize - 1;
		int bPointer = bSize - 1;
		int aPointer = aSize - 1;
		while (bPointer >= 0 && aPointer >= 0) {
			int aCurrent = a[aPointer];
			int bCurrent = b[bPointer];
			if (aCurrent > bCurrent) {
				a[insertPointer] = aCurrent;
				insertPointer--;
				aPointer--;
			} else {
				a[insertPointer] = bCurrent;
				insertPointer--;
				bPointer--;
			}
		}
		while (bPointer >= 0) {
			a[insertPointer] = b[bPointer];
			bPointer--;
			insertPointer--;
		}
		return a;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 5, 13, 17, 0, 0, 0, 0, 0 };
		int[] b = new int[] { 3, 7, 11, 19 };
		// expected 5,7,11,13,17,19, 0
		int[] result = merge(a, 3, b, 4);
		for (Integer i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("--------------");
		a = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		b = new int[] { 3, 7, 11, 19 };
		result = merge(a, 0, b, 4);
		for (Integer i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("--------------");
		a = new int[] { 5, 13, 17, 0, 0, 0, 0, 0 };
		b = new int[] {};
		result = merge(a, 4, b, 0);
		for (Integer i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("--------------");
		a = new int[] { 0, 0, 0, 0, 0, 0 };
		b = new int[] {};
		result = merge(a, 0, b, 0);
		for (Integer i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("--------------");
		a = new int[] {};
		b = new int[] {};
		result = merge(a, 0, b, 0);
		for (Integer i : result) {
			System.out.print(i + " ");
		}

		System.out.println();
		System.out.println("--------------");
		a = new int[] { 3, 3, 0, 0, 0 };
		b = new int[] { 3, 3 };
		result = merge(a, 2, b, 2);
		for (Integer i : result) {
			System.out.print(i + " ");
		}
	}
}
