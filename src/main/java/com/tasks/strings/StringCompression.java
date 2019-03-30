package com.tasks.strings;

public class StringCompression {
	public static String compression(String s) {
		StringBuilder sb = new StringBuilder();
		int currentCount = 0;
		char[] sToCharArr = s.toCharArray();
		for (int i = 0; i < sToCharArr.length - 1; i++) {
			char current = sToCharArr[i];
			char next = sToCharArr[i + 1];
			if (current == next) {
				currentCount++;
			} else {
				currentCount++;
				sb.append(current);
				sb.append(currentCount);
				// add to the bilder
				currentCount = 0;
			}
		}
		// add the last char
		sb.append(sToCharArr[s.length() - 1]);
		sb.append(currentCount + 1);
		String compressed = sb.toString();
		if (compressed.length() > s.length()) {
			return s;
		} else {
			return compressed;
		}
	}

	public static void main(String[] args) {
		System.out.println(compression("abc"));
		System.out.println(compression("aabc"));
		System.out.println(compression("abcabc"));
		System.out.println(compression("aabcccccaaa"));
	}
}
