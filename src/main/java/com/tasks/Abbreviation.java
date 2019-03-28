package com.tasks;

import java.util.Scanner;

/**
 * You can perform the following operations on the string,a :
 * 
 * Capitalize zero or more of a's lowercase letters. 
 * Delete all of the remaining lowercase letters in a.
 * Given two strings,a and b, determine if it's possible to
 * make a equal to b as described. 
 * If so, print YES on a new line. Otherwise, print NO.
 * 
 * @author Polina Koleva
 *
 */
public class Abbreviation {
	// Complete the abbreviation function below.
	static String abbreviation(String a, String b) {
		if (a.isEmpty() && b.isEmpty())
			return "YES";
		if (a.length() < b.length())
			return "NO";
		if (a.length() == b.length()) {
			if (a.equals(b)) {
				return "YES";
			}
		}
		if (isEqualDP(a.toCharArray(), b.toCharArray())) {
			return "YES";
		}
		return "NO";
	}

	static boolean isLowercase(char[] a, int start) {
		for (int i = start; i < a.length; i++) {
			if (Character.isUpperCase(a[i]))
				return false;
		}
		return true;
	}

	static boolean isEqual(char[] a, int aIndex, char[] b, int bIndex) {
		if (bIndex >= b.length) {
			if (isLowercase(a, aIndex)) {
				return true;
			} else {
				return false;
			}

		} else {
			if (aIndex >= a.length) {
				return false;
			}
		}
		if (a[aIndex] == b[bIndex]) {
			return isEqual(a, aIndex + 1, b, bIndex + 1);
		} else if (Character.isLowerCase(a[aIndex])) {
			if (Character.toUpperCase(a[aIndex]) == b[bIndex]) {
				return isEqual(a, aIndex + 1, b, bIndex) || isEqual(a, aIndex + 1, b, bIndex + 1);
			} else {
				return isEqual(a, aIndex + 1, b, bIndex);
			}
		} else
			return false;
	}

	static boolean isEqualDP(char[] a, char[] b) {
		boolean[][] matrix = new boolean[a.length + 1][b.length + 1];
		matrix[0][0] = true;
		// initialize first row
		for (int j = 1; j < b.length; j++) {
			matrix[0][j] = false;
		}
		// initialize first column
		for (int j = 1; j < a.length; j++) {
			if (Character.isLowerCase(a[j - 1])) {
				if (j == 1) {
					matrix[j][0] = true;
				} else {
					matrix[j][0] = matrix[j - 1][0];
				}
			} else {
				matrix[j][0] = false;
			}
		}
		// rows
		for (int i = 1; i <= a.length; i++) {
			// columns
			for (int j = 1; j <= b.length; j++) {
				System.out.println(a[i - 1]);
				System.out.println(b[j - 1]);
				if (a[i - 1] == b[j - 1]) {
					matrix[i][j] = matrix[i - 1][j - 1];
				} else if (Character.isLowerCase(a[i - 1])) {
					if (Character.toUpperCase(a[i - 1]) == b[j - 1]) {
						matrix[i][j] = matrix[i - 1][j - 1] || matrix[i - 1][j];
					} else {
						// deletion is allowed
						matrix[i][j] = matrix[i - 1][j];
					}
				} else {
					matrix[i][j] = false;
				}
			}
		}
		return matrix[a.length][b.length];
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String a = scanner.nextLine();

			String b = scanner.nextLine();

			String result = abbreviation(a, b);

			System.out.println(result);
		}

		scanner.close();
	}
}
