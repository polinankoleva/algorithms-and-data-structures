package com.tasks.sorting;

import java.io.IOException;

/**
 * You are given tow sorted arrays A and B, where A has a large enough buffer at
 * the end to hold B. Write a method to merge B into A in sorted order.
 * 
 * @author Polina Koleva
 *
 */
public class SortedMerge {
	
	public static int[] sortedMerge(int[] a, int numbersInA, int[] b) {
		if(numbersInA == 0) return b;
		int aEnd = a.length - 1;
		int bPointer = b.length - 1;
		int aPointer = numbersInA - 1;
		while (bPointer >= 0 && aPointer >= 0) {
			if (a[aPointer] >= b[bPointer]) {
				a[aEnd] = a[aPointer];
				aPointer--;
				aEnd--;
			} else {
				a[aEnd] = b[bPointer];
				bPointer--;
				aEnd--;
			}
		}
		while(bPointer>=0) {
			a[aEnd] = b[bPointer];
			aEnd--;
			bPointer--;	
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
		int[] a = new int[7];
		a[0] = 5;
		a[1] = 7;
		a[2] = 11;
		a[3] = 12;
		int[] b = new int[3];
		b[0] = 1;
		b[1] = 2;
		b[2] = 3;
//		b[3] = 15;
//		b[4] = 18;
		int[] result = sortedMerge(a, 4, b);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
