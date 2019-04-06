package com.tasks.bitmanipulation;

import java.util.Set;

/**
 * You have an integer and you can flip exactly one bit from a 0 to 1. Write a
 * code to find the length of the longest sequence of 1s you could create.
 * 
 * @author Polina Koleva
 *
 */
public class FlipBitToWin {
	public static boolean[] intToBinary(int number) {
		boolean[] numberBinary = new boolean[32];
		int power = (int) (Math.log(number) / Math.log(2));
		if (power > 31) {
			return numberBinary;
		}
		while (number > 0) {
			power = (int) (Math.log(number) / Math.log(2));
			int index = 31 - power;
			numberBinary[index] = true;
			number -= Math.pow(2, power);
		}
		return numberBinary;
	}

	public static int flipBitToWin(boolean[] bits) {
		boolean zeroEncountered = false;
		int lengthOf1sLastSequnce = 0;
		int lengthSequence = 0;
		int maxSequence = 0;
		for (int i = 0; i < bits.length; i++) {
			if (bits[i] == true) {
				//inSequence = true;
				lengthSequence++;
				if (zeroEncountered)
					lengthOf1sLastSequnce++;
			} else {
				if (!zeroEncountered) {
					zeroEncountered = true;
					lengthSequence++;
				} else {
					zeroEncountered = false;
					if (lengthSequence > maxSequence) {
						maxSequence = lengthSequence;
					}
					lengthSequence = lengthOf1sLastSequnce;
					lengthOf1sLastSequnce = 0;
				}
			}
			System.out.println(lengthSequence);
		}
		return maxSequence;
	}
	
	public Set<char[]> permitations(char[] input){
		//if(input.length == 1) return 
		return null;
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
		System.out.println(booleaArrToString(intToBinary(67)));
		System.out.println(flipBitToWin(intToBinary(67)));
	}
}
