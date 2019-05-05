package com.tasks.strings;

/**
 * Implement methods that take a string representing an integer and return the
 * corresponding integer, and vice versa. Task 7.1, EPI book.
 * 
 * @author Polina Koleva
 *
 */
public class StringIntegerCoverter {

	public static String intToString(int number) {
		// handle minus sign
		boolean isNegative = false;
		if (number < 0) {
			isNegative = true;
			number *= -1;
		}

		StringBuilder sb = new StringBuilder();
		int remainder = 10;
		int divisor = 1;
		while (true) {
			int nextDigit = (number % remainder) / divisor;
			if (nextDigit == 0 && stringToInt(reverse(sb.toString())) == number) {
				break;
			}
			sb.append(nextDigit);
			remainder *= 10;
			divisor *= 10;
		}
		
		return isNegative ? "-" + reverse(sb.toString()) :reverse(sb.toString());
	}

	public static String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	public String digitToString(int digit) {
		switch (digit) {
		case 0:
			return "0";
		case 1:
			return "1";
		case 2:
			return "2";
		case 3:
			return "3";
		case 4:
			return "4";
		case 5:
			return "5";
		case 6:
			return "6";
		case 7:
			return "7";
		case 8:
			return "8";
		case 9:
			return "9";
		default:
			// invalid input
			return "-1";
		}
	}

	public static int stringToInt(String number) {
		int result = 0;
		int end = 0;
		// parse digit by digit
		char[] digits = number.toCharArray();
		boolean isNegative = false;
		if (digits[0] == '-') {
			isNegative = true;
			end = 1;
		}
		// start from the last digit
		for (int i = digits.length - 1; i >= end; i--) {
			int intDigit = getDigit(digits[i]);
			result += (intDigit * getZerodNumber(digits.length - 1 - i));
		}
		if (isNegative) {
			result *= -1;
		}
		return result;
	}

	public static int getZerodNumber(int zeros) {
		int result = 1;
		for (int i = 0; i < zeros; i++) {
			result *= 10;
		}
		return result;
	}

	public static int getDigit(char digit) {
		switch (digit) {
		case '0':
			return 0;
		case '1':
			return 1;
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;
		default:
			// invalid number
			return -1;
		}
	}

	public static void main(String[] args) {
		// System.out.println(stringToInt("1233455"));
		// System.out.println(stringToInt("-123"));
		// System.out.println((4513%100000)/10000);
		System.out.println(intToString(-123));
	}
}
