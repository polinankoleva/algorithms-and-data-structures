package com.tasks.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Write a program which takes as input a very long sequence of numbers and
 * prints the numbers in sorted order. Each number is at most k away from its
 * correctly sorted position. (Such an array is sometimes referred to as being
 * For example, no number in the sequence (3, -1,2, 6,4, 5, 8} is more than 2
 * away from its final sorted position.
 * 
 * Task 11.3, EPI book
 * @author Polina Koleva
 *
 */
public class KAlmostSorted {

	public static List<Integer> kAlmostSorted(int[] arr, int k) {
		List<Integer> result = new ArrayList<>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i <= k + 1; i++) {
			minHeap.add(arr[i]);
		}
		int nextIndex = k + 2;
		while (!minHeap.isEmpty()) {
			result.add(minHeap.poll());
			if (nextIndex < arr.length) {
				minHeap.add(arr[nextIndex]);
			}
			nextIndex++;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 3, -1, 2, 6, 4, 5, 8 };
		List<Integer> result = kAlmostSorted(arr, 2);
		for (Integer i : result) {
			System.out.println(i);
		}

	}
}
