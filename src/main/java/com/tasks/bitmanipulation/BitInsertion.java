package com.tasks.bitmanipulation;

/**
 * You have two 32-bit numbers, n and m, and two bit positions, i and j. Write a
 * method that insert m into n such that m starts at bit j and ends at bit i.
 * You can assume that the bits j through i have enough space to fit all of M.
 * 
 * Task 5.1 Cracking the coding interview.
 * 
 * @author Polina Koleva
 *
 */
public class BitInsertion {
	public static int insert(int n, int m, int j, int i) {
		int numberOfOnes = j - i + 1;
		int y = calculateByBinary(numberOfOnes);
		int mask = (~(y << i));
		int n_cleared = n & mask;
		int m_shifted = (m << i);
		return n_cleared | m_shifted;
	}

	public static int calculateByBinary(int numberOfOnes) {
		int result = 0;
		for (int i = 0; i < numberOfOnes; i++) {
			result += Math.pow(2, i);
		}
		return result;
	}

	public static int udpateBits(int n, int m, int j, int i) {
		int allOnes = ~0;
		int left = allOnes << (j + 1);
		int right = ((1 << i) - 1);
		int mask = left | right;
		int n_cleared = n & mask;
		int m_shifted = m << i;
		return n_cleared | m_shifted;
	}

	public static void main(String[] args) {
		System.out.println(udpateBits(1024, 19, 6, 2));
		System.out.println(insert(1024, 19, 6, 2));

	}

}
