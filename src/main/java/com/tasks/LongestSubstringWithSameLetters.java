package com.tasks;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class LongestSubstringWithSameLetters {

	public static int solution(String[] words) {
		Map<Character, PriorityQueue<Pair>> prefixes = new HashMap<>();
		Map<Character, PriorityQueue<Pair>> suffixes = new HashMap<>();
		HashSet<Character> letters = new HashSet<>();
		Map<Character, Integer> wordSameLetters = new HashMap<>();
		// max substring consisting of the same letters that is between prefix and
		// suffix;
		int middleMax = Integer.MIN_VALUE;
		Comparator<Pair> pairComparator = new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return -(p1.occurence - p2.occurence);
			}
		};
		for (int i = 0; i < words.length; i++) {
			boolean skipSuffix = false;
			String currentWord = words[i];
			char[] wordToArray = currentWord.toCharArray();
			char prefixChar = wordToArray[0];
			letters.add(prefixChar);
			int prefix = 1;
			// find prefix
			for (int j = 1; j < wordToArray.length; j++) {
				if (wordToArray[j] == prefixChar) {
					prefix++;
				} else {
					if (prefixes.containsKey(prefixChar)) {
						PriorityQueue<Pair> pq = prefixes.get(prefixChar);
						pq.add(new Pair(i, prefix));
						prefixes.put(prefixChar, pq);
					} else {
						PriorityQueue<Pair> pq = new PriorityQueue<>(pairComparator);
						pq.add(new Pair(i, prefix));
						prefixes.put(prefixChar, pq);
					}
					break;
				}
			}
			// prefix ended add to prefix map
			if (prefix == wordToArray.length) {
				skipSuffix = true;
				if (wordSameLetters.containsKey(prefixChar)) {
					wordSameLetters.put(prefixChar, wordSameLetters.get(prefixChar) + prefix);
				} else {
					wordSameLetters.put(prefixChar, prefix);
				}
			}
			if (!skipSuffix) {
				// find suffix
				char suffixChar = wordToArray[wordToArray.length - 1];
				letters.add(suffixChar);
				int suffix = 1;
				for (int k = wordToArray.length - 2; k >= 0; k--) {
					if (wordToArray[k] == suffixChar) {
						suffix++;
					} else {
						// suffix ended add to prefix map
						if (suffixes.containsKey(suffixChar)) {
							PriorityQueue<Pair> pq = suffixes.get(suffixChar);
							pq.add(new Pair(i, suffix));
							suffixes.put(suffixChar, pq);
						} else {
							PriorityQueue<Pair> pq = new PriorityQueue<>(pairComparator);
							pq.add(new Pair(i, suffix));
							suffixes.put(suffixChar, pq);
						}
						break;
					}
				}

				// save chars from prefix to suffix in the letter set
				// search for long middle substring
				for (int p = prefix ; p < wordToArray.length - suffix; p++) {
					letters.add(wordToArray[p]);
					int middle = 1;
					int next = p + 1;
					while (wordToArray[p] == wordToArray[next]) {
						next++;
						middle++;
					}
					p = next - 1;
					if (middle > middleMax) {
						middleMax = middle;
					}
				}
			}
		}
		// find longest substring
		int longest = Integer.MIN_VALUE;
		// for each letter
		for (Iterator iterator = letters.iterator(); iterator.hasNext();) {
			Character character = (Character) iterator.next();
			int currentL = 0;
			if (wordSameLetters.containsKey(character)) {
				currentL = wordSameLetters.get(character);
			}
			if (prefixes.get(character) == null && suffixes.get(character) != null) {
				Pair suffixPair = suffixes.get(character).poll();
				currentL += suffixPair.occurence;
			} else if (suffixes.get(character) == null && prefixes.get(character) != null) {
				Pair prefixPair = prefixes.get(character).poll();
				currentL += prefixPair.occurence;
			} else if (prefixes.get(character) != null && suffixes.get(character) != null) {
				Pair prefixPair = prefixes.get(character).poll();
				Pair suffixPair = suffixes.get(character).poll();
				if (prefixPair.wordIndex != suffixPair.wordIndex) {
					currentL += suffixPair.occurence + prefixPair.occurence;
				} else {
					if (prefixPair.occurence > suffixPair.occurence) {
						if (suffixes.get(character).peek() == null) {
							currentL += prefixPair.occurence;
						} else {
							currentL += prefixPair.occurence + suffixes.get(character).poll().occurence;
						}
					} else {
						if (prefixes.get(character).peek() == null) {
							currentL += suffixPair.occurence;
						} else {
							Pair p = prefixes.get(character).poll();
							currentL += suffixPair.occurence + p.occurence;
						}
					}
				}
			}
			// if we found longer substring, change the maximum length
			if (currentL > longest) {
				longest = currentL;
			}
		}

		// if a substring in the middle is longer that a concatenation of prefixes and
		// suffixes
		if (longest < middleMax) {
			return middleMax;
		}
		return longest;
	}

	public static void main(String[] args) {
		 System.out.println(solution(new String[] { "aabb", "aaaa", "bbab"}));
		 System.out.println(solution(new String[] { "xxbxx", "xbx", "x" }));
		 System.out.println(solution(new String[] { "dd", "bb", "cc", "dd" }));
		System.out.println(solution(new String[] { "baaaab", "aaaa", "baaa", "cdc", "aaaadd" }));
		System.out.println(solution(new String[] { "abbba"}));
		System.out.println(solution(new String[] { "aaaa"}));
		System.out.println(solution(new String[] { "aaaa", "aaa"}));
		System.out.println(solution(new String[] { "aaaa", "aaa" , "xa"}));
		System.out.println(solution(new String[] { "aaabbccc", "aaabbb"}));
	}
}
