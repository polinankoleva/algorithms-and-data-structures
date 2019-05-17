package com.tasks.search;

/**
 * Design an algorithm for computing the k-th largest element in an array.
 * entries are distinct. Task 12.8, EPI book
 * 
 * @author Polina Koleva
 *
 */
public class KLargestElement {

	// 1) sort in desc order and return k-1 element, O(nlogn) time, O(1) space
	// 2) use min-heap with K elements O(nlogk) time, O(k) space
	// 3) use D&C approach (pivot)+ randomization O(n) time, O(1) space
	// TODO continue
	public static int kLargest(int start, int end, int[] arr, int k) {
		int pivot = arr[end];
		// move all elements smaller than the pivot to the front, larger
		// than the pivot to the end
		int smallerPointer = start;
		int largerPointer = start + 1;
		// find first smaller and swap it with the start
		while (smallerPointer < end) {
			if (arr[smallerPointer] < pivot) {
				swap(start, smallerPointer, arr);
				largerPointer = smallerPointer + 1;
				smallerPointer = start + 1;
				break;
			}
			smallerPointer++;
		}
		while(largerPointer < end) {
			if(arr[largerPointer] < end) {
				swap(smallerPointer, largerPointer, arr);
				smallerPointer++;
			}
			largerPointer++;
		}
		// move pivot to the smallerPointer
		swap(smallerPointer, end, arr);
		
		// calculate how many elements are greater than the pivot 
		// if there are k-1 greater elements
		if((end - smallerPointer) == k-1) {
			return arr[smallerPointer];
		} else if((end - smallerPointer) > k-1) {
			return kLargest(smallerPointer + 1, end, arr, k);
		} else {
			return kLargest(start, smallerPointer - 1, arr, k);
		}
	}

	private static void swap(int i, int j, int[] arr) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {2,3,4,5,1,6,8,7};
		System.out.println(kLargest(0, arr.length - 1, arr, 4));
	}

}
