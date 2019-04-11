package com.tasks.dp;

/**
 * Given a string, the task is to return the length of its longest possible
 * chunked palindrome. It means a palindrome formed by substring in the case
 * when it is not formed by characters of the string.
 * Example:
 * Input : ghiabcdefhelloadamhelloabcdefghi 
 * Output : 7
 * (ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)
 * 
 * @author Polina Koleva
 * 
 *
 */
public class LongestPossibleChunkedPalindrome {

	public static int count(String str) {
		if(str.length() == 0) return 0;
		// find last letter
		char lastLetter = str.charAt(str.length() - 1);
		int indexFound = -1;
		for (int i = 0; i < str.length() - 1; i++) {
			if(str.charAt(i) == lastLetter) {
				indexFound = i;
				break;
			}
		}
		// no found palindrome
		if(indexFound == -1) return 1;
		// check if palindromes
		String forwardPalindrome = str.substring(0, indexFound + 1);
		String backwardPalindrome = str.substring(str.length() - (indexFound + 1));
		if(forwardPalindrome.equals(backwardPalindrome)) {
			return 2 + count(str.substring(indexFound+1, str.length() - (indexFound + 1)));
		}
		return 1;
		
	}
	
	public static boolean checkPalindrome(String forwardPalindrome, String backwardPalindrome) {
		if(forwardPalindrome.length() != backwardPalindrome.length()) return false;
		for(int i = 0; i< forwardPalindrome.length(); i++) {
			if(forwardPalindrome.charAt(i) != backwardPalindrome.charAt(backwardPalindrome.length() - 1 -i)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(count("ghiabcdefhelloadamhelloabcdefghi"));
		System.out.println(count("merchant"));
		System.out.println(count("antaprezatepzapreanta"));
		System.out.println(count("geeksforgeeks"));
	}

}
