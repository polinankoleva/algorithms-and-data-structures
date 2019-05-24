package com.tasks.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MedianOfOnlineData {

	public List<Integer> medians(int[] arr){
		List<Integer> result = new ArrayList<>();
		if(arr == null) return result;
		if(arr.length < 1) return result;
		if(arr.length == 1) {
			result.add(arr[0]);
			return result;
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		return result;
	}
}
