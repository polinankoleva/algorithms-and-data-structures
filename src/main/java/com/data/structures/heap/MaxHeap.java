package com.data.structures.heap;

/**
 * Implementation of max heap (Priority Queue). 
 * Max-Heap property -> the key of a node is >= the keys of the children.
 * 
 * @author Polina Koleva
 *
 */
public class MaxHeap {

	/*
	 * Index of the max element in the heap.
	 */
	private int maxIndex;
	private int[] maxHeapArr;
	
	/**
	 * Create new max heap.
	 * 
	 * @param arr elements of the max heap
	 */
	public MaxHeap(int[] arr){
		buildMaxHeap(arr);
		maxIndex = 0;
		this.maxHeapArr = arr;
	}
	
	/**
	 * Produce max heap from unordered array. O(nlogn) time complexity
	 */
	private void buildMaxHeap(int[] arr) {
		int middle = arr.length / 2;
		for (int i = middle - 1; i >= 0; i--) {
			maxHeapify(arr, i); // O(logn) time complexity
		}
	}

	/**
	 * Correct a single violation of heap max property in a subtree's root. Look
	 * at the tress rooted at left(rootIndex) and right(rootIndex). NOTE: Assume
	 * that trees rooted at left(i) and right(i) are max heaps.
	 */
	private void maxHeapify(int[] arr, int rootIndex) {
		int rootValue = arr[rootIndex];
		int leftChildrenIndex = left(rootIndex);
		int rightChilderIndex = right(rootIndex);
		// check left children if any
		if (leftChildrenIndex < arr.length) {
			int leftChildren = arr[leftChildrenIndex];
			if (rootValue < leftChildren) {
				rootValue = leftChildren;
				swap(rootIndex, leftChildrenIndex, arr);
				maxHeapify(arr, leftChildrenIndex);
			}
		}
		// check right children if any
		if (rightChilderIndex < arr.length) {
			int rightChildren = arr[rightChilderIndex];
			if (rootValue < rightChildren) {
				rootValue = rightChildren;
				swap(rootIndex, rightChilderIndex, arr);
				maxHeapify(arr, rightChilderIndex);
			}
		}
	}

	private void swap(int i, int j, int[] arr) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
	
	// return index of the left child
	public int left(int index) {
		return 2 * index + 1;
	}

	// return index of the right child
	public int right(int index) {
		return 2 * index + 2;
	}

	// insert element x
	public void insert(int x) {
		
	}

	// return max element - always the root element
	public int max() {
		return maxHeapArr[maxIndex];
	}

	// return max element and extract it from the heap
	public int extractMax() {
		int max = max();
		maxIndex++;
		return max;
	}

	// increase value of x to new value k
	public void increase(int x, int k) {

	}
}