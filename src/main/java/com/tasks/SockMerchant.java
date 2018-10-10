package com.tasks;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * John works at a clothing store. He has a large pile of socks that he must
 * pair by color for sale. Given an array of integers representing the color of
 * each sock, determine how many pairs of socks with matching colors there are.
 * 
 * For example, there are socks with colors . There is one pair of color and one
 * of color . There are three odd socks left, one of each color. The number of
 * pairs is .
 * 
 * @author Polina Koleva
 *
 */
public class SockMerchant {

	// n: the number of socks in the pile 1 <= n <= 100
    // ar: the colors of each sock 
	static int sockMerchant(int n, int[] ar) {
		int numberOfPairs = 0;
		// set solution 
		HashSet<Integer> socks = new HashSet<Integer>();
		for (int i = 0; i < ar.length; i++) {
			int color = ar[i];
			if (socks.contains(color)) {
				numberOfPairs++;
				socks.remove(color);
			} else {
				socks.add(color);
			}
		}
		// map solution
//		HashMap<Integer, Boolean> pairs = new HashMap<Integer, Boolean>();
//		for (int i = 0; i < ar.length; i++) {
//			int color = ar[i];
//			if(pairs.containsKey(color)) {
//				boolean hasSock = pairs.get(color);
//				if(hasSock) {
//					numberOfPairs++;
//					pairs.put(color, false);
//				} else {
//					pairs.put(color, true);
//				}
//			} else {
//				pairs.put(color, true);
//			}
//		}
		return numberOfPairs;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] ar = new int[n];

		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		int result = sockMerchant(n, ar);

		System.out.println(String.valueOf(result));
		scanner.close();
	}
}
