package com.tasks.arrays;

/**
 * Given an array of integers, return a new array such that each element at
 * index i of the new array is the product of all the numbers in the original
 * array except the one at i.
 * 
 * @author Polina Koleva
 *
 */
public class MultiplicationArray {

	// without using division
	// O(n) time, O(n) space
	public static int[] solution(int[] arr) {
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		int[] result = new int[arr.length];
		//initialize left array
		left[0] = 1;
		for (int i = 1; i < result.length-1; i++) {
			left[i] = left[i-1]*arr[i-1];
		}
		right[arr.length-1] = 1;
		for (int i = arr.length-2; i >= 0 ; i--) {
			right[i] = result[i+1]*arr[i+1];
		}
		for (int i = 0; i < result.length; i++) {
			result[i] = left[i] * right[i];
		}
		return result;
	}

	public static void main(String[] args) {
		solution(new int[] { 1, 4, 20, 3, 10, 5 });
		solution(new int[] { 10, 2, 2, 20, 10 });
		solution(new int[] { 10, 0, 2, 2, 20, 10 });
	}
}
