package com.tasks.strings;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Find if two strings have common substring. Substring of length 1 is also
 * valid common substring.
 * 
 * @author Polina Koleva
 *
 */
public class TwoStrings {

	static String twoStrings(String s1, String s2) {
		String smaller = null;
		String bigger = null;
		if (s1.length() < s2.length()) {
			smaller = s1;
			bigger = s2;
		} else {
			smaller = s2;
			bigger = s1;
		}
		HashSet<Character> letters = new HashSet<>();
		char[] smallerChar = smaller.toCharArray();
		for (int i = 0; i < smallerChar.length; i++) {
			letters.add(smallerChar[i]);
		}
		char[] biggerChar = bigger.toCharArray();
		for (int i = 0; i < biggerChar.length; i++) {
			if (letters.contains(biggerChar[i])) {
				return "YES";
			}
		}
		return "NO";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s1 = scanner.nextLine();

			String s2 = scanner.nextLine();

			String result = twoStrings(s1, s2);
			System.out.println(result);
		}

		scanner.close();
	}
}
