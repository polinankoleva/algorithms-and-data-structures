package com.tasks.bitmanipulation;

public class ParityChecking {

	// return 1 if number of 1 is odd, otherwise if #1s is even, return 0
	public static int checkParity(long number) {
		int ones = 0;
		for (int i = 0; i <= 63; i++) {
			if ((number & ((long) 1 << i)) != 0) {
				ones++;
			}
		}
		return ones % 2 == 0 ? 0 : 1;
	}

	public static void main(String[] args) {
		System.out.println(checkParity(254));
		System.out.println(checkParity(1742346774));
	}
}
