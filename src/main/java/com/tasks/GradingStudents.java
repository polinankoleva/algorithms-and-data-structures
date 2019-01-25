package com.tasks;

import java.util.Scanner;

public class GradingStudents {

	static int[] solve(int[] grades) {
		// Complete this function
		for (int i = 0; i < grades.length; i++) {
			int grade = grades[i];
			// if less than 38, no rounding
			if (grade >= 38) {
				int reminder = grade % 5;
				// rounding if < 3
				if ((5 - reminder) < 3) {
					grades[i] = grade + (5 - reminder);
				}
			}
		}
		return grades;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// number of students
		int n = in.nextInt();
		int[] grades = new int[n];
		for (int grades_i = 0; grades_i < n; grades_i++) {
			grades[grades_i] = in.nextInt();
		}
		int[] result = solve(grades);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
		}
		System.out.println("");

	}
}
