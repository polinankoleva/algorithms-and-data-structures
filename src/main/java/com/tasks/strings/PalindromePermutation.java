package com.tasks.strings;

import java.util.HashMap;

/**
 * Check if a string is a permutation of a palindrome. A palindrome is a word or
 * phrase that is the same forwards and backwards.
 * 
 * @author Polina Koleva
 *
 */
public class PalindromePermutation {

	public static boolean isPalindromePermutation(String s) {
		s = s.toLowerCase();
		// count frequency of each letter in s
		HashMap<Character, Integer> letters = new HashMap<>();
		int sTrueLength = 0;
		for (int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);
			if (current == ' ')
				continue;
			sTrueLength++;
			if (letters.containsKey(current)) {
				// every second time we want to add the same letter , just remove it
				letters.remove(current);
			} else {
				letters.put(current, 1);
			}
		}
		if (sTrueLength % 2 != 0 && letters.size() == 1) {
			return true;
		}
		return (letters.isEmpty());
	}

	public static void main(String[] args) {
		System.out.println(isPalindromePermutation("Tact Coa"));
		System.out.println(isPalindromePermutation(""));
		System.out.println(isPalindromePermutation("a"));
		System.out.println(isPalindromePermutation("aa"));
	}
}
