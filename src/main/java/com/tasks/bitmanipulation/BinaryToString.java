package com.tasks.bitmanipulation;

import java.util.Arrays;

/**
 * Given a real number between 0 and 1 (0.72) that is passed in as a double,
 * print the binary representation. If the number cannot be represented
 * accurately in binary with at most 32 characters, print "ERROR".
 * 
 * @author Polina Koleva
 *
 */
public class BinaryToString {
	// int to binary
	public static String intToBinaryString(int number) {
		boolean[] numberBinary = new boolean[32];
		int power = (int) (Math.log(number) / Math.log(2));
		if (power > 31) {
			return "ERROR";
		}
		while (number > 0) {
			power = (int) (Math.log(number) / Math.log(2));
			int index = 31 - power;
			numberBinary[index] = true;
			number -= Math.pow(2, power);
		}
		return booleaArrToString(numberBinary);
	}
	
	public static String booleaArrToString(boolean[] numberBinary) {
		StringBuilder sb = new StringBuilder();
		for(boolean b : numberBinary) {
			if(b) sb.append("1"); 
			else sb.append("0");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(intToBinaryString(1024));
	}

}
