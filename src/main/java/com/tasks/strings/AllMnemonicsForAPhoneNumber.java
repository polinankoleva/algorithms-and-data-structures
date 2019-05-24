package com.tasks.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program which takes as input a phone number, specified as a string of
 * digits, and returns all possible character sequences that correspond to the
 * phone number. The cell phone keypad is specified by a mapping that takes a
 * digit and returns the corresponding set of characters. The character
 * sequences do not have to be legal words or phrases.
 * 
 * Task 7.7, EPI book
 * @author Polina Koleva
 *
 */
public class AllMnemonicsForAPhoneNumber {

	public static List<char[]> allMnemonics(String phone) {
		List<char[]> result = new ArrayList<>();
		char[] phoneArr = phone.toCharArray();
		allMnemonics(result, new char[phoneArr.length], 0, phoneArr);
		return result;
	}

	public static void allMnemonics(List<char[]> result, char[] current, int index, char[] phone) {
		if (index == phone.length) {
			result.add(current);
			return;
		}
		char[] possibleChars = getChar(Character.getNumericValue(phone[index]));
		for (char c : possibleChars) {
			char[] copy = deepCopy(index - 1, current);
			copy[index] = c;
			allMnemonics(result, copy, index + 1, phone);
		}
	}

	public static char[] deepCopy(int index, char[] current) {
		char[] copy = new char[current.length];
		for (int i = 0; i <= index; i++) {
			copy[i] = current[i];
		}
		return copy;
	}

	public static char[] getChar(int number) {
		switch (number) {
		case 2:
			return new char[] { 'a', 'b', 'c' };
		case 3:
			return new char[] { 'd', 'e', 'f' };
		case 4:
			return new char[] { 'g', 'h', 'i' };
		case 5:
			return new char[] { 'j', 'k', 'l' };
		case 6:
			return new char[] { 'm', 'n', 'o' };
		case 7:
			return new char[] { 'p', 'q', 'r', 's' };
		case 8:
			return new char[] { 't', 'u', 'v' };
		case 9:
			return new char[] { 'w', 'y', 'x', 'z' };
		default:
			return new char[] {};
		}

	}

	public static void main(String[] args) {
		List<char[]> result = allMnemonics("2276696");
		for (char[] res : result) {
			for (char c : res) {
				System.out.print(c);
			}
			System.out.println();
		}

	}

}
