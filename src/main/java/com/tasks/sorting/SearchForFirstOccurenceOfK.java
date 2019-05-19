package com.tasks.sorting;

/**
 * Write a method that takes a sorted array and a key and returns the index of
 * the first occurrence of that key in the array. Task 12.1, EPI book
 * 
 * @author Polina Koleva
 *
 */
public class SearchForFirstOccurenceOfK {

	// return -1 if not present
	public static int firstOccurence(int[] arr, int k, int start, int end) {
		if (start > end)
			return -1;
		int middle = start + (end - start) / 2;
		if (arr[middle] == k) {
			int firstOccurence = firstOccurence(arr, k, start, middle - 1);
			if (firstOccurence == -1) {
				return middle;
			} else {
				return firstOccurence;
			}
		} else if (arr[middle] > k) {
			return firstOccurence(arr, k, start, middle - 1);
		} else if (arr[middle] < k) {
			return firstOccurence(arr, k, middle + 1, end);
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { -14, -10, 2, 108, 108, 243, 285, 285, 401 };
		// output : 3
		System.out.println(firstOccurence(arr, 108, 0, arr.length - 1));
		// expected : 6
		System.out.println(firstOccurence(arr, 285, 0, arr.length - 1));
		// expected : -1
		System.out.println(firstOccurence(arr, 4, 0, arr.length - 1));
	}
}
