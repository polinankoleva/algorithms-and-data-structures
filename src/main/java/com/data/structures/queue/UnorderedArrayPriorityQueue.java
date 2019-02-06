package com.data.structures.queue;

import java.util.Arrays;

/**
 * Implementation of a priority queue using an array. The array is unordered.
 * Priority queue has three methods: 1. insert(key) 2. max() 3. extractMax() 4.
 * increaseKey(key, x)
 * 
 * PR contains a set of elements, each element is associated with a key. An
 * element with a highest priority is dequeued before an element with low
 * priority.
 * 
 * Note:Similar implementation can be done with a list.
 * 
 * @author Polina Koleva
 *
 */
public class UnorderedArrayPriorityQueue {

	private int[] array;
	private int lastAddedIndex;

	public UnorderedArrayPriorityQueue() {
		// initial size of the queue
		this.array = new int[50];
		this.lastAddedIndex = 0;
	}

	public UnorderedArrayPriorityQueue(int[] array) {
		this.array = array;
		this.lastAddedIndex = array.length - 1;
	}

	// return index of the added element
	// constant amortized complexity
	public int insert(int key) {
		// double the array and copy its values to the new array
		// O(n) complexity
		if (this.lastAddedIndex >= array.length - 1) {
			this.array = Arrays.copyOf(array, array.length * 2);
		}
		// append the new element at the end of the queue
		this.array[lastAddedIndex] = key;
		lastAddedIndex++;
		return lastAddedIndex - 1;
	}

	public int max() {
		// iterate over the array and find the max element
		// complexity O(n)
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	// complexity O(n)
	public int extractMax() {
		// iterate over the array, find the max element,
		// remove it and switch the last added element with the removed
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
				array[i] = array[lastAddedIndex];
				lastAddedIndex--;
			}
		}
		return max;
	}

	// constant complexity
	public void increaseKey(int index, int newKey) {
		this.array[index] = newKey;
	}
}
