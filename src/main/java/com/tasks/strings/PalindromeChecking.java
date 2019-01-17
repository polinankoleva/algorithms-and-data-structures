package com.tasks.strings;

import java.util.Scanner;

/**
 * If a string is a palindrome. A string is said to be palindrome if reverse of
 * the string is same as string. For example, “abba” is palindrome, but “abbc”
 * is not palindrome.
 * 
 * @author polina
 *
 */
public class PalindromeChecking {

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

			boolean result = checkPalindrom(s1);
			System.out.println(result);
		}

		scanner.close();
	}
}
