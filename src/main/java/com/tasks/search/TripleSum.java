package com.tasks.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Given 3 arrays of different sizes,a,b and c, find the number of distinct
 * triplets (p,q,r) where p is an element of a, q of b, r of c satisfying the
 * criteria: p<=q and q>=r.
 * 
 * @author Polina Koleva
 *
 */
public class TripleSum {
	// Complete the triplets function below.
	static long triplets(int[] a, int[] b, int[] c) {
		long triples = 0;
		HashSet<Integer> hashSetB = new HashSet<>();
		for (int i = 0; i < b.length; i++) {
			hashSetB.add(b[i]);
		}
		//remove duplicates from a and b
		Set<Integer> setA = new HashSet<Integer>();
		for(int i = 0; i < a.length; i++){
			setA.add(a[i]);
		}
		Set<Integer> setC = new HashSet<Integer>();
		for(int i = 0; i < c.length; i++){
			setC.add(c[i]);
		}
		Integer[] aa = (Integer[]) setA.toArray(new Integer[setA.size()]);
		Integer[] cc = (Integer[]) setC.toArray(new Integer[setC.size()]);
		Arrays.sort(aa);
		Arrays.sort(cc);
		for (Iterator iterator = hashSetB.iterator(); iterator.hasNext();) {
			Integer currentQ = (Integer) iterator.next();
			// find all elements smaller than currentQ in a
			int smaller = index(aa, currentQ);
			// find all elements bigger than currentQ in b
			int bigger = index(cc, currentQ);
			triples += (long) smaller * bigger;
		}
		return triples;
	}

	public static int index(Integer[] arr, int number) {
		int index = Arrays.binarySearch(arr, number);
		if (index >= 0) {
			return index + 1;
		} else {
			return Math.abs(index) - 1;
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String[] lenaLenbLenc = scanner.nextLine().split(" ");

		int lena = Integer.parseInt(lenaLenbLenc[0]);

		int lenb = Integer.parseInt(lenaLenbLenc[1]);

		int lenc = Integer.parseInt(lenaLenbLenc[2]);

		int[] arra = new int[lena];

		String[] arraItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < lena; i++) {
			int arraItem = Integer.parseInt(arraItems[i]);
			arra[i] = arraItem;
		}

		int[] arrb = new int[lenb];

		String[] arrbItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < lenb; i++) {
			int arrbItem = Integer.parseInt(arrbItems[i]);
			arrb[i] = arrbItem;
		}

		int[] arrc = new int[lenc];

		String[] arrcItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < lenc; i++) {
			int arrcItem = Integer.parseInt(arrcItems[i]);
			arrc[i] = arrcItem;
		}

		long ans = triplets(arra, arrb, arrc);

		System.out.println(String.valueOf(ans));

		scanner.close();
	}
}
