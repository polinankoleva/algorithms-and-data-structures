package com.tasks.dp;

import java.util.HashSet;

/**
 * Generate all subsets of a set. All subsets 2^n. Generation of all subset
 * cannot be better than O(n*2^n)
 * 
 * @author Polina Koleva
 *
 */
public class AllSubsets {
	public static void subsets(HashSet<Integer> initialSet, HashSet<HashSet<Integer>> resultSet) {
		if (initialSet == null || initialSet.isEmpty())
			return;
		initialSet.forEach(v -> {
			HashSet<Integer> setToAdd = new HashSet<>();
			setToAdd.addAll(initialSet);
			setToAdd.remove(v);
			resultSet.add(setToAdd);
			subsets(setToAdd, resultSet);
		});
	}

	public static HashSet<HashSet<Integer>> subsets(HashSet<Integer> initialSet) {
		HashSet<HashSet<Integer>> resultSet = new HashSet<>();
		resultSet.add(initialSet);
		subsets(initialSet, resultSet);
		return resultSet;
	}

	public static void main(String[] args) {
		HashSet<Integer> initialSet = new HashSet<>();
		initialSet.add(1);
		initialSet.add(2);
		initialSet.add(3);
		initialSet.add(4);
		// initialSet.add(5);
		HashSet<HashSet<Integer>> resultSet = subsets(initialSet);
		System.out.println(resultSet);
	}

}
