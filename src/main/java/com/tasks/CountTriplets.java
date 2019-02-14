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
		HashMap<Long, Long> nextNumbers = new HashMap<>();
		HashMap<Long, Long> initialNumbers = new HashMap<>();
		for (int i = arr.size() - 1; i >= 0; i--) {
			Long current = arr.get(i);
			System.out.println(current);
			// add it to the nextNumbers;
			Long next = current / r;
			Long nextRemainder = current % r;
			if(nextRemainder != 0) continue;
			System.out.println("Next:" + next);
			if (nextNumbers.containsKey(next)) {
				nextNumbers.put(next, nextNumbers.get(next) + 1L);
			} else {
				nextNumbers.put(next, 1L);
			}
			System.out.println("NextNumbers " + nextNumbers);
			if (nextNumbers.containsKey(current)) {
				Long nextToNext = current / r;
				if (nextToNext >= 1) {
					System.out.println("NextToNext " + nextToNext);
					if (initialNumbers.containsKey(nextToNext)) {
						initialNumbers.put(nextToNext, initialNumbers.get(nextToNext) + 1L);
					} else {
						initialNumbers.put(nextToNext, 1L);
					}
				}
				System.out.println("Initial Numbers " + initialNumbers);
			}
			if (initialNumbers.containsKey(current)) {
				triples += initialNumbers.get(current) * nextNumbers.get(current * r);
				System.out.println("Triples:" + triples);
			}
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
