package com.tasks.search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * You will be given an array of integers and a target value. Determine the
 * number of pairs of array elements that have a difference equal to a target
 * value.
 * 
 * For example, given an array of [1, 2, 3, 4] and a target value of 1, we have
 * three values meeting the condition: [1,2], [3,2] and [3,4]
 * 
 * @author polina
 *
 */
public class Pairs {
	// Complete the pairs function below.
	static int pairs(int k, int[] arr) {
		int pairs = 0;
		// key - summation of k and current element, value times this summation has been
		// seen
		Map<Integer, Integer> differences = new HashMap<Integer, Integer>();
		Map<Integer, Integer> seen = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int current = arr[i];
			if (seen.containsKey(current)) {
				seen.put(current, seen.get(current) + 1);
			} else {
				seen.put(current, 1);
			}
			if (differences.containsKey(current)) {
				pairs += differences.get(current);
			}
			int summation = current + k;
			if(seen.containsKey(summation)) {
				pairs += seen.get(summation);
			}
			if (differences.containsKey(summation)) {
				differences.put(summation, differences.get(summation) + 1);
			} else {
				differences.put(summation, 1);
			}
		}
		return pairs;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int result = pairs(k, arr);

		System.out.println(String.valueOf(result));
		System.out.println();

		scanner.close();
	}
}
