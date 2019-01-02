package com.tasks.arrays;

/**
 * Given an array of size |n - 1| and it contains numbers only from 1 to n with
 * one element missing. Find the missing number.
 * 
 * @author Polina Koleva
 *
 */
public class MissingNumberInArray {

	public static int missingNumber(int n, int[] array) {
		int totalSum = (n * (n + 1)) / 2;
		for (int i = 0; i < array.length; i++) {
			totalSum -= array[i];
		}
		return totalSum;
	}

	public static void main(String[] args) {
		System.out.println(missingNumber(5, new int[] { 1,2,3,5}));
		System.out.println(missingNumber(10, new int[] { 1,2,3,4,5,6,7,8,10}));
		System.out.println(missingNumber(2, new int[] { 1}));
	}
}
