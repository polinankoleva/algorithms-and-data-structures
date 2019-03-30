package com.tasks.strings;

/**
 * Check if two strings are one or zero edit away. Types of edit: insert a char,
 * delete a char or replace a char.
 * 
 * @author Polina Koleva
 *
 */
public class OneAway {
	public static boolean isOneEditAway(String s1, String s2) {
		if (s1.equals(s2))
			return true;
		String smallest;
		String longest;
		if (s1.length() > s2.length()) {
			smallest = s2;
			longest = s1;
		} else {
			smallest = s1;
			longest = s2;
		}
		for (int i = 0; i < smallest.length(); i++) {
			if (smallest.charAt(i) != longest.charAt(i)) {
				boolean deletion = smallest.substring(i + 1).equals(longest.substring(i));
				boolean insertion = smallest.substring(i).equals(longest.substring(i + 1));
				boolean replacement = smallest.substring(i + 1).equals(longest.substring(i + 1));
				return deletion || insertion || replacement;
			}
		}
		return (longest.substring(smallest.length()).length() <= 1);
	}

	public static void main(String[] args) {
		System.out.println(isOneEditAway("pale", "ple"));
		System.out.println(isOneEditAway("pales", "pale"));
		System.out.println(isOneEditAway("pale", "bale"));
		System.out.println(isOneEditAway("pale", "bake"));
		System.out.println(isOneEditAway("pala", "paleeeeeeee"));
	}
}
