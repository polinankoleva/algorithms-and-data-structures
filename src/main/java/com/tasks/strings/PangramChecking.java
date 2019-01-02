package com.tasks.strings;

import java.util.Scanner;
/**
 * Check if a string is a pangram. To be a pangram, it needs to contain all the letter from
 * an alphabet(chars from 'a' to 'z')
 * 
 * @author Polina Koleva
 *
 */
public class PangramChecking {

	static boolean checkPangram(String pangram) {
		boolean mark[] = new boolean[26];
		pangram = pangram.toLowerCase().trim().replace(" ", "");
		for (int i = 0; i < pangram.length(); i++) {
			int charIndex = pangram.charAt(i) - 'a';
			mark[charIndex] = true;
		}
		for (int i = 0; i < mark.length; i++) {
			if(!mark[i]) {
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

			boolean result = checkPangram(s1);
			System.out.println(result);
		}

		scanner.close();
	}
}
