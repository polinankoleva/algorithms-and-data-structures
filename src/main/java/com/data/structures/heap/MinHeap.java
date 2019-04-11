package com.data.structures.heap;

import org.apache.http.Header;

/**
 * Implementation of min heap (Priority Queue). Min-Heap property -> the key of
 * a node is <= the keys of the children.
 * 
 * @author Polina Koleva
 *
 */
public class MinHeap {

	int[] arr;
	int heapSize;

	public MinHeap() {
		this.arr = new int[16];
		this.heapSize = 0;
	}

	public MinHeap(int[] arr) {
		this.heapSize = arr.length;
		this.arr = arr;
		this.arr = buildMinHeap(arr);
	}

	private int[] buildMinHeap(int[] arr) {
		for (int i = arr.length / 2; i >= 1; i--) {
			minHeapify(i);
		}
		return arr;
	}

	public void minHeapify(int index) {
		if (index > heapSize) {
			return;
		}
		int current = get(index);
		Integer leftChild = leftChild(index);
		Integer rightChild = rightChild(index);
		Integer indexForExchange = null;
		if (leftChild != null && rightChild != null) {
			if (leftChild < current) {
				indexForExchange = 2 * index;
			}
			if (rightChild < current && rightChild < leftChild) {
				indexForExchange += 1;
			}
		} else if (leftChild != null) {
			if (leftChild < current) {
				indexForExchange = 2 * index;
			}
		} else if (rightChild != null) {
			if (rightChild < current) {
				indexForExchange = 2 * index + 1;
			}
		}
		if (indexForExchange != null) {
			swap(index, indexForExchange);
			minHeapify(indexForExchange);
		}
	}

	private int get(int index) {
		return arr[index - 1];
	}

	private void set(int index, int value) {
		arr[index - 1] = value;
	}

	private void swap(int firstIndex, int secondIndex) {
		int temp = get(firstIndex);
		set(firstIndex, get(secondIndex));
		set(secondIndex, temp);
	}

	private Integer rightChild(int index) {
		if (2 * index + 1 <= heapSize) {
			return get(2 * index + 1);
		}
		return null;
	}

	private Integer getParent(int index) {
		if (index / 2 >= 1) {
			return get(index / 2);
		}
		return null;
	}

	private Integer leftChild(int index) {
		if (2 * index <= heapSize) {
			return get(2 * index);
		}
		return null;
	}

	public Integer getMin() {
		if (heapSize > 0) {
			return get(1);
		}
		return null;
	}

	public Integer extractMin() {
		if (heapSize <= 0)
			return null;
		swap(1, heapSize);
		int min = get(heapSize);
		heapSize--;
		minHeapify(1);
		return min;
	}

	private void bottomUpHeapify(int index) {
		Integer parent = getParent(index);
		Integer current = get(index);
		if (parent != null) {
			if (parent > current) {
				swap(index, index / 2);
				bottomUpHeapify(index / 2);
			}
		}
	}

	public void insert(int value) {
		if (heapSize == arr.length)
			return;
		heapSize++;
		set(heapSize, value);
		bottomUpHeapify(heapSize);
	}

	public int[] heapSort() {
		while (heapSize > 0) {
			swap(1, heapSize);
			heapSize--;
			minHeapify(1);
		}
		return arr;
	}

}
