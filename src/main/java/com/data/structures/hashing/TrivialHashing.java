package com.data.structures.hashing;

/**
 * Given a limited range array contains both positive and non positive numbers,
 * i.e., elements are in range from -MAX to +MAX. Task is to search if some
 * number is present in the array or not in O(1) time.
 * 
 * @author Polina Koleva
 *
 */
public class TrivialHashing {

	public static void main(String[] args) {
		int maxNumber = 1000;
		boolean[][] hash = new boolean[maxNumber+1][2];
		add(hash, 1);
		System.out.println(exists(hash, 1));
		System.out.println(exists(hash, 0));
		System.out.println(exists(hash, -1));
		add(hash, -2);
		System.out.println(exists(hash, 0));
		System.out.println(exists(hash, -2));
		System.out.println(exists(hash, 1000));
		System.out.println(exists(hash, -1000));
	}

	public static void add(boolean[][] array, int value) {
		if (value >= 0) {
			array[value][0] = true;
		} else if (value < 0) {
			array[Math.abs(value)][1] = true;
		}
	}

	private static boolean exists(boolean[][] array, int value) {
		if (value >= 0) {
			return array[value][0];
		} else {
			return array[Math.abs(value)][1];
		}
	}
}
