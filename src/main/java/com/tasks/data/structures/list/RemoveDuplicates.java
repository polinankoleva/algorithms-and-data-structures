package com.tasks.data.structures.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import com.data.structures.list.LinkedList;

/**
 * Remove duplicates from an unsorted linked list. How would you solve this
 * problem if a temporary buffer is not allowed. CtCI book, Task 2.1
 * 
 * @author Polina Koleva
 *
 */
public class RemoveDuplicates {
	public static void removeDuplicates(ArrayList<Integer> list) {
		HashSet<Integer> duplicates = new HashSet<Integer>();
		ArrayList<Integer> indexToRemove = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			int value = list.get(i);
			if (duplicates.contains(value)) {
				indexToRemove.add(i);
			} else {
				duplicates.add(value);
			}
		}
		for (int i = 0; i < indexToRemove.size(); i++) {
			int index = indexToRemove.get(i);
			list.remove(index - i);
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(2);
		list.add(3);
		list.add(4);
		list.removeDuplicates3();
		System.out.println(list);

		Integer[] arr = new Integer[] { 1, 3, 3, 4, 5, 2, 3, 4 };
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.addAll(Arrays.asList(arr));
		removeDuplicates(arrList);
		arrList.forEach(k -> {
			System.out.print(k + " ");
		});
	}
}
