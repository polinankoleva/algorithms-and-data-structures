package com.tasks;

public class Compression {

	// input -> aaabbc
	// output -> 3a2bc
	// input 3aa -> 3 2a
	// input 333aaa 
	public static String compress(String s) {
		StringBuilder sb = new StringBuilder();
		char[] sArr = s.toCharArray();
		char previous = sArr[0];
		int count = 0;
		for (int i = 1; i < sArr.length; i++) {
			char current = sArr[i];
			if (previous == current) {
				count++;
				if(i == sArr.length - 1) {
					count++;
					sb.append(Integer.toString(count) + previous);
				}
			} else {
				count++;
				if (count == 1) {
					sb.append(previous);
				} else {
					sb.append(Integer.toString(count) + previous);
				}
				count = 0;
				previous = current;
				if(i == sArr.length - 1) {
					sb.append(previous);
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(compress("aaabbc"));

	}

}
