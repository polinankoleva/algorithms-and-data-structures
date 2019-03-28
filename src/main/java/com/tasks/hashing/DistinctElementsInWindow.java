package com.tasks.hashing;

import java.util.*;

/**
 * Given an array of size n and an integer k, return the of count of distinct
 * numbers in all windows of size k.
 * 
 * @author Polina Koleva
 *
 */
public class DistinctElementsInWindow {

	public static void countDistinct(int A[], int k) {
		// key - unique number, value - how many times it appears in a window
		HashMap<Integer, Integer> uniqueNumbers = new HashMap<>();
		int toBeRemovedIndex = 0;
		for (int i = 0; i < A.length; i++) {
			// add the first k-1 number to build the first window
			if (i < k - 1) {
				addNumber(uniqueNumbers, A[i]);
			} else {
				// at the end of each window, print the count of unique number
				// and remove the first number of the current preparing the map
				// for the next window
				addNumber(uniqueNumbers, A[i]);
				System.out.println(uniqueNumbers.size());
				removeNumber(uniqueNumbers, A[toBeRemovedIndex]);
				toBeRemovedIndex++;
			}
		}
	}

	// Add a number to a map that stores a count for each number,
	// if a new number is added, its count is 1
	// otherwise when the number is already present, increase its occurrence 
	public static void addNumber(HashMap<Integer, Integer> map, Integer numberToAdd) {
		if (map.get(numberToAdd) != null) {
			int occurence = map.get(numberToAdd);
			map.put(numberToAdd, occurence + 1);
		} else {
			// not in the map, add it with count 1
			map.put(numberToAdd, 1);
		}
	}

	// remove a number from a number by decreasing the number of occurrences it has been 
	// seen, if the occurrence of the number after the decrease is equal to 0, them 
	// remove the number completely
	public static void removeNumber(HashMap<Integer, Integer> map, Integer numberToRemove) {
		int occurence = map.get(numberToRemove);
		if (occurence == 1) {
			map.remove(numberToRemove);
		} else {
			map.put(numberToRemove, occurence - 1);
		}
	}

	public static void main(String[] args) {
		countDistinct(new int[] { 1, 2, 1, 3, 4, 2, 3 }, 4);
		countDistinct(new int[] { 4, 1, 1 }, 2);
	}
}
