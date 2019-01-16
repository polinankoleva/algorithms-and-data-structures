package com.tasks;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * The Stock Exchange Matching Algorithm works in the following way:
 * 
 * It is parametrized by pairs of parameters for (s, p). Each s is unique and if a
 * customer wants to buy m shares, the algorithm will first find the largest s such
 * that s <= m and then find a price p for one share, i.e. a price coupled with the
 * chosen .
 * 
 * There are k customers, and the i-th of them has requested to buy exactly q shares.
 * For each such request print the price of one share, that the algorithm will
 * give.
 * 
 * @author polina
 *
 */
public class StockExchangeMatching {
	/*
	 * Complete the 'computePrices' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER_ARRAY s 2. INTEGER_ARRAY p 3. INTEGER_ARRAY
	 * q
	 */

	public static List<Integer> computePrices(List<Integer> s, List<Integer> p, List<Integer> q) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		// pairs of (s, p)
		HashMap<Integer, Integer> pairs = new HashMap<Integer, Integer>();
		for (int i = 0; i < s.size(); i++) {
			pairs.put(s.get(i), p.get(i));
		}
		Collections.sort(s);
		int[] primArray = s.stream().mapToInt(i -> i).toArray();
		for (int i = 0; i < q.size(); i++) {
			int number = bs(primArray, 0, s.size() - 1, q.get(i));
			results.add(pairs.get(number));
		}
		return results;

	}

	/**
	 * Do a binary search for a particular number. Time complexity O(log n)
	 * 
	 * @param array
	 * @param start  the index from which it has to start searching
	 * @param end    the index from which it has to end searching.
	 * @param number number it is searched for
	 * @return return either the found number or the closest smaller number existing
	 *         in the array
	 */
	public static int bs(int[] array, int start, int end, int number) {
		if (start == end) {
			return array[start];
		}
		int middle = (start + end) / 2;
		if (number < array[middle]) {
			if (number > array[middle - 1]) {
				return array[middle - 1];
			} else {
				return bs(array, start, middle - 1, number);
			}
		} else if (number > array[middle]) {
			if (number < array[middle + 1]) {
				return array[middle];
			} else {
				return bs(array, middle + 1, end, number);
			}
		} else {
			return array[middle];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		List<Integer> p = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		int k = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> q = IntStream.range(0, k).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		List<Integer> res = computePrices(s, p, q);

		System.out.println(res.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
	}

}
