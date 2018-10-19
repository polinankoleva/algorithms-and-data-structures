package com.algorithms.dp;

import java.util.HashMap;
import java.util.Scanner;

//TODO finish
/**
 * Given an array of integers, find the subset of non-adjacent elements with the
 * maximum sum. Calculate the sum of that subset.
 * 
 * @author polina
 *
 */
public class MaxArraySum {

	// Complete the maxSubsetSum function below.
	static int maxSubsetSum(int[] arr) {
		int[][] sums = new int[arr.length][arr.length];
		boolean[][] calculated = new boolean[arr.length][arr.length];
		return max(arr, 0, arr.length - 1, sums, calculated);
	}

	static int max(int[] arr, int start, int end, int[][] sums, boolean[][] calculated) {
		if (end < start) {
			return 0;
		}
		if (calculated[start][end]) {
			return sums[start][end];
		}
		if (start == end) {
			int sum = arr[start];
			calculated[start][end] = true;
			sums[start][end] = sum;
			return sum;
		} else {
			int sum = Math.max(arr[start], arr[end]);
			sum = Math.max(sum, arr[start] + max(arr, start + 2, end, sums, calculated));
			sum = Math.max(sum, arr[end] + max(arr, start, end - 2, sums, calculated));
			sum = Math.max(sum, max(arr, start + 1, end - 1, sums, calculated));
			sum = Math.max(sum, max(arr, start + 1, end, sums, calculated));
			sum = Math.max(sum, max(arr, start, end - 1, sums, calculated));
			calculated[start][end] = true;
			sums[start][end] = sum;
			return sum;
		}
	}

	// Complete the checkMagazine function below.
	static void checkMagazine(String[] magazine, String[] note) {
		if (magazine.length < note.length) {
			System.out.println("No");
			return;
		}
		HashMap<String, Integer> words = new HashMap<String, Integer>();
		for (int i = 0; i < magazine.length; i++) {
			if (!words.containsKey(magazine[i])) {
				words.put(magazine[i], 1);
			} else {
				int currectCount = words.get(magazine[i]);
				words.put(magazine[i], currectCount + 1);
			}
		}
		for (int i = 0; i <= note.length - 1; i++) {
			if (!words.containsKey(note[i]) || words.get(note[i]) == 0) {
				System.out.println("No");
				return;
			} else {
				int currectCount = words.get(note[i]);
				words.put(note[i], currectCount - 1);
			}
		}
		System.out.println("Yes");
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String[] mn = scanner.nextLine().split(" ");

		int m = Integer.parseInt(mn[0]);

		int n = Integer.parseInt(mn[1]);

		String[] magazine = new String[m];

		String[] magazineItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		String[] note = new String[n];

		String[] noteItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		checkMagazine(magazine, note);

		scanner.close();
	}

}
