package com.tasks.hashing;

/**
 * Given an array of integers and a number k, write a function that returns true
 * if given array can be divided into pairs such that sum of every pair is
 * divisible by k.
 * 
 * @author Polina Koleva
 */
import java.util.*;

public class ArrayPairSumDivisibility {

	public static String pairSumDivisible(int[] arr, int k) {
		HashMap<Integer, Integer> remainders = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			add(remainders, arr[i] % k);
		} 
		for(int  i = 0 ;  i< arr.length; i++) {
			int remainder = arr[i] % k;
			int remainderOccurrence = remainders.get(remainder);
			if(remainder == 0 || (k - 2*remainder == 0)) {
				if(remainderOccurrence %2 != 0) return "False";
			} else {
				if(remainders.containsKey(k - remainder)) {
					int leftRemainderOccurrence = remainders.get(k - remainder);
					if(remainderOccurrence != leftRemainderOccurrence) return "False";
				} else return "False";
			}
		}
		return "True";
	}

	public static void add(HashMap<Integer, Integer> map , int value) {
		if(map.containsKey(value)) {
			int occurrence = map.get(value);
			map.put(value, occurrence + 1);
		} else {
			map.put(value, 1);
		}
	}
	public static void main(String[] args) {
		System.out.println(pairSumDivisible(new int[] { 9, 7, 5, 3 }, 6));
		System.out.println(pairSumDivisible(new int[] { 91, 74, 66, 48 }, 10));
		System.out.println(pairSumDivisible(new int[] { 92, 75, 65, 48, 45, 35 }, 10));
		System.out.println(pairSumDivisible(new int[] { 9, 7, 5, 3 }, 1));
		System.out.println(pairSumDivisible(new int[] { 1, 1 }, 1));
		System.out.println(pairSumDivisible(new int[] { 1, 1, 1, 1 }, 4));
	}

}
