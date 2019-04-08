package com.tasks.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Task 1 -> Write a method to compute all permutations of a string of unique
 * characters. Task 2 -> Write a method to compute all permutations of a string
 * whose characters are not necessarily unique. The list of permutations should
 * not have duplicates.
 * 
 * @author Polina Koleva
 *
 */
public class PermutationsOfAString {

	public static Set<StringBuilder> permutations(String input) {
		Set<StringBuilder> resultSet = new HashSet<>();
		if (input.length() == 1) {
			resultSet.add(new StringBuilder(input));
			return resultSet;
		}
		// merge all permutations
		for (int i = 0; i < input.length(); i++) {
			char currentLetter = input.charAt(i);
			String newInput = input.substring(0, i) + input.substring(i + 1, input.length());
			Set<StringBuilder> permutationSet = permutations(newInput);
			appendHelper(currentLetter, permutationSet);
			resultSet.addAll(permutationSet);
		}
		return resultSet;
	}

	public static Set<StringBuilder> permutationsWithoutDuplications(String input) {
		Set<StringBuilder> resultSet = new HashSet<>();
		if (input.length() == 1) {
			resultSet.add(new StringBuilder(input));
			return resultSet;
		}
		// merge all permutations
		HashSet<Character> letters = new HashSet<Character>();
		for (int i = 0; i < input.length(); i++) {
			char currentLetter = input.charAt(i);
			if (letters.contains(currentLetter))
				continue;
			letters.add(currentLetter);
			String newInput = input.substring(0, i) + input.substring(i + 1, input.length());
			Set<StringBuilder> permutationSet = permutationsWithoutDuplications(newInput);
			appendHelper(currentLetter, permutationSet);
			resultSet.addAll(permutationSet);
		}
		return resultSet;
	}

	public static Set<StringBuilder> appendHelper(char a, Set<StringBuilder> sbs) {
		for (StringBuilder sb : sbs) {
			sb.append(a);
		}
		return sbs;
	}

	public static Set<StringBuilder> appendHelperMemo(char a, Set<StringBuilder> sbs) {
		Set<StringBuilder> resultSet = new HashSet<>();
		for (StringBuilder sb : sbs) {
			StringBuilder sbn = new StringBuilder(sb.toString());
			sbn.append(a);
			resultSet.add(sbn);
		}
		return resultSet;
	}

	// use memoization
	public static void permutations(String input, HashMap<String, Set<StringBuilder>> permutations) {
		Set<StringBuilder> resultSet = new HashSet<>();
		if (input.length() == 1) {
			resultSet.add(new StringBuilder(input));
			permutations.put(input, resultSet);
		}
		for (int i = 0; i < input.length(); i++) {
			char currentLetter = input.charAt(i);
			String newInput = input.substring(0, i) + input.substring(i + 1, input.length());
			if (permutations.get(newInput) == null) {
				permutations(newInput, permutations);
			}
			Set<StringBuilder> permutationSet = permutations.get(newInput);
			Set<StringBuilder> interResult = appendHelperMemo(currentLetter, permutationSet);
			resultSet.addAll(interResult);
		}
		// free map
		freeMap(resultSet, permutations);
		permutations.put(input, resultSet);
	}

	public static void freeMap(Set<StringBuilder> resultSet, HashMap<String, Set<StringBuilder>> permutations) {
		Set<String> toBeRemoved = new HashSet<>(permutations.keySet());
		for (StringBuilder sb : resultSet) {
			toBeRemoved.remove(sb.toString());
		}
		for (String key : toBeRemoved) {
			permutations.remove(key);
		}
	}

	public static Set<StringBuilder> permutationsMemo(String input) {
		HashMap<String, Set<StringBuilder>> permutations = new HashMap<>();
		input = sortString(input);
		permutations(input, permutations);
		return permutations.get(input);
	}

	public static String sortString(String inputString) {
		// convert input string to char array
		char tempArray[] = inputString.toCharArray();
		// sort tempArray
		Arrays.sort(tempArray);
		// return new sorted string
		return new String(tempArray);
	}

	public static void main(String[] args) {
		// System.out.println(permutations("abcdefghijklmnopqrstuvwxyz"));
		System.out.println(permutationsWithoutDuplications("aabb"));
	}
}
