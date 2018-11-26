package com.tasks.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Sherlock considers a string to be valid if all characters of the string
 * appear the same number of times. It is also valid if he can remove just 1
 * character at index 1 in the string, and the remaining characters will occur
 * the same number of times. Given a string , determine if it is valid. If so,
 * return YES, otherwise return NO.
 * 
 * @author Polina Koleva
 *
 */
public class SherlockAndTheValidString {

	// Complete the isValid function below.
	static String isValid(String s) {
		// array that stores how many times we have seen each letter
		int[] letters = new int[26];
		for (int i = 0; i < s.length(); i++) {
			int charIndex = s.charAt(i) - 'a';
			letters[charIndex] += 1;
		}
		boolean hasOneMistake = false;
		int previous = 0;
		int indexOfPrevious = letters.length;
		boolean isFirst = true;
		for (int i = 0; i < letters.length; i++) {
			if (letters[i] != 0) {
				previous = letters[i];
				indexOfPrevious = i;
			}
		}
		for (int i = indexOfPrevious + 1; i < letters.length; i++) {
			int current = letters[i];
			if (current == 0) {
				continue;
			}
			if (current != previous) {
				if (!(hasOneMistake || Math.abs(previous - current) > 1)) {
					if (previous > current) {
						if (!isFirst) {
							return "NO";
						}
					} else {
						current -= 1;
					}
					hasOneMistake = true;
				} else {
					return "NO";
				}
			}
			previous = current;
			indexOfPrevious = i;
			isFirst = false;
		}
		return "YES";
	}

	// Complete the isValid function below.
	static String isValid2(String s) {
		// array that stores how many times we have seen each letter
		Integer[] letters = new Integer[26];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = new Integer(0);
		}
		for (int i = 0; i < s.length(); i++) {
			int charIndex = s.charAt(i) - 'a';
			letters[charIndex] += 1;
		}
		boolean hasOneMistake = false;
		Arrays.sort(letters, Collections.reverseOrder());
		for (int i = 1; i < letters.length; i++) {
			if (letters[i].intValue() == 0) {
				break;
			}
			if(letters[i-1].intValue() == letters[i].intValue()) {
				continue;
			}
			if(!hasOneMistake) {
				if((letters[i-1]-1 == letters[i] && i-1 == 0)) {
					hasOneMistake = true;
				}else if(letters[i] == 1) {
					hasOneMistake = true;
					letters[i] = letters[i-1];
				} else {
					return "NO";
				}
			} else {
				return "NO";
			}
		}
		return "YES";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String s = scanner.nextLine();
		String result = isValid2(s);
		System.out.println(result);
		scanner.close();
	}
}
