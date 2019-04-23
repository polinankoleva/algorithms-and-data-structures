package com.tasks.dp;

/**
 * Given a string of characters of length less than 10. We need to print all the
 * alpha-numeric abbreviation of the string.
 * 
 * The alpha-numeric abbreviation is in the form of characters mixed with the
 * digits which is equal to the number of skipped characters of a selected
 * substring. So, whenever a substring of characters is skipped, you have to
 * replace it with the digit denoting the number of characters in the substring.
 * There may be any number of skipped substrings of a string. No two substrings
 * should be adjacent to each other. Hence, no two digits are adjacent in the
 * result
 * 
 * @author Polina Koleva
 *
 */
public class AlphaNumericAbbriviation {
	public static void printAlphaNumbericValue(String result, String input, int offset) {
		if (offset >= input.length()) {
			System.out.println(result);
			return;
		}
		char currentChar = input.charAt(offset);
		if (result.isEmpty()) {
			printAlphaNumbericValue(result + 1, input, offset + 1);
			printAlphaNumbericValue(result + currentChar, input, offset + 1);
			return;
		}
		char resultLastChar = result.charAt(result.length() - 1);
		if (Character.isDigit(resultLastChar)) {
			int lastNumber = Character.getNumericValue(resultLastChar);
			lastNumber++;
			printAlphaNumbericValue(result.substring(0, result.length() - 1) + lastNumber, input, offset + 1);
		} else {
			printAlphaNumbericValue(result + 1, input, offset + 1);
		}

		printAlphaNumbericValue(result + currentChar, input, offset + 1);

	}

	public static void main(String[] args) {
		printAlphaNumbericValue("", "ABC", 0);
	}
}
