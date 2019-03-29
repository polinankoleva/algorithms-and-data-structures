package com.tasks.hashing;

/**
 * Given an array arr[] of positive integers. Find the length of the longest
 * sub-sequence such that elements in the subsequence are consecutive integers,
 * the consecutive numbers can be in any order.
 * 
 * @author Polina Koleva
 *
 */
import java.util.*;

public class LongestConsecutiveSubsequence {

	public static int longestConsecutiveSubsequence(int[] arr) {
		HashSet<Integer> numbers = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			numbers.add(arr[i]);
		}
		int maxSubsequenceLength = 0;
		for (int i = 0; i < arr.length; i++) {
			int current = arr[i];
			int localLength = 0;
			if (!numbers.contains(current - 1)) {
				int start = current;
				while (numbers.contains(start)) {
					localLength += 1;
					start += 1;
				}
				if (maxSubsequenceLength < localLength)
					maxSubsequenceLength = localLength;
			}
		}
		return maxSubsequenceLength;
	}

	public static void main(String[] args) {
		System.out.println(longestConsecutiveSubsequence(new int[] {2, 6, 1 ,9, 4, 5, 3}));
		System.out.println(longestConsecutiveSubsequence(new int[] {1, 9, 3, 10, 4, 20, 2}));

	}

}
