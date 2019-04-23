package com.tasks;

/**
 * Joy has won N coins. He has two option - either to chip 1 coin or to chip
 * all-in. If he wins, he wins double the number of coins he has played. If he
 * chips 1 coin and wins, he gets 2 coins back. If he chips 10 coins and wins,
 * he gets 20 coins back. If he loses, he does not get any coins back. Joy was
 * super lucky and won all the rounds at this day. Having a limit K of possible
 * rounds he could play all-in, what is the minimum number of rounds he could
 * have played to win N coins?
 * 
 * @author Polina Koleva
 *
 */
public class MinimumRoundsInCasino {
	public static int solution(int N, int K) {
		if (N == 2)
			return 1;
		if (K <= 0)
			return N - 1;
		if (K > 0 && N % 2 == 0) {
			return Math.min(solution(N - 1, K), solution(N / 2, K - 1)) + 1;
		} else {
			return solution(N - 1, K) + 1;
		}
	}

	// greedy solution
	public static int solutionDP(int N, int K) {
		if (K <= 0)
			return N - 1;
		int round = 1;
		while (N > 2) {
			if (K < 0)
				round += N - 1;
			if (N % 2 == 0) {
				K--;
				N = N / 2;
				round++;
			} else {
				N = N - 1;
				round++;
			}
		}
		return round;
	}

	public static int solutionGreedy(int N, int K) {
		int rounds = 0;
		while (N > 2 && K > 0) {
			System.out.println(N);
			if(N%2 == 0) {
				K--;
				N = N/2;
			} else {
				N--;
			}
			rounds++;
		}
		System.out.println("R:" +rounds);
		System.out.println("N:" +N);
		rounds += (N-1);
		return rounds;
	}

	public static void main(String[] args) {
//		System.out.println(solutionDP(2147483647, 1000));
//		System.out.println(solutionGreedy(2147483647, 1000));
		System.out.println(solutionDP(18, 2));
		System.out.println(solutionGreedy(18, 2));
//		System.out.println(solutionDP(10, 2));
//		System.out.println(solutionGreedy(10, 2));
	}
}
