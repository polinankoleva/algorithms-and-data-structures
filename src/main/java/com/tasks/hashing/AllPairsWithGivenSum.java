package com.tasks.hashing;

/**
 * Given two unsorted arrays A of size N and B of size M of distinct elements,
 * the task is to find all pairs from both arrays whose sum is equal to X.
 * 
 * @author Polina Koleva
 *
 */
import java.util.*;

public class AllPairsWithGivenSum {

	public static void allPairsWithSum(int[] arr1, int[] arr2, int sum) {
		boolean print = false;
		HashSet<Integer> arr1Values = new HashSet<Integer>();
		for (int i = 0; i < arr1.length; i++) {
			arr1Values.add(arr1[i]);
		}
		for (int i = 0; i < arr2.length; i++) {
			int difference = sum - arr2[i];
			if(arr1Values.contains(difference)) {
				// a pair found
				if(!print) {
					System.out.print(difference +" "+ arr2[i]);
					print = true;
				} else {
					System.out.print(", "+difference +" "+ arr2[i]);
				}
			}
		}
	}

	public static void main(String[] args) {
		allPairsWithSum(new int[] {1,2,4,5,7}, new int[] {5,6,3,4,8}, 9);
		allPairsWithSum(new int[] {0,2}, new int[] {1,3}, 3);
	}
}
