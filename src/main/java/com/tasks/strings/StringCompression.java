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
				// add to the builder
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

	public static String compressionRecursive(String s) {
		StringBuilder sb = new StringBuilder();
		compressionRecursive(sb, 0, s.toCharArray());
		return sb.toString();
	}

	public static void compressionRecursive(StringBuilder result, int index, char[] s) {
		if (index >= s.length)
			return;
		if (index + 1 == s.length) {
			result.append(s[index]);
			return;
		}
		int count = 1;
		char current = s[index];
		int nextIndex = index + 1;
		char next = s[nextIndex];
		while (nextIndex < s.length && current == next) {
			count++;
			nextIndex++;
			if (nextIndex < s.length) {
				next = s[nextIndex];
			}
		}
		result.append(current);
		if (count != 1) {
			result.append(count);
		}
		compressionRecursive(result, nextIndex, s);
	}

	public static void main(String[] args) {
		 System.out.println(compressionRecursive("abc"));
		 System.out.println(compressionRecursive("aabc"));
		 System.out.println(compressionRecursive("abcabc"));
		System.out.println(compressionRecursive("aabcccccaaa"));
	}
}
