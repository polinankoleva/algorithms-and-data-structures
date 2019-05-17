package com.tasks.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.tasks.sorting.InnerArray.Order;

/**
 * Design an efficient algorithm for sorting an increasing-decreasing array.
 * 
 * Task 11.2, EPI book
 * @author Polina Koleva
 *
 */
public class IncreasingDecreasingArray {

	public static List<Integer> sort(int[] arr) {
		List<Integer> result = new ArrayList<>();
		boolean isIncreasing = true;
		int startIndex = 0;
		List<InnerArray> arrays = new ArrayList<>();
		for(int i = 0; i < arr.length - 1; i++) {
			if(isIncreasing) {
				// end of increasing sequence
				if(arr[i] > arr[i+1]) {
					isIncreasing = false;
					InnerArray current = new InnerArray(startIndex, i, Order.INCREASING);
					arrays.add(current);
					startIndex = i+1;
				}
			} else {
				if(arr[i] < arr[i+1]) {
					isIncreasing = true;
					InnerArray current = new InnerArray(startIndex, i, Order.DECREASING);
					arrays.add(current);
					startIndex = i+1;
				}
			}
		}
		// add last sequence
		if(isIncreasing) {
			InnerArray current = new InnerArray(startIndex, arr.length - 1, Order.INCREASING);
			arrays.add(current);
		}else {
			InnerArray current = new InnerArray(startIndex, arr.length-1, Order.DECREASING);
			arrays.add(current);
		}
		PriorityQueue<ArrayInteger> minHeap = new PriorityQueue<>(new Comparator<ArrayInteger>() {
			@Override
			public int compare(ArrayInteger a1, ArrayInteger a2) {
				return a1.value - a2.value;
			}
		});
		
		// add first k number in the array, initialize the minHeap
		for (int i = 0; i < arrays.size(); i++) {
			InnerArray current = arrays.get(i);
			if(current.order == Order.INCREASING) {
				ArrayInteger currentIncreasingArr = new ArrayInteger(i, current.startIndex, arr[current.startIndex]);
				minHeap.add(currentIncreasingArr);
			} else {
				ArrayInteger currentIncreasingArr = new ArrayInteger(i, current.endIndex, arr[current.endIndex]);
				minHeap.add(currentIncreasingArr);
			}
			
		}
		while(!minHeap.isEmpty()) {
			ArrayInteger min = minHeap.poll();
			result.add(min.value);
			InnerArray current = arrays.get(min.arrayIndex);
			if(current.order == Order.INCREASING) {
				if(current.endIndex >= min.index + 1) {
					ArrayInteger currentIncreasingArr = new ArrayInteger(min.arrayIndex, min.index + 1, arr[min.index + 1]);
					minHeap.add(currentIncreasingArr);
				}
			} else {
				if(min.index - 1 >= current.startIndex) {
					ArrayInteger currentIncreasingArr = new ArrayInteger(min.arrayIndex, min.index - 1, arr[min.index - 1]);
					minHeap.add(currentIncreasingArr);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {57, 131, 493,294, 221, 339, 418, 452, 442, 190};
		List<Integer> result = sort(arr);
		for(Integer i : result) {
			System.out.println(i);
		}
	}
}

class InnerArray {
	int startIndex;
	int endIndex;
	Order order;

	public InnerArray(int startIndex, int endIndex, Order order) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.order = order;
	}

	enum Order {
		INCREASING, DECREASING;
	}
}
