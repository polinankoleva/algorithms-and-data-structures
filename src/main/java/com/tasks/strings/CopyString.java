package com.tasks.strings;

import java.util.Scanner;

/**
 * Copy a string recursively and incrementally.
 * 
 * @author Polina Koleva
 *
 */
public class CopyString {

	static String copyIteratively(String toBeCoppied) {
		char[] copy = new char[toBeCoppied.length()];
		for (int i = 0; i < copy.length; i++) {
			copy[i] = toBeCoppied.charAt(i);
		}
		return new String(copy);
	}

	static String copyRecusively(String toBeCoppied, String copy, int index) {
		if (copy.length() == toBeCoppied.length()) {
			return copy;
		}
		copy = copy + toBeCoppied.charAt(index);
		return copyRecusively(toBeCoppied, copy, index + 1);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s1 = scanner.nextLine();

			String result = copyIteratively(s1);
			System.out.println(result);

			String result1 = copyRecusively(s1, "", 0);
			System.out.println(result1);
		}

		scanner.close();
	}
}
