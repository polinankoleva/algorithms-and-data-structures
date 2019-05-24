package com.tasks.arrays;

/**
 * Write a program which takes as input a sorted array and updates it so that
 * all duplicates have been removed and the remaining elements have been shifted
 * left to fill the emptied indices. Return the number of valid elements. Many
 * languages have library functions for performing this operation you cannot use
 * these functions. Task 6.5, EPI book
 * 
 * @author Polina Koleva
 *
 */
public class SortedListDeleteDuplicates {

	public static void deleteDuplicates(int[] arr) {
		int lastAdded = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[lastAdded] != arr[i]) {
				lastAdded++;
				arr[lastAdded] = arr[i];
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 3, 5, 5, 5, 5, 7, 11, 11, 11, 13 };
		deleteDuplicates(arr);
		for (int i : arr) {
			System.out.println(i + " ");
		}

	}

}
