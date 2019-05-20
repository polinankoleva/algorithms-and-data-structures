package com.tasks.search;

/**
 * Design an efficient algorithm that takes a sorted array of distinct integers,
 * and returns an index i such that the element at index i equals i. For
 * example, when the input is (-2, 0, 2, 3, 6, 7, 9) your algorithm should
 * return 2 or 3. Task 12.2, EPI book
 * 
 * @author Polina Koleva
 *
 */
public class SearchForEntryEqualsToItsIndex {

	public static int search(int[] arr) {
		if(arr == null) return -1;
		return binarySearch(arr, 0, arr.length - 1);
	}

	// -1 if such value does not exist
	public static int binarySearch(int[] arr, int start, int end) {
		if (start > end)
			return -1;
		int middle = start + (end - start) / 2;
		// found such index
		if (arr[middle] == middle) {
			return middle;
		} else if(arr[middle] > middle) {
			return binarySearch(arr, start, middle - 1);
		} else {
			return binarySearch(arr, middle + 1, end);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {};
		//expected -1
		System.out.println(search(arr));
		arr = new int[] {-2, 0, 2, 3, 6, 7, 9};
		System.out.println(search(arr));
		System.out.println((int) Math.sqrt(16));
	}
}
