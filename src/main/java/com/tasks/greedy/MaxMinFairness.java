package com.tasks.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * You will be given a list of integers, arr, and a single integer k. You must
 * create an array of length k from elements of arr such that its unfairness is
 * minimized. Call that array subarr. Unfairness of an array is calculated as
 * max(subarr) - min(subarr)
 * 
 * @author Polina Koleva
 *
 */
public class MaxMinFairness {
	// Complete the maxMin function below.
	static int maxMin(int k, int[] arr) {
		int minFairness = Integer.MAX_VALUE;
		Arrays.sort(arr);
		for (int i = 0; i <= arr.length-k; i++) {
			int minSubArr = arr[i];
			int maxSubarr = arr[i+k-1];
			if(maxSubarr - minSubArr < minFairness) {
				minFairness = maxSubarr - minSubArr;
			}
		}
		return minFairness;
	}
	
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int k = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			int arrItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			arr[i] = arrItem;
		}

		int result = maxMin(k, arr);

		System.out.println(String.valueOf(result));
		scanner.close();
	}
}
