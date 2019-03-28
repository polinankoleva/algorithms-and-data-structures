package com.tasks.hashing;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Given two arrays of integers, find a pair of values (one value from each
 * array) that you can swap to give the two arrays the same sum. Example: Input
 * : A[] = {4, 1, 2, 1, 1, 2}, B[] = (3, 6, 3, 3) Output : {1, 3}
 * 
 * @author Polina Koleva
 *
 */
public class SwapPairToMakeSumOfArrayEqual {

	public static boolean doesPairExist(int[] a, int[] b) {
		// calculate sums of both arrays and save unique values in hash sets
		HashSet<Integer> bSet = new HashSet<>();
		int bSum = 0;
		for (int i = 0; i < b.length; i++) {
			bSum += b[i];
			bSet.add(b[i]);
		}
		HashSet<Integer> aSet = new HashSet<>();
		int aSum = 0;
		for (int i = 0; i < a.length; i++) {
			aSum += a[i];
			aSet.add(a[i]);
		}
		// find smaller set and iterate over it
		boolean isAbigger;
		if (aSet.size() < bSet.size()) {
			isAbigger = false;
		} else {
			isAbigger = true;
		}

		// if set A has less unique values, iterate over it
		if (!isAbigger) {
			for (Iterator iterator = aSet.iterator(); iterator.hasNext();) {
				Integer current = (Integer) iterator.next();
				// the searched number is float
				if (((bSum + 2 * current - aSum) % 2) != 0)
					continue;
				int searched = (bSum + 2 * current - aSum) / 2;
				if (bSet.contains(searched))
					return true;
			}
		} else {
			for (Iterator iterator = bSet.iterator(); iterator.hasNext();) {
				Integer current = (Integer) iterator.next();
				// the searched number is float
				if (((aSum + 2 * current - bSum) % 2) != 0)
					continue;
				int searched = (aSum + 2 * current - bSum) / 2;
				if (aSet.contains(searched))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(doesPairExist(new int[] {4, 1, 2, 1, 1, 2}, new int[] {3, 6, 3, 3}));
		System.out.println(doesPairExist(new int[] {5, 7, 4, 6}, new int[] {1, 2, 3, 8}));
	}
}
