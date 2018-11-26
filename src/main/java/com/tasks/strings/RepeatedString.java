package com.tasks.strings;

import java.util.Scanner;

public class RepeatedString {

	// Complete the repeatedString function below.
	static long repeatedString(String s, long n) {
		// count number of a in the string s
		String s1 = s;
		long count = s.length() - s1.replace("a", "").length();
		long repeat = n / s.length();
		int remainder = (int) (n % s.length());
		long count2 = 0;
		if (remainder != 0) {
			String repeatedSubstring = s.substring(0, remainder);
			count2 = repeatedSubstring.length() - repeatedSubstring.replace("a", "").length();
		}
		return repeat * count + count2;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
	
		String s = scanner.nextLine();

		long n = scanner.nextLong();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long result = repeatedString(s, n);

		System.out.println(result);

		scanner.close();
	}
}
