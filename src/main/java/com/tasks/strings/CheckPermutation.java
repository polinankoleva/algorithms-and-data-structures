package com.tasks.strings;

import java.util.HashMap;

public class CheckPermutation {
	// using HashMap solution
	public static boolean isPermutationMap(String str, String strToBeChecked) {
		if (str.length() != strToBeChecked.length())
			return false;
		HashMap<Character, Integer> strLetters = new HashMap<Character, Integer>();
		char[] strToCharArr = str.toCharArray();
		for (int i = 0; i < strToCharArr.length; i++) {
			if (strLetters.containsKey(strToCharArr[i])) {
				strLetters.put(strToCharArr[i], strLetters.get(strToCharArr[i]) + 1);
			} else {
				strLetters.put(strToCharArr[i], 1);
			}
		}
		char[] strToCheckCharArr = strToBeChecked.toCharArray();
		for (int i = 0; i < strToCheckCharArr.length; i++) {
			char current = strToCheckCharArr[i];
			if (strLetters.containsKey(current)) {
				int frequency = strLetters.get(current);
				if (frequency == 1) {
					strLetters.remove(current);
				} else {
					strLetters.put(current, frequency - 1);
				}
			} else {
				return false;
			}
		}
		return (strLetters.isEmpty());
	}

	// using array
	public static boolean isPermutationArray(String str, String strToCheck) {
		if (str.length() != strToCheck.length())
			return false;
		// create array with frequencies, ASCII assumed
		int[] lettersFreq = new int[128];
		char[] strToCharArr = str.toCharArray();
		for (int i = 0; i < strToCharArr.length; i++) {
			char current = strToCharArr[i];
			int currentIndex = (int) current;
			lettersFreq[currentIndex] += 1;
		}
		for (int i = 0; i < strToCheck.length(); i++) {
			char current = strToCheck.charAt(i);
			int currentIndex = (int) current;
			lettersFreq[currentIndex] -= 1;
			if (lettersFreq[currentIndex] < 0) {
				return false;
			}
		}
		// No needed if there is one letter with frequencies < 0, then return false
		// // check if all frequecies are zero
		// for (int i = 0; i < lettersFreq.length; i++) {
		// if (lettersFreq[i] != 0)
		// return false;
		// }
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPermutationMap("water", "wwater"));
		System.out.println(isPermutationArray("water", "wwater"));
		System.out.println(isPermutationMap("water", "terwa"));
		System.out.println(isPermutationArray("water", "terwa"));
		System.out.println(isPermutationMap("water", "wtear"));
		System.out.println(isPermutationArray("water", "wtear"));
		System.out.println(isPermutationMap("wwater  ", "waterr  "));
		System.out.println(isPermutationArray("wwater  ", "waterr  "));
	}

}
