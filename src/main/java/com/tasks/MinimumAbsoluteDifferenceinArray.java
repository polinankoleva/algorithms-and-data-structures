package com.tasks;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumAbsoluteDifferenceinArray {
	static int minimumAbsoluteDifference(int n, int[] arr) {
		Arrays.sort(arr);
		int minDifference = Integer.MAX_VALUE;
		for (int i = 1; i < arr.length - 1; i++) {
			//compare with left
			int leftDifference = Math.abs(arr[i] - arr[i-1]);
			if(minDifference > leftDifference){
				minDifference = leftDifference;
			}
			//compare with right
			int rightDifference = Math.abs(arr[i] - arr[i+1]);
			if(minDifference > rightDifference){
				minDifference = rightDifference;
			}
		}
		return minDifference;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = in.nextInt();
		}
		int result = minimumAbsoluteDifference(n, arr);
		System.out.println(result);
		in.close();
	}
}
