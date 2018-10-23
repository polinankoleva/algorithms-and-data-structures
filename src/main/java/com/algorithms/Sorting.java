/**
 * This code is produced with learning purposes.
 * 
 * Polina Koleva, 28.06.2017.
 */
package com.algorithms;

/**
 * Util class for different sorting algorithms.
 * 
 * @author Polina Koleva
 *
 */
public class Sorting {

	// Time complexity O(n^2)
	public static void vanillaInsertionSort(int arr[]) {
		// skip the first element
		for (int i = 1; i < arr.length; i++) {
			int d = i;
			while (d > 0 && (arr[d] < arr[d - 1])) {
				int temp = arr[d - 1];
				arr[d - 1] = arr[d];
				arr[d] = temp;
				d--;
			}
		}
	}

	// Time complexity O(n^2)
	// insertion sort with binary search
	// use binary search to find the proper location to insert the selected item
	public static int[] bsInsertionSort(int arr[]) {
		// skip the first element
		for (int i = 1; i < arr.length; i++) {
			int d = i;
			int searchedIndex = findInsertPositionBS(arr, 0, d - 1, arr[d]);
			while (d > searchedIndex) {
				swap(d, d - 1, arr);
				d--;
			}
		}
		return arr;
	}

	public static int findInsertPositionBS(int[] array, int start, int end, int number) {
		if (start < end) {
			int middle = (start + end) / 2;
			if (array[middle] == number) {
				return middle + 1;
			}
			if (number < array[middle]) {
				return findInsertPositionBS(array, start, middle - 1, number);
			} else if (number > array[middle]) {
				return findInsertPositionBS(array, middle + 1, end, number);
			}
		} else if (start >= end) {
			if (number >= array[start]) {
				return start + 1;
			} else {
				return start;
			}
		}
		return 0;
	}

	// divide and conquer
	public static int[] mergeSort(int arr[], int start, int end) {
		// base of the recursion
		if (start == end) {
			return new int[] { arr[start] };
		}
		int middle = (start + end) / 2;
		int[] left = mergeSort(arr, start, middle);
		int[] right = mergeSort(arr, middle + 1, end);
		return merge(left, right);
	}

	/**
	 * Merge two sorted arrays. Time complexity O(n)
	 */
	public static int[] merge(int[] left, int[] right) {
		// first array's index
		int leftIndex = 0;
		// second array's index
		int rightIndex = 0;
		int[] result = new int[left.length + right.length];
		int resultIndex = 0;
		while (leftIndex < left.length && rightIndex < right.length) {
			if (left[leftIndex] <= right[rightIndex]) {
				result[resultIndex] = left[leftIndex];
				leftIndex++;
			} else {
				result[resultIndex] = right[rightIndex];
				rightIndex++;
			}
			resultIndex++;
		}
		// copy remaining of the left array
		while (leftIndex < left.length) {
			result[resultIndex] = left[leftIndex];
			leftIndex++;
			resultIndex++;
		}
		// copy remaining of the right array
		while (rightIndex < right.length) {
			result[resultIndex] = right[rightIndex];
			rightIndex++;
			resultIndex++;
		}
		return result;
	}

	// best case O(n) when array already sorted
	// worst case O(n^2)
	public static int[] bubbleSort(int[] arr) {
		boolean hasSwaps = true;
		while (hasSwaps) {
			hasSwaps = false;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(i, i + 1, arr);
					hasSwaps = true;
				}
			}
		}
		return arr;
	}

	/**
	 * Swap two elements of an array by their indexes.
	 * 
	 * @param i   index of an element
	 * @param j   index of an element
	 * @param arr array in which two elements will be swapped
	 */
	private static void swap(int i, int j, int[] arr) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	/**
	 * QuickSort implementation.
	 * 
	 * - divide-and-conquer algorithm, similar to merge sort - all the work happens
	 * in the divide step, almost nothing in the combine step - worst case O(n^2),
	 * average case O(nlogn) - works in place - in practice outperforms mergeSort
	 * and significantly outperforms insertionSort and selectionSort
	 * 
	 * @return sorted array
	 */
	public static void quickSort(int[] arr, int s, int e) {
		// pivot index
		int r = e;
		// choose a rightmost element as pivot
		int pivot = arr[r];
		// j - index for unknown elements (not yet compared with the pivot
		// elements)
		// q - index which is like a boundary for these two arrays [elements <
		// pivot] and [elements >= pivot]
		int q, j;
		q = j = s;
		while (j < r) {
			if (arr[j] < pivot) {
				swap(j, q, arr);
				q++;
				j++;
			} else if (arr[j] >= pivot) {
				j++;
			}
		}
		// move the pivot to its proper place after all elements have been
		// already compared to it
		swap(r, q, arr);
		r = q;
		// sort right array
		if (s < r - 1) {
			quickSort(arr, s, r - 1);
		}
		// sort left array
		if (r + 1 < e) {
			quickSort(arr, r + 1, e);
		}
	}

	// TODO implement when heap is implemented
	public static int[] heapSort() {
		return null;
	}

	// search for min element and set it on the first position in the unsorted
	// array
	// O(n^2) worst and best case
	public static void selectionSort(int[] arr) {
		// first index of unsorted array
		int u = 0;
		while (u < arr.length - 1) {
			int minIndex = findMinIndex(arr, u);
			swap(u, minIndex, arr);
			u++;
		}
	}

	/**
	 * Search for a min element in an array starting from a particular index. When a
	 * min element found, returns its index.
	 * 
	 * @param arr array in which a min element is searched
	 * @param s   start index for min element searching
	 * @return index of a min element
	 */
	private static int findMinIndex(int[] arr, int s) {
		int minIndex = 0;
		int min = Integer.MAX_VALUE;
		for (int i = s; i < arr.length; i++) {
			if (arr[i] <= min) {
				min = arr[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	// Counting sort is a sorting technique based on keys between a specific range.
	// It works by counting the number of objects having distinct key values (kind
	// of hashing).
	public static int[] countingSort(int arr[], int range) {
		int[] countArray = new int[range + 1];
		// count occurrence of each number
		for (int i = 0; i < arr.length; i++) {
			countArray[arr[i]] = countArray[arr[i]] + 1;
		}
		// calculate position of each number in the output array
		for (int i = 1; i < countArray.length; i++) {
			countArray[i] = countArray[i - 1] + countArray[i];
		}

		// output
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int position = countArray[arr[i]];
			result[position - 1] = arr[i];
			countArray[arr[i]]--;
		}
		return result;
	}

	// Counting sort is a sorting technique based on keys between a specific range.
	// It works by counting the number of objects having distinct key values (kind
	// of hashing).
	public static int[] radixSort(int arr[], int range) {
		// output
		int[] result = new int[arr.length];

		return result;
	}
}
