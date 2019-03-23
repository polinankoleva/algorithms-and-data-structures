package com.tasks.search;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an array of integer, find k max element.
 * 
 * @author Polina Koleva
 *
 */
public class KMaxElements {

	// O(nlogn) for the sorting, return sorted array
	public static int[] findMaxKBySorting(int[] array, int k) {
		Arrays.sort(array);
		return Arrays.copyOfRange(array, array.length - k, array.length);
	}

	// O(k) to build the minHeap
	// O((n-k)(logk)) to heapify
	public static int[] findMaxKByMinHeap(int[] array, int k) {
		// build min head from the first k values
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		// insert first k values into a min heap
		for (int i = 0; i < k; i++) {
			minHeap.add(array[i]);
		}
		int min = minHeap.peek();
		// compare next n-k values with the current minimum
		for (int i = k; i < array.length; i++) {
			if (array[i] > min) {
				minHeap.poll();
				minHeap.add(array[i]);
				min = minHeap.peek();
			}
		}
		int[] result = new int[k];
		int  i = 0;
		while(!minHeap.isEmpty()) {
			result[i] = minHeap.poll();
			i++;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] result = findMaxKByMinHeap(new int[] { 4, 58, 44, 2, 7 }, 2);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
