package com.hackerrank;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Consider an array of numeric strings, , where each string is a positive
 * number with anywhere from to digits. Sort the array's elements in
 * non-decreasing (i.e., ascending) order of their real-world integer values and
 * print each element of the sorted array on a new line.
 * 
 * @author Polina Koleva
 *
 */
public class BigSorting {

	static String[] bigSorting(String[] arr) {
		List<String> sortedList = Arrays.asList(arr);
		sortedList.sort(new Comparator<String>() {

			public int compare(String str1, String str2) {
				if (str1.length() == str2.length()) {
					return str1.compareTo(str2);
				} else {
					return str1.length() - str2.length();
				}
			}
		});

		return (String[]) sortedList.toArray();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] arr = new String[n];
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = in.next();
		}
		String[] result = bigSorting(arr);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
		}
		System.out.println("");

		in.close();
	}
}
