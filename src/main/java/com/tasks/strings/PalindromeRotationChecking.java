package com.tasks.strings;

import java.util.Scanner;

/**
 * Given a string, check if it is a rotation of a palindrome. For example your
 * function should return true for “aab” as it is a rotation of “aba”.
 * 
 * @author polina
 *
 */
public class PalindromeRotationChecking {

	// simple version
	// O(n^2) time complexity
	static boolean checkRotationPalindrom(String s) {
		if(checkPalindrom(s)) {
			return true;
		} 
		for (int i = 0; i < s.length(); i++) {
			String firstPart = s.substring(i+1);
			String secondPart = s.substring(0, i);
			if(checkPalindrom(firstPart.concat(secondPart))) {
				return true;
			}
		}
		return false;
	}
	
	static boolean checkPalindrom(String s) {
		char[] charArray = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (charArray[i] != charArray[s.length() - (i + 1)]) {
				return false;
			}
		}
		return true;
	}
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s1 = scanner.nextLine();

			boolean result = checkRotationPalindrom(s1);
			System.out.println(result);
		}

		scanner.close();
	}
}
