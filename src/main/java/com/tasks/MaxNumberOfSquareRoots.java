package com.tasks;

/**
 * Calculate maximum number of perfect square roots for a number in the interval
 * [A, B]. For example, if A = 10 and B = 20, the maximum number of number of
 * square roots is 2. sqrt(16) = 4, sqrt(4) = 2.
 * 
 * @author Polina Koleva
 *
 */
public class MaxNumberOfSquareRoots {

	public static int solution(int A, int B) {
		int maxSquareRoots = 0;
		for (int i = A; i <= B; i++) {
			// System.out.println(i);
			int currentSRCount = 0;
			int currentNumber = i;
			while (true) {
				double currentSR = Math.sqrt(currentNumber);
				// if number is an integer
				if (currentSR % 1 == 0) {
					currentNumber = (int) currentSR;
					currentSRCount++;
				} else {
					break;
				}
			}
			if (currentSRCount > maxSquareRoots) {
				maxSquareRoots = currentSRCount;
			}
		}
		return maxSquareRoots;
	}

	public static void main(String[] args) {
		System.out.println(solution(6000, 7000));
	}

}
