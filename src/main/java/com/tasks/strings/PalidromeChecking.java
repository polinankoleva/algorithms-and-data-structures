package com.tasks.strings;

/**
 * Common class for different tasks over palindromes. Palidrome is a word,
 * phrase, or sequence that reads the same backwards as forwards, e.g. madam or
 * nurses run.
 * 
 * @author Polina Koleva
 *
 */
public class PalidromeChecking {
	/**
	 * Check if characters of a given string can be rearranged to form a
	 * palindrome.
	 * 
	 * @return true/false
	 */
	public static boolean canFormPalindrome(String palindromeToCheck) {
		// use either count array or a map
		int[] alphabet = new int[26];
		char[] palidromeToArray = palindromeToCheck.toCharArray();
		for (int i = 0; i < palidromeToArray.length; i++) {
			char letter = palidromeToArray[i];
			int index = letter - 'a';
			alphabet[index]++;
		}
		boolean fisrtOdd = false;
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] % 2 != 0) {
				if (!fisrtOdd) {
					fisrtOdd = true;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Given a string str, the task is to find the minimum number of characters
	 * to be replaced to make a given string palindrome. Replacing a character
	 * means replacing it with any single character at the same position. We are
	 * not allowed to remove or add any characters.
	 * 
	 * @param palindromeToBe
	 * @return
	 */
	public static int minimumChangesToFormPalidrome(String palindromeToBe) {
		char[] palidromeArray = palindromeToBe.toCharArray();
		int changes = 0;
		for (int i = 0; i < palidromeArray.length / 2; i++) {
			if (palidromeArray[i] != palidromeArray[palidromeArray.length - 1 - i]) {
				changes++;
				if (palidromeArray[i] < palidromeArray[palidromeArray.length - 1 - i]) {
					palidromeArray[palidromeArray.length - 1 - i] = palidromeArray[i];
				} else {
					palidromeArray[i] = palidromeArray[palidromeArray.length - 1 - i];
				}
			}
		}
		System.out.println(String.valueOf(palidromeArray));
		return changes;
	}

	/**
	 * Convert string S into a palindrome string. You can only replace a
	 * character with any other character. When you replace character ‘a’ with
	 * any other character, it costs 1 unit, similarly for ‘b’ it is 2 units …..
	 * and for ‘z’, it is 26 units. Find the minimum cost required to convert
	 * string S into palindrome string.
	 * 
	 * @param palimdromeToBe
	 * @return
	 */
	public static int minimumCostToPalidrome(String palindromeToBe) {
		char[] palidromeArray = palindromeToBe.toCharArray();
		int cost = 0;
		for (int i = 0; i < palidromeArray.length / 2; i++) {
			if (palidromeArray[i] != palidromeArray[palidromeArray.length - 1 - i]) {
				if (palidromeArray[i] < palidromeArray[palidromeArray.length - 1 - i]) {
					cost += palidromeArray[i] - 'a' + 1;
					palidromeArray[i] = palidromeArray[palidromeArray.length - 1 - i];
				} else {
					cost += palidromeArray[palidromeArray.length - 1 - i] - 'a' + 1;
					palidromeArray[palidromeArray.length - 1 - i] = palidromeArray[i];
				}
			}
		}
		System.out.println(String.valueOf(palidromeArray));
		return cost;
	}

	/**
	 * Given a string, find the minimum number of characters to be inserted to
	 * convert it to palindrome.
	 * 
	 * @param palindromeToBe
	 * @return
	 */
	public static int minInsertionsToPalidrome(int start, int end, char[] palindromeToBe) {
		if (start >= end) {
			return 0;
		}
		if (palindromeToBe[start] == palindromeToBe[end]) {
			return minInsertionsToPalidrome(start + 1, end - 1, palindromeToBe);
		} else {
			return Math.min(minInsertionsToPalidrome(start, end - 1, palindromeToBe) + 1,
					minInsertionsToPalidrome(start + 1, end, palindromeToBe) + 1);
		}
	}

	/**
	 * Longest common sequence, common subproblems solution
	 * 
	 * @return length of the longest common sequence
	 */
	public static int longestCommonSequence1(char[] s1, int s1Start, char[] s2, int s2Start) {
		if (s1Start >= s1.length || s2Start >= s2.length) {
			return 0;
		}
		if (s1[s1Start] == s2[s2Start]) {
			return longestCommonSequence1(s1, s1Start + 1, s2, s2Start + 1) + 1;
		} else {
			return Math.max(longestCommonSequence1(s1, s1Start + 1, s2, s2Start),
					longestCommonSequence1(s1, s1Start, s2, s2Start + 1));
		}
	}

	/**
	 * Longest common sequence, memoization solution.
	 * 
	 * @return length of the longest common sequence
	 */
	public static int longestCommonSequence2(char[] s1, int m, char[] s2, int n) {
		int[][] matrix = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					matrix[i][j] = 0;
				} else if (s1[i - 1] == s2[j - 1]) {
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
				} else {
					matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
				}
			}
		}
		return matrix[m][n];
	}

	public static String longestCommonSequenceBacktracking(char[] s1, char[] s2, int[][] matrix) {
		int m = s1.length;
		int n = s2.length;
		int sequenceSize = matrix[m][n];
		char[] longestSequence = new char[sequenceSize + 1];
		while (sequenceSize >= 0) {
//			if(matrix[m][n] == matrix[m-1][n-1]){
//				longestSequence[sequenceSize] = s1[m];
//				sequenceSize--;
//				m = m-1;
//				n = n-1;
//			} else if(){
//				
//			} else {
//				
//			}
		}
		return String.valueOf(longestSequence);
	}

	public static void main(String[] args) {
		// // test if a string can be arranged as a palidrome
		// System.out.println(canFormPalindrome("geeksogeeks"));
		// System.out.println(canFormPalindrome("geeksforgeeks"));
		//
		// // test minimum changes to form a palidrome
		// System.out.println(minimumChangesToFormPalidrome("geeks"));
		// System.out.println(minimumChangesToFormPalidrome("ameba"));
		//
		// // test minimum cost to form a palidrome
		// System.out.println(minimumCostToPalidrome("abcdef"));
		// System.out.println(minimumCostToPalidrome("aba"));

		// test minimum insertions to form a palidrome
		// System.out.println(minInsertionsToPalidrome(0, 1,
		// "ab".toCharArray()));
		// System.out.println(minInsertionsToPalidrome(0, 1,
		// "aa".toCharArray()));
		// System.out.println(minInsertionsToPalidrome(0, 3,
		// "abcd".toCharArray()));
		// System.out.println(minInsertionsToPalidrome(0, 4,
		// "abcda".toCharArray()));
		// System.out.println(minInsertionsToPalidrome(0, 4,
		// "abcde".toCharArray()));

		// check longest sequence in two strings
		System.out.println(longestCommonSequence2("ABCDGH".toCharArray(), 6, "AEDFHR".toCharArray(), 6));
		System.out.println(longestCommonSequence2("AGGTAB".toCharArray(), 6, "GXTXAYB".toCharArray(), 7));
	}

}
