package com.tasks.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class LuckBalance {
	
	// Complete the luckBalance function below.
	static int luckBalance(int k, int[][] contests) {
		int maxLuck = 0;
		ArrayList<Integer> importantContests = new ArrayList<>();
		for (int i = 0; i < contests.length; i++) {
			int score = contests[i][0];
			int importance = contests[i][1];
			if (importance == 0) {
				maxLuck += score;
			} else {
				importantContests.add(score);
			}
		}
		Collections.sort(importantContests, Collections.reverseOrder());
		int kSum = 1;
		for (Iterator iterator = importantContests.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			if(kSum <= k) {
				maxLuck += integer;
			} else {
				maxLuck -= integer;
			}
			kSum++;
		}
		return maxLuck;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[][] contests = new int[n][2];

		for (int i = 0; i < n; i++) {
			String[] contestsRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 2; j++) {
				int contestsItem = Integer.parseInt(contestsRowItems[j]);
				contests[i][j] = contestsItem;
			}
		}

		int result = luckBalance(k, contests);

		System.out.println(String.valueOf(result));

		scanner.close();
	}
}
