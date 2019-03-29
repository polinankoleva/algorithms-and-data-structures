package com.tasks.hashing;

import java.util.HashSet;
import java.util.Scanner;

/***
 * Given two arrays: arr1[0..m-1] and arr2[0..n-1]. Find whether arr2[] is a
 * subset of arr1[] or not. Both the arrays are not in sorted order. It may be
 * assumed that elements in both array are distinct. Examples: 1) arr1[] = {11,
 * 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1} true 2) arr1[] = {1, 2, 3, 4, 5, 6},
 * arr2[] = {1, 2, 4} true 3) arr1[] = {10, 5, 2, 23, 19}, arr2[] = {19, 5, 3}
 * false
 * 
 * @author Polina Koleva
 *
 */
public class IsArraySubset {

	public static void isSubarray(int[] arr, int[] arrToCheck) {
		HashSet<Integer> numbers = new HashSet<>();
		for (int i = 0; i < numbers.size(); i++) {
			numbers.add(arr[i]);
		}
		for (int i = 0; i < arrToCheck.length; i++) {
			if (!numbers.contains(arrToCheck[i])) {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
	}

	private static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = in.nextInt();
		for (int i = 0; i < testCases; i++) {
			int arrSize = in.nextInt();
			int arrToCheckSize = in.nextInt();
			int[] arr = new int[arrSize];
			int[] arrToCheck = new int[arrToCheckSize];
			for (int j = 0; j < arrSize; j++) {
				arr[j] = in.nextInt();
			}
			for (int j = 0; j < arrToCheckSize; j++) {
				arrToCheck[j] = in.nextInt();
			}
			isSubarray(arr, arrToCheck);
		}
	}
}
