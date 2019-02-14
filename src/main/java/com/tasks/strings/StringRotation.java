package com.tasks.strings;

import java.util.LinkedList;

public class StringRotation {

	// check if s2 is a rotation of s1
	public static boolean checkRotation(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		// handles left and right rotation
		return (s1+s1).contains(s2);
	}

	public static boolean checkRotationBy2(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		 //check right rotation
		boolean rightRotation = (s2.equals(rotateRight(s1, 2)));
		// check left rotation
		boolean leftRotation = (s2.equals(rotateLeft(s1, 2)));
		return rightRotation || leftRotation;
	}
	
	public static String rotateLeft(String s, int places) {
		if(places>s.length()) throw new IllegalArgumentException();
		String prefix = s.substring(0, places);
		return s.substring(places) + prefix;
	}
	
	public static String rotateRight(String s, int places) {
		if(places>s.length()) throw new IllegalArgumentException();
		String suffix = s.substring(s.length() - places);
		return suffix + s.substring(0, s.length() - places) ;
	}
	
	public static String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
//		System.out.println(checkRotation("", ""));
//		System.out.println(checkRotation("", "aaa"));
//		System.out.println(checkRotation("aaa", ""));
//		System.out.println(checkRotation("stackoverflow", "tackoverflows"));
//		System.out.println(checkRotation("stackoverflow", "ackoverflowst"));
//		System.out.println(checkRotation("stackoverflow", "overflowstack"));
//		System.out.println(checkRotation("stackoverflow", "stackoverflwo"));
		
//		System.out.println(rotateLeft("amazon", 2));
//		System.out.println(rotateRight("amazon", 2));
		System.out.println(checkRotationBy2("amazon", "azonam"));
		System.out.println(checkRotationBy2("amazon", "onamaz"));
		System.out.println(checkRotationBy2("amazon", "noamaz"));
		System.out.println(checkRotationBy2("geeks", "eksge"));
	}
}
