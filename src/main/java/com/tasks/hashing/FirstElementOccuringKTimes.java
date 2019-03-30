package com.tasks.hashing;

import java.util.Scanner;
import java.util.HashMap;

public class FirstElementOccuringKTimes {

	public static void occurs(int[] arr, int k) {
		HashMap<Integer, Integer> occurrences = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (occurrences.containsKey(arr[i])) {
				int currentOccurrence = occurrences.get(arr[i]);
				occurrences.put(arr[i], currentOccurrence + 1);
			} else {
				occurrences.put(arr[i], 1);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			int occurrence = occurrences.get(arr[i]);
			if (occurrence == k) {
				System.out.println(arr[i]);
				return;
			}
		}
		System.out.println(-1);
	}

	public static void occurs1(int[] arr, int k) {
		if (k == 1) {
			System.out.println(arr[0]);
			return;
		}
		HashMap<Integer, Integer> occurrences = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (occurrences.containsKey(arr[i])) {
				int currentOccurrence = occurrences.get(arr[i]);
				if (currentOccurrence + 1 == k) {
					System.out.println(arr[i]);
					return;
				} else {
					occurrences.put(arr[i], currentOccurrence + 1);
				}
			} else {
				occurrences.put(arr[i], 1);
			}
		}
		System.out.println(-1);
	}

	private static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = in.nextInt();
		for (int i = 0; i < testCases; i++) {
			int arrSize = in.nextInt();
			int k = in.nextInt();
			int[] arr = new int[arrSize];
			for (int j = 0; j < arrSize; j++) {
				arr[j] = in.nextInt();
			}
			occurs(arr, k);
		}
	}
}
