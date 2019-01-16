package com.tasks.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyFlorist {
	// Complete the getMinimumCost function below.
	// k - number of friends, c - price of flowers
	static int getMinimumCost(int k, int[] c) {
		Arrays.sort(c);
		int cost = 0;
		for (int i = c.length - 1; i >= 0; i--) {
			int currentFlowerPrice = c[i];
			cost += (((Math.abs(i-c.length+1))/ k) + 1) * currentFlowerPrice;
		}
		return cost;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] c = new int[n];

		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		int minimumCost = getMinimumCost(k, c);

		System.out.println(String.valueOf(minimumCost));
		scanner.close();
	}
}
