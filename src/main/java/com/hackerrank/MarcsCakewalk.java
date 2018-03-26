package com.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class MarcsCakewalk {
	static long marcsCakewalk(int[] calorie) {
		Arrays.sort(calorie);
		int result = 0;
		for (int i = calorie.length - 1; i >= 0; i--) {
			result += calorie[i] * Math.pow(2 , Math.abs(i - (calorie.length - 1)));
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] calorie = new int[n];
		for (int calorie_i = 0; calorie_i < n; calorie_i++) {
			calorie[calorie_i] = in.nextInt();
		}
		long result = marcsCakewalk(calorie);
		System.out.println(result);
		in.close();
	}
}
