package com.tasks.strings;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Determine if a string has all unique characters. What if you cannot use
 * additional DS?
 * 
 * @author Polina Koleva
 *
 */
public class IsUnique {
	public static boolean hasUniqueChars(String str) {
		// define a map for already encountered chars
		HashSet<Character> letters = new HashSet<>();
		char[] strToChar = str.toCharArray();
		for (int i = 0; i < strToChar.length; i++) {
			if (letters.contains(strToChar[i])) {
				return false;
			} else {
				letters.add(strToChar[i]);
			}
		}
		return true;
	}

	// without using additional data structure
	public static boolean hasUniqueCharsNoDS(String str) {
		char[] strToChar = str.toCharArray();
		Arrays.sort(strToChar);
		for (int i = 0; i < strToChar.length - 1; i++) {
			if (strToChar[i] == strToChar[i + 1])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(hasUniqueCharsNoDS("abc"));
		System.out.println(hasUniqueCharsNoDS("aabc"));
		System.out.println(hasUniqueCharsNoDS("abcabc"));
	}

}
