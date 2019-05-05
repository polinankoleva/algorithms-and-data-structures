package com.tasks.sorting;

public class DutchNationalFlag {

	public static int dutchFlagPartition(int[] arr, int pivotIndex) {
		// TODO finish
		return 0;
	}

	/**
	 * Variant: Assuming that keys take one of three values, reorder the array so that all
	 * objects with the same key appear together. The order of the subarrays is not
	 * important.
	 */
	public static int[] dutchFlagPartitionThreeValues(int[] arr) {
		int valueOneIndex = 0;
		int valueThreeIndex = arr.length - 1;
		int valueOne = arr[0];
		int valueThree = arr[arr.length - 1];
		while (valueThreeIndex > valueOneIndex && valueOne == valueThree) {
			valueOneIndex++;
			swap(arr, valueOneIndex, valueThreeIndex);
			valueThree = arr[arr.length - 1];
		}
		for (int i = valueOneIndex + 1; i < valueThreeIndex; i++) {
			int current = arr[i];
			if (current == valueThree) {
				valueThreeIndex--;
				swap(arr, i, valueThreeIndex);
				i--;
				// equals to value one
			} else if (current == valueOne) {
				valueOneIndex++;
				swap(arr, i, valueOneIndex);
			}
			// equal to value two then just continue;
		}
		return arr;
	}

	public static int[] sort(int[] arr, int pivotIndex) {
		// set pivot to the last element
		swap(arr, pivotIndex, arr.length - 1);
		int less = -1;
		int greater = -1;
		int equal = -1;
		int pivot = arr[arr.length - 1];
		// go over unclassified
		for (int i = 0; i < arr.length - 1; i++) {
			int current = arr[i];
			if (current == pivot) {
				if (greater != -1) {
					swap(arr, greater, i);
					if (equal == -1)
						equal = greater;
					greater++;
				} else if (equal == -1) {
					equal = i;
				}
			} else if (current > pivot) {
				if (greater == -1)
					greater = i;
			} else {
				// current smaller that the pivot
				if (equal == -1 && greater == -1) {
					if (less == -1)
						less = i;
				}
				if (equal != -1) {
					swap(arr, equal, i);
					if (less == -1)
						less = equal;
					equal++;
					i--;
				}
			}
		}
		// swap pivot
		if (greater != -1)
			swap(arr, arr.length - 1, greater);
		return arr;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 2, 0, 2, 1, 1 };
		dutchFlagPartitionThreeValues(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
