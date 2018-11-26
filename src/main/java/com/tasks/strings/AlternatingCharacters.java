package com.tasks.strings;

import java.util.Scanner;

public class AlternatingCharacters {

	// The input contains only 'A' and 'B'. Change it into a string such that there
	// are no
	// matching adjacent characters. You are allowed to delete zero or more chars.
	// Find minimum number of deletion.
	static int alternatingCharacters(String s) {
		int deletions = 0;
		char lastChar = s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			if (lastChar == s.charAt(i)) {
				deletions++;
			} else {
				lastChar = s.charAt(i);
			}
		}
		return deletions;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s1 = scanner.nextLine();

			int result = alternatingCharacters(s1);
			System.out.println(result);
		}

		scanner.close();
	}
}
