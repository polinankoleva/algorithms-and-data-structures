package com.tasks.dp;

public class ScoreCombination {

	public static int scoreCombinationsRecursively(int n) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		return scoreCombinationsRecursively(n - 2) + scoreCombinationsRecursively(n - 3)
				+ scoreCombinationsRecursively(n - 7);
	}

	public static int scoreCombinationsDP(int n, int[] cache) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		int sum = 0;
		// compute for 2
		if (n - 2 - 1 > 0 && cache[n - 2 - 1] != 0) {
			sum += cache[n - 2 - 1];
		} else {
			sum += scoreCombinationsDP(n - 2, cache);
		}
		// compute for 3
		if (n - 3 - 1 > 0 && cache[n - 3 - 1] != 0) {
			sum += cache[n - 3 - 1];
		} else {
			sum += scoreCombinationsDP(n - 3, cache);
		}
		// compute for 7
		if (n - 7 - 1 > 0 && cache[n - 7 - 1] != 0) {
			sum += cache[n - 7 - 1];
		} else {
			sum += scoreCombinationsDP(n - 7, cache);
		}
		cache[n - 1] = sum;
		return sum;
	}
	
	public static void main(String[] args) {
		int[] cache = new int[12];
		System.out.println(scoreCombinationsDP(12, cache));
		System.out.println(scoreCombinationsRecursively(12));
	}
}
