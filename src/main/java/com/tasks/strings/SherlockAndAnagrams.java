package com.tasks.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Two strings are anagrams of each other if the letters of one string can be
 * rearranged to form the other string. Given a string, find the number of pairs
 * of substrings of the string that are anagrams of each other.
 * 
 * @author Polina Koleva
 *
 */
public class SherlockAndAnagrams {

	// Complete the sherlockAndAnagrams function below.
	static int sherlockAndAnagrams(String s) {
		int pairs = 0;
		HashMap<String, Integer> anagrams = new HashMap<>();
		// length of the anagram
		for (int i = 1; i <= s.length() - 1; i++) {
			// start of the anagram
			for (int j = 0; j <= s.length() - i; j++) {
				String substring = s.substring(j, j + i);
				// convert input string to char array
				char tempArray[] = substring.toCharArray();
				Arrays.sort(tempArray);
				String sorted = new String(tempArray);
				if (anagrams.containsKey(sorted)) {
					pairs += anagrams.get(sorted);
					anagrams.put(sorted, anagrams.get(sorted) + 1);
				} else {
					anagrams.put(sorted, 1);
				}
			}

		}
		return pairs;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			int result = sherlockAndAnagrams(s);

			System.out.println(String.valueOf(result));
			System.out.println();
		}
		scanner.close();
	}

}
