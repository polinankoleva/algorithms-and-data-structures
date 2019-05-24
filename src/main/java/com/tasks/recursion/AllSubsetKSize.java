package com.tasks.recursion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllSubsetKSize {

	public static void allSubsetsKSize(int k, int index, List<List<Integer>> result, List<Integer> numbers) {
		if (k == index) {
			result.add(new ArrayList<>(numbers.subList(0, k)));
			return;
		}
		for (int i = index; i < numbers.size(); i++) {
			Collections.swap(numbers, index, i);
			allSubsetsKSize(k, index + 1, result, numbers);
			Collections.swap(numbers, index, i);
		}
	}

	public static List<List<Integer>> allSubsetsKSize(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			numbers.add(i);
		}
		allSubsetsKSize(k, 0, result, numbers);
		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> result = allSubsetsKSize(3, 3);
		for (List<Integer> list : result) {
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}

}
