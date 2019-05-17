package com.tasks.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Write a program that takes as input a set of sorted sequences and computes
 * the union of these sequences as a sorted sequence. For example, if the input
 * is (3, 5, 7), (0, 6), and (0, 6, 28), then the output is (0, 0, 3, 5, 6, 6,
 * 7, 28).
 * Task 11.1, EPI book
 * @author Polina Koleva
 *
 */
public class MultipleArraysSorting {

	public static List<Integer> multipleArraysSorting(List<List<Integer>> arrays) {
		List<Integer> result = new ArrayList<>();
		PriorityQueue<ArrayInteger> minHeap = new PriorityQueue<>(new Comparator<ArrayInteger>() {
			@Override
			public int compare(ArrayInteger a1, ArrayInteger a2) {
				return a1.value - a2.value;
			}
		});
		// add first k number in the array, initialize the minHeap
		for (int i = 0; i < arrays.size(); i++) {
			ArrayInteger current = new ArrayInteger(i, 0, arrays.get(i).get(0));
			minHeap.add(current);
		}
		while(!minHeap.isEmpty()) {
			ArrayInteger min = minHeap.poll();
			result.add(min.value);
			if(arrays.get(min.arrayIndex).size() > min.index + 1) {
				Integer minNext = arrays.get(min.arrayIndex).get(min.index + 1);
				minHeap.add(new ArrayInteger(min.arrayIndex, min.index + 1, minNext));
			}			
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<Integer> first = new ArrayList<>();
		first.add(3);
		first.add(5);
		first.add(7);
		List<Integer> second = new ArrayList<>();
		second.add(0);
		second.add(6);
		List<Integer> third = new ArrayList<>();
		third.add(0);
		third.add(6);
		third.add(28);
		third.add(30);
		List<List<Integer>> input = new ArrayList<>();
		input.add(first);
		input.add(second);
		input.add(third);
		List<Integer> result = multipleArraysSorting(input);
		for(Integer i : result){
			System.out.println(i);
		}
	}
}

class ArrayInteger {
	// which is the index of the number in the array
	int index;
	// which array this number is part of
	int arrayIndex;
	int value;

	public ArrayInteger(int arrayIndex, int index, int value) {
		this.arrayIndex = arrayIndex;
		this.index = index;
		this.value = value;
	}
}