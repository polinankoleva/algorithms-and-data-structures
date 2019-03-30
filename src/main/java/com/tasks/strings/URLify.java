package com.tasks.strings;

public class URLify {
	public static String urlify(String str, int trueLength) {
		int spaces = str.length() - str.trim().length();
		int charArrLenght = trueLength - spaces + spaces*3;
		char[] strChar = new char[charArrLenght];
		int strIndex = 0;
		for (int i = 0; i < strChar.length; i++) {
			char current = str.charAt(strIndex);
			if (current == ' ') {
				strChar[i] = '%';
				strChar[i + 1] = '2';
				strChar[i + 2] = '0';
				i = i + 2;
			} else {
				strChar[i] = current;
			}
			strIndex++;
		}
		return strChar.toString();
	}

	public static void main(String[] args) {
		System.out.println(urlify("Mr John Smith  ", 13));
	}

}
