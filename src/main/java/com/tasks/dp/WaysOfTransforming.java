package com.tasks.dp;

/**
 * Given two sequences A, B, find out number of unique ways in sequence A, to
 * form a subsequence of A that is identical to the sequence B. Transformation
 * is meant by converting string A (by removing 0 or more characters) to string
 * B.
 * 
 * 
 * @author Polina Koleva
 *
 */
public class WaysOfTransforming {
	public static int waysOfTransforming(String a, String b) {
		// base case
		if (b.isEmpty())
			return 1;
		if (a.equals(b))
			return 1;
		if (a.length() < b.length())
			return 0;
		char aChar = a.charAt(0);
		char bChar = b.charAt(0);
		int count = 0;
		String aNew = a.substring(1);
		if (aChar == bChar) {
			// remove both first chars and continue
			String equalFirstLetters = new String(aNew);
			String bNew = b.substring(1);
			count += waysOfTransforming(equalFirstLetters, bNew);
		}
		count += waysOfTransforming(aNew, b);
		return count;
	}

	public static void main(String[] args) {
		System.out.println(waysOfTransforming("abcccdf", "abccdf"));
		System.out.println(waysOfTransforming("aabba", "ab"));
	}

}
