package com.tasks.strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * A string is said to be a special palindromic string if either of two
 * conditions is met:
 * 
 * 1. All of the characters are the same, e.g. aaa. 2. All characters except the
 * middle one are the same, e.g. aadaa.
 * 
 * Complete the substrCount function in the editor below. It should return an
 * integer representing the number of special palindromic substrings that can be
 * formed from the given string.
 * 
 * @author Polina Koleva
 *
 */
public class SpecialPalindromeAgain {

	// Complete the substrCount function below.
	static long substrCount1(int n, String s) {
		int count = s.length();
		for (int i = 2; i <= s.length(); i++) {
			for (int j = 0; j <= s.length() - i; j++) {
				String substring = s.substring(j, j + i);
				if (isSpecialPalindrom(substring)) {
					count++;
				}
			}
		}
		return count;
	}

	// Complete the substrCount function below.
	static long substrCount2(int n, String s) {
		int palindroms = s.length();
		char[] sArray = s.toCharArray();
		Map<Character, Integer> letters = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (letters.containsKey(sArray[i])) {
				letters.put(sArray[i], letters.get(sArray[i]) + 1);
			} else {
				letters.put(sArray[i], 1);
			}
		}
		// no duplications
		Iterator<Map.Entry<Character, Integer>> it = letters.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Character, Integer> pair = it.next();
			Integer letterTimes = pair.getValue();
			Character letter = pair.getKey();
			// form all special palindroms with the same letter
			int count = 2;
			StringBuilder sb = new StringBuilder();
			sb.append(letter);
			while (count <= letterTimes) {
				sb.append(letter);
				palindroms += times(s, sb.toString());
				count++;
			}
			// form all other palindroms
			Iterator<Map.Entry<Character, Integer>> innerIt = letters.entrySet().iterator();
			while (innerIt.hasNext()) {
				Map.Entry<Character, Integer> middle = innerIt.next();
				if (middle.getKey() == letter)
					continue;
				count = 2;
				sb = new StringBuilder();
				while (count <= letterTimes) {
					sb.append(letter);
					if (count == 2) {
						sb.append(middle.getKey());
					}
					sb.append(letter);
					palindroms += times(s, sb.toString());
					count += 2;
				}
			}
		}
		return palindroms;
	}

	public static int times(String text, String searched) {
		int count = 0;
		for (int i = 0; i <= text.length() - searched.length(); i++) {
			if (text.substring(i, i + searched.length()).equals(searched)) {
				count++;
			}
		}
		return count;
	}

	static boolean isSpecialPalindrom(String s) {
		char[] charArray = s.toCharArray();
		char firstChar = charArray[0];
		if (s.length() % 2 == 0) {
			for (int i = 1; i < s.length(); i++) {
				if (charArray[i] != firstChar) {
					return false;
				}
			}
		} else {
			for (int i = 1; i < s.length(); i++) {
				if (i == s.length() % 2)
					continue;
				if (charArray[i] != firstChar) {
					return false;
				}
			}
		}
		return true;
	}

	// Complete the substrCount function below.
	static long substrCount3(int n, String s) {
		int palindroms = 0;
		char[] sArray = s.toCharArray();
		int[] sameChar = new int[s.length()];
		// count all the sequences with the same letter
		for (int i = 0; i < sArray.length; i++) {
			char current = sArray[i];
			int j = i + 1;
			while (j < sArray.length && current == sArray[j]) {
				j++;
			}
			int sequenceLenght = j - i;
			// add to the total number of palindromes
			palindroms += (sequenceLenght * (sequenceLenght + 1)) / 2;
			for (int k = i; k < j; k++) {
				sameChar[k] = sequenceLenght;
			}
			// continue with j
			i = j-1;
		}
		// count all the sequences of form x.x,xx.xx, xxx.xxx and so on
		for (int i = 1; i < sameChar.length-1; i++) {
			if(sameChar[i] == 1 && sArray[i-1] == sArray[i+1]) {
				palindroms += Math.min(sameChar[i-1], sameChar[i+1]);
			}
		}
		return palindroms;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();

		long result = substrCount3(n, s);

		System.out.println(String.valueOf(result));

		scanner.close();
	}

}
