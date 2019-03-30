package com.tasks.hashing;

import java.util.Scanner;

public class CheckIfFrequenciesEqual {
	public static boolean ifFrequenciesEqual(String str) {
		// count frequencies of each char in the string
		char[] letters = str.toCharArray();
		int[] frequencies = new int[26];
		for (int i = 0; i < letters.length; i++) {
			int index = letters[i] - 'a';
			frequencies[index] += 1;
		}
		boolean oneChange = false;
		int lastNotNullIndex = 0;
		for (int i = 0; i < frequencies.length - 1; i++) {
			if (frequencies[i] != 0) {
				lastNotNullIndex = i;
				break;
			}
		}

		for (int i = lastNotNullIndex + 1; i < frequencies.length - 1; i++) {
			if (frequencies[i] == 0)
				continue;
			if (frequencies[lastNotNullIndex] != frequencies[i]) {
				if (oneChange)
					return false;
				if (Math.abs(frequencies[lastNotNullIndex] - frequencies[i]) > 1)
					return false;
				if (frequencies[lastNotNullIndex] > frequencies[i]) {
					if (i == 0) {
						oneChange = true;
						frequencies[lastNotNullIndex] -= 1;
					} else {
						return false;
					}
				} else {
					frequencies[i] -= 1;
					oneChange = true;
				}
			}
			lastNotNullIndex = i;
		}
		return true;
	}

	private static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = in.nextInt();
		for (int i = 0; i < testCases; i++) {
			String str = in.next();
			boolean result = ifFrequenciesEqual(str);
			if (result) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}

	}
}
