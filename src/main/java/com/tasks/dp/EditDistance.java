package com.tasks.dp;

public class EditDistance {

	// start from the end
	public static int editDistance(char[] s1, int lastS1, char[] s2, int lastS2) {
		if (lastS1 < 0 && lastS2 < 0) {
			return 0;
		}
		if (lastS1 < 0 && lastS2 >= 0) {
			return lastS2 + 1;
		}
		if (lastS2 < 0 && lastS1 >= 0) {
			return lastS1 + 1;
		}
		if (s1[lastS1] == s2[lastS2]) {
			return editDistance(s1, lastS1 - 1, s2, lastS2 - 1);
		} else {
			// min of insert, replace, delete
			// insert
			return 1 + Math.min(editDistance(s1, lastS1 - 1, s2, lastS2 - 1),
					Math.min(editDistance(s1, lastS1, s2, lastS2 - 1), editDistance(s1, lastS1 - 1, s2, lastS2)));
		}
	}

	public static int editDistance(String s1, String s2) {
		return editDistance(s1.toCharArray(), s1.length() - 1, s2.toCharArray(), s2.length() - 1);
	}

	public static int editDistanceMemoization(String s1, String s2) {
		return editDistanceMemoization(s1.toCharArray(), s2.toCharArray());
	}

	// start from the end
	public static int editDistanceMemoization(char[] s1, char[] s2) {
			int n = s1.length+1;
			int m = s2.length+1;
			int[][] memoization = new int[n][m];
			// initialize first row and first column with 0
			memoization[0][0] = 0;
			for(int i = 1; i < n; i++) {
				memoization[i][0] = i;
			}
			for(int i = 1; i < m; i++) {
				memoization[0][i] = i;
			}
			for (int i = 1; i < n; i++) {
				for (int j = 1; j < m; j++) {
					int min = Math.min(memoization[i][j-1], Math.min(memoization[i-1][j], memoization[i-1][j-1]));
					if(s1[i-1] == s2[j-1]) {
						memoization[i][j] = min;
					} else {
						memoization[i][j] = min + 1;
					}
				}
			}
			return memoization[n-1][m-1];
		}

	public static void main(String[] args) {
//		System.out.println(editDistance("geek", "gesek"));
//		System.out.println(editDistance("cat", "cut"));
//		System.out.println(editDistance("sunday", "saturday"));
		System.out.println(editDistanceMemoization("sunday", "saturday"));
		System.out.println(editDistanceMemoization("geek", "gesek"));
		System.out.println(editDistanceMemoization("cat", "cut"));
	}
}
