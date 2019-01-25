package com.tasks.strings;

import java.util.Comparator;
import java.util.PriorityQueue;

// Given a string with repeated characters, task is rearrange characters in a
// string so that no two adjacent characters are same.
public class NoRepeatedChar {

	public static String noRepeatedChar(String input) {
		char[] inputArr = input.toCharArray();
		char[] word = new char[input.length()];
		PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair pair1, Pair pair2) {
				if (pair1.count < pair1.count)
					return -1;
				else
					return 1;
			}
		});
		// form pairs
		int[] letters = new int[26];
		for (int i = 0; i < inputArr.length; i++) {
			char current = inputArr[i];
			letters[current - 'a'] += 1;
		}
		for (int i = 0; i < letters.length; i++) {
			int current = letters[i];
			if (current != 0) {
				queue.add(new Pair((char) (i + 'a'), current));
			}
		}
		StringBuilder sb = new StringBuilder();
		Pair toBeAdded = null;
		for (int i = 0; i < word.length; i++) {
			Pair current = queue.poll();
			if (current == null) {
				return "NOT POSSIBLE";
			}
			word[i] = current.letter;
			current.count--;
			if (toBeAdded != null && current.count > 0) {
				queue.add(toBeAdded);
			} else {
				toBeAdded = null;
			}
			toBeAdded = current;
		}
		return String.valueOf(word);
	}

	public static void main(String[] args) {
		System.out.println(noRepeatedChar("aaa"));
		System.out.println(noRepeatedChar("aaabc"));
		System.out.println(noRepeatedChar("aaabb"));
		System.out.println(noRepeatedChar("aaaabc"));
	}
}

class Pair {
	int count;
	char letter;

	public Pair(char letter, int count) {
		this.letter = letter;
		this.count = count;
	}
}
