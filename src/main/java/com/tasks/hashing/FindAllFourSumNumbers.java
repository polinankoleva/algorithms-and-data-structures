package com.tasks.hashing;

import java.util.*;

/**
 * Given an array A of size N, find all combination of four elements in the
 * array whose sum is equal to a given value K. For example, if the given array
 * is {10, 2, 3, 4, 5, 9, 7, 8} and K = 23, one of the quadruple is “3 5 7 8” (3
 * + 5 + 7 + 8 = 23)
 * 
 * @author Polina Koleva
 *
 */
public class FindAllFourSumNumbers {

	// n^4 solution, brute force
	public static void findAllFourNumbersMethod1(int[] arr, int sum) {
		for (int i = 0; i <= arr.length - 4; i++) {
			for (int j = i + 1; j <= arr.length - 3; j++) {
				for (int k = j + 1; k <= arr.length - 2; k++) {
					for (int p = k + 1; p <= arr.length - 1; p++) {
						int currentSum = arr[i] + arr[j] + arr[k] + arr[p];
						if (currentSum == sum) {
							System.out.println("Found: (" + arr[i] + "," + arr[j] + "," + arr[k] + "," + arr[p] + ")");
						}
					}
				}
			}
		}
	}

	// with sorting
	public static void findAllFourNumbersMethod2(int[] arr, int sum) {
		// sort the array nlogn in ascending order
		Arrays.sort(arr);
		// fix two numbers and try to find two others n^3
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int currentSum = arr[i] + arr[j];
				int difference = sum - currentSum;
				int start = 0;
				int end = arr.length - 1;
				while (start < end) {
					// if these numbers were already included in the sum
					// skip them
					if (start == i || start == j) {
						start++;
						continue;
					}
					if (end == i || end == j) {
						end--;
						continue;
					}
					int pairSum = arr[start] + arr[end];
					if (pairSum < difference) {
						start++;
					} else if (pairSum > difference) {
						end--;
					} else {
						// we found a pair
						System.out
								.println("Found: (" + arr[i] + "," + arr[j] + "," + arr[start] + "," + arr[end] + ")");
						start++;
						end--;
					}
				}
			}
		}
	}

	// with hashing
	public static void findAllFourNumbersMethod3(int[] arr, int sum) {
		HashMap<Integer, HashSet<Pair>> pairSum = new HashMap<Integer, HashSet<Pair>>();
		// calculate all sum of pairs
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				int localSum = arr[i] + arr[j];
				add(arr[i] + arr[j], new Pair(arr[i], arr[j]), pairSum);
			}
		}
		pairSum.forEach((k, v) -> {
			int difference = sum - k;
			if (pairSum.containsKey(difference)) {
				HashSet<Pair> foundPairs = pairSum.get(difference);
				v.forEach(pair -> {
					foundPairs.forEach(foundPair -> {
						if (!pair.commonValue(foundPair)) {
							// we found two pairs
							System.out.println(
									"Found: (" + pair.x + "," + pair.y + "," + foundPair.x + "," + foundPair.y + ")");
						}
					});
				});
			}
		});
	}

	public static void add(int sum, Pair pair, HashMap<Integer, HashSet<Pair>> map) {
		if (map.containsKey(sum)) {
			HashSet<Pair> pairs = map.get(sum);
			pairs.add(pair);
			map.put(sum, pairs);
		} else {
			HashSet<Pair> pairs = new HashSet<Pair>();
			pairs.add(pair);
			map.put(sum, pairs);
		}
	}

	public static void main(String[] args) {
		// findAllFourNumbersMethod1(new int[] { 10, 2, 3, 4, 5, 7, 8 }, 23);
		// findAllFourNumbersMethod1(new int[] { 0, 0, 1, 2 }, 3);
		// findAllFourNumbersMethod3(new int[] { 10, 2, 3, 4, 5, 7, 8 }, 23);
		findAllFourNumbersMethod3(new int[] { 0, 0, 1, 2 }, 3);
	}

}

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean commonValue(Pair p) {
		return (x == p.x || y == p.x || x == p.y || y == p.y);
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
