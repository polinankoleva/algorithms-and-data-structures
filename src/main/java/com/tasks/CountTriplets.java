package com.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You are given an array and you need to find number of tripets of indices (i,
 * j, k) such that the elements at those indices are in geometric progression
 * for a given common ratio k and i < j < k.
 * 
 * For example, arr = [1, 4, 16, 64]. If r=4, we have [1, 4, 16] and [4, 16, 64]
 * at indices (0, 1, 2) and (1, 2, 3).
 * 
 * @author Polina
 *
 */
public class CountTriplets {

	// Complete the countTriplets function below.
	static long countTriplets(List<Long> arr, long r) {
		long triples = 0;
		HashMap<Long, Long> seenNumbers = new HashMap<>();
		HashMap<Long, Long> searchedNumbers = new HashMap<>();
		for (Long number : arr) {
			// assume this element is in the middle of the triple
			long previous = number / r;
			long next = number * r;

			// check if current number forms triples
			Long currentNumberTriples = searchedNumbers.get(number);
			if (currentNumberTriples != null) {
				triples += currentNumberTriples;
			}
			
			// count how many of the triple's first element has been seen and add the last
			// element of the triple as the searched one
			Long previousSeen = seenNumbers.get(previous);
			if (previousSeen != null) {
				Long nextTime = searchedNumbers.get(next);
				nextTime = nextTime == null ? 0 : nextTime;
				searchedNumbers.put(next, nextTime + previousSeen);
			}
			// add current number to seen numbers
			Long countCurrentNumber = seenNumbers.get(number);
			countCurrentNumber = countCurrentNumber == null ? 0 : countCurrentNumber;
			seenNumbers.put(number, countCurrentNumber + 1);
		}
		return triples;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(nr[0]);

		long r = Long.parseLong(nr[1]);

		String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Long> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			long arrItem = Long.parseLong(arrItems[i]);
			arr.add(arrItem);
		}

		long ans = countTriplets(arr, r);

		System.out.println(String.valueOf(ans));

		bufferedReader.close();
	}
}
