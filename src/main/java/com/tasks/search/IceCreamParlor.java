package com.tasks.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IceCreamParlor {

	// Complete the whatFlavors function below.
	static void whatFlavors(int[] cost, int money) {
		// price, indexes of this price in the array
		Map<Integer, List<Integer>> prices = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < cost.length; i++) {
			if (prices.containsKey(cost[i])) {
				prices.get(cost[i]).add(i);
			} else {
				ArrayList<Integer> indexes = new ArrayList<>();
				indexes.add(i);
				prices.put(cost[i], indexes);
			}
		}
		for (int i = 0; i < cost.length; i++) {
			int otherPair = money - cost[i];
			if (prices.containsKey(otherPair)) {
				if (prices.get(otherPair).size() == 1) {
					if (prices.get(otherPair).get(0) != i) {
						System.out.println((i + 1) + " " + (prices.get(otherPair).get(0) + 1));
						return;
					}
				} else {
					if (prices.get(otherPair).contains(i)) {
						for (Iterator iterator = prices.get(otherPair).iterator(); iterator.hasNext();) {
							Integer type = (Integer) iterator.next();
							if (type != i) {
								System.out.println((i + 1) + " " + (type + 1));
								return;
							}
						}
					} else {
						// just print the first possible index
						System.out.println((i + 1) + " " + (prices.get(otherPair).get(0) + 1));
						return;
					}
				}
			}
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int money = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] cost = new int[n];

			String[] costItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int costItem = Integer.parseInt(costItems[i]);
				cost[i] = costItem;
			}

			whatFlavors(cost, money);
		}

		scanner.close();
	}
}
