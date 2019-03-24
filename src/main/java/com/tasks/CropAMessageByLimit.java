package com.tasks;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Crop a message to a particular limit. Message contains only spaces and letters from the aplhabet.
 * Final message cannot:
 * 1) exceed the limit
 * 2) contains non-complete words
 * 3) ends with a space
 * 4) be short than the optimal solution
 * For example, "Codility We test coders", 14 -> "Codility We"
 * @author Polina Koleva
 *
 */
public class CropAMessageByLimit {
	public static String solution(String message, int K) {
		// if initial message is shorter than the limit, cropping not needed
		if(message.length() < K) {
			return message;
		}
		// create a hash set of possible words, split the message by space 
		HashSet<String> wordsSet = new HashSet<>(Arrays.asList(message.split(" ")));
		// crop the message by the limit
		message = message.substring(0, K);
		// find if the last word is complete
		String lastWord = message.substring(message.lastIndexOf(" ") + 1);
		// if message does not end with space
		if(!lastWord.isEmpty()) {
			System.out.println(lastWord);
			if(!wordsSet.contains(lastWord)) {
				message = message.substring(0, message.lastIndexOf(" "));
			}
		} else {
			//trim the message to remove any spaces at the end
			message.trim();
		}
		return message;
	}

	public static void main(String[] args) {
		System.out.println(solution("Codility We test coders", 14));
	}

}
