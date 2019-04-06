package com.tasks.sorting;

import java.io.IOException;
import java.util.BitSet;

/**
 * You have an array with all numbers from 1 to N, where N is at most 32 000.
 * The array may have duplicate entries and you do not know what N is. With only
 * 4 KB of memory available, how would you print all duplicate elements in the
 * array?
 * 
 * @author Polina Koleva
 *
 */
public class FindDuplicates {
	public static void findDuplicates(int[] arr) {
		BitSet bitset = new BitSet(32000);
		for (int i = 0; i < arr.length; i++) {
			int number = arr[i];
			int index = number - 1;// number starts at 1, indexes in the bitset start at 0
			if (bitset.get(index)) {
				System.out.println(number);
			} else {
				bitset.set(index);
			}
		}
	}

	public static void findDuplicatesCustomBitVector(int[] arr) {
		BitVector bitset = new BitVector(32000);
		for (int i = 0; i < arr.length; i++) {
			int number = arr[i];
			int index = number - 1;// number starts at 1, indexes in the bitset start at 0
			if (bitset.get(index)) {
				System.out.println(number);
			} else {
				bitset.set(index);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		findDuplicates(new int[] {1,2,3,4,5,1,3,7,9,1,3});
		findDuplicatesCustomBitVector(new int[] {1,2,3,4,5,1,3,7,9,1,3});
	}
}

class BitVector {
	int[] bits;

	public BitVector(int capacity) {
		this.bits = new int[capacity / 32];
	}

	public boolean get(int position) {
		int index = position / 32;
		int number = bits[index];
		int innerPosition = 31 - (position % 32);
		return (number & (1 << (innerPosition))) != 0;
	}

	public void set(int position) {
		int index = position / 32;
		int number = bits[index];
		int innerPosition = 31 - (position % 32);
		int mask = (1 << (innerPosition));
		bits[index] = number | mask;
	}
}