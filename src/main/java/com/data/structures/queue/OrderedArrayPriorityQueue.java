package com.data.structures.queue;

import java.util.Arrays;

/**
 * Implementation of a priority queue using an array. The array is kept sorted.
 * Priority queue has three methods: 1.insert(key) 2. max() 3. extractMax() 4.
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
public class OrderedArrayPriorityQueue {

	private Integer[] array;
	private int lastAddedIndex;

	public OrderedArrayPriorityQueue() {
		// initial size of the queue
		this.array = new Integer[50];
		this.lastAddedIndex = -1;
	}

	public OrderedArrayPriorityQueue(Integer[] array) {
		this.array = array;
		Arrays.sort(array);
		this.lastAddedIndex = array.length - 1;
	}

	// return index of the added element
	// O(n) time complexity
	public int insert(int key) {
		if(lastAddedIndex ==  -1) {
			lastAddedIndex++;
			array[lastAddedIndex] = key;
			return lastAddedIndex;
		}
		// double the array and copy its values to the new array
		// O(n) complexity
		if (this.lastAddedIndex >= array.length - 1) {
			this.array = Arrays.copyOf(array, array.length * 2);
		}
		// find the position for the new element, use binary search O(logn) complexity
		int indexToBeAdded = binarySearch(key, array, 0, lastAddedIndex);
		// move all elements after added with one position
		for (int i = lastAddedIndex; i >= indexToBeAdded; i++) {
			array[i + 1] = array[i];
		}
		this.array[indexToBeAdded] = key;
		lastAddedIndex++;
		return lastAddedIndex - 1;
	}

	private int binarySearch(int searched, Integer[] arr, int start, int end) {
		if (start == end) {
			if (searched > arr[start]) {
				return start + 1;
			} else {
				return start;
			}
		}
		int middleIndex = (end-start) / 2;
		if (searched == arr[middleIndex]) {
			return middleIndex;
		}
		if (searched > arr[middleIndex]) {
			return binarySearch(searched, arr, middleIndex + 1, end);
		} else {
			return binarySearch(searched, arr, 0, middleIndex - 1);
		}
	}

	// array is kept in a sorted order,
	// the last element of the maximum
	// O(1) complexity time
	public Integer max() {
		if(lastAddedIndex < 0) return null;
		return this.array[lastAddedIndex];
	}

	// complexity O(1)
	public Integer extractMax() {
		if(lastAddedIndex < 0) return null;
		int max = this.array[lastAddedIndex];
		this.array[lastAddedIndex] = null;
		lastAddedIndex--;
		return max;
	}

	public void increaseKey(int index, int newKey) {
		this.array[index] = newKey;
		// the array needs sorting

	}
}
