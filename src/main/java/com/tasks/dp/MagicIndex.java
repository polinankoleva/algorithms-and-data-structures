package com.tasks.dp;

/**
 * A magic index in an array A[0...n-1] is defined to be an index such that A[i]
 * = i. Given a sorted array of distinct integers, write a method to find a
 * magic index, if one exists, in array A.
 * 
 * FOLLOW UP: What if the values are not distinct? We cannot conclude anymore
 * that it is enough to look only at one side of the array, but we can exclude
 * some values. Overall, it will be similar to the execution time of a brute
 * force algorithm which has a for loop over the array checking for equality
 * between an element and its index.
 * 
 * @author Polina Koleva
 *
 */
public class MagicIndex {
	public static int hasMagicIndex(int[] arr) {
		return hasMagicIndex(arr, 0, arr.length - 1);
	}

	public static int hasMagicIndex(int[] arr, int start, int end) {
		if (start > end)
			return -1;
		int middle = (start + end) / 2;
		if (arr[middle] == middle)
			return middle;
		if (arr[middle] > middle)
			return hasMagicIndex(arr, start, middle - 1);
		if (arr[middle] < middle)
			return hasMagicIndex(arr, middle + 1, end);
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { -1, 0, 1, 2, 4, 5, 9 };
		System.out.println(hasMagicIndex(arr));
	}
}
