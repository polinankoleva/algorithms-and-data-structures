package com.tasks;

/**
 * Given a mapping for each character from a to z. For example 'a' corresponds
 * to 1, 'b' corresponds to 2 ... and 'z' corresponds to 26. Given a word
 * containing only integers, return the possible ways of decoding this word. For
 * example, '12' can be decoded as 'ab' or as 'l'. TODO add memoization + DP
 * 
 * @author Polina Koleva
 *
 */
public class WaysOfDecodingMessage {

	// Recursive solution is exponential, 
	// use memoization to make it linear
	public static int helper(int start, char[] message) {
		if (start - message.length == 0) {
			return 1;
		}
		if (message[start] == 0) {
			return 0;
		}
		if (start < message.length - 1) {
			String doubleLetter = String.valueOf(message[start]) + String.valueOf(message[start + 1]);
			int doubleInt = Integer.valueOf(doubleLetter);
			if (doubleInt < 27) {
				return helper(start + 1, message) + helper(start + 2, message);
			}
		} else {
			return helper(start + 1, message);
		}
		return 1;
	}

	public static int numOfDecodes(String message) {
		char[] messageToArray = message.toCharArray();
		return helper(0, messageToArray);
	}

	public static void main(String[] args) {
		System.out.println(numOfDecodes(""));
		System.out.println(numOfDecodes("12"));
	}
}
