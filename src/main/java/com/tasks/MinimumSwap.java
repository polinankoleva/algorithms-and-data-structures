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
		int[] copy = arr.clone();
		Arrays.sort(copy);
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] != copy[i]) {
				minSwap++;
			}
		}
//		for (int i = 0; i < arr.length; i++) {
//			int minPosition = i;
//			for (int j = i + 1; j < arr.length; j++) {
//				if(arr[minPosition] > arr[j]) {
//					minPosition = j;
//				}
//			}
//			if(minPosition != i) {
//				minSwap++;
//				int temp = arr[minPosition];
//				arr[minPosition] = arr[i];
//				arr[i] = temp;
//			}
//		}
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
