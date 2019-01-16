package com.tasks;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * You are given an unordered array consisting of consecutive integers [1, 2, 3,
 * ..., n] without any duplicates. You are allowed to swap any two elements. You
 * need to find the minimum number of swaps required to sort the array in
 * ascending order.
 * 
 * @author Polina Koleva
 *
 */
public class MinimumSwap {

	static int minimumSwaps(int[] arr) {
		int minSwap = 0;
		// find cycles and sum edges
		boolean[] visited = new boolean[arr.length];
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == true)
				continue;
			int currentCycleEdges = 1;
			visited[i] = true;
			int hop = arr[i] - 1;
			// go through the cycle, once the beginning of the cycle is reached, break it
			while (i != hop) {
				visited[hop] = true;
				hop = arr[hop] - 1;
				currentCycleEdges++;
			}
			minSwap += currentCycleEdges - 1;
		}
		return minSwap;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int res = minimumSwaps(arr);

		System.out.println(String.valueOf(res));
		scanner.close();
	}
}
