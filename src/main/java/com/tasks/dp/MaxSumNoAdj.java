package com.tasks.dp;

public class MaxSumNoAdj {

	public static int maxSum(int[] arr, int start) {
		if (start >= arr.length)
			return 0;
		return Math.max(arr[start] + maxSum(arr, start + 2), maxSum(arr, start + 1));
	}

	public static int maxSum(int[] arr) {
		return maxSum(arr, 0);
	}

	public static void main(String[] args) {
		System.out.println(maxSum(new int[] { 5, 5, 10, 100, 10, 5 }));
		System.out.println(maxSum(new int[] { 1, 2, 3 }));
		System.out.println(maxSum(new int[] { 1, 20, 3 }));
	}
}
