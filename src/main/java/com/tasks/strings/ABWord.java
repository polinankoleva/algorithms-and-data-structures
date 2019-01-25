package com.tasks.strings;

//form a word with A number of 'a' and B number of 'b'
// where there is no 2 consecutive a's or b's
// For example, bbabb if A=1, B=4
public class ABWord {
	
	public static String solution(int a, int b) {
		int smaller;
		int bigger;
		char smallerChar;
		char biggerChar;
		StringBuilder sb = new StringBuilder();
		if (a > b) {
			smaller = b;
			bigger = a;
			biggerChar = 'a';
			smallerChar = 'b';
		} else if (a < b) {
			smaller = a;
			bigger = b;
			biggerChar = 'b';
			smallerChar = 'a';
		} else {
			// equal number of A and B
			for (int i = 0; i < a; i++) {
				sb.append('a');
				sb.append('b');
			}
			return sb.toString();
		}
		for (int i = 0; i < bigger; i++) {
			sb.append(biggerChar);
		}
		int minPositions;
		if (bigger % 2 == 0) {
			minPositions = bigger / 2;
		} else {
			minPositions = bigger / 2 + 1;
		}
		String word = sb.toString();
		int last = 0;
		int smallerTemp = smaller;
		for (int i = 0; i < smaller; i++) {
			if (minPositions <= smallerTemp) {
				// put two b's
				word = word.substring(0, last + 2) + smallerChar + smallerChar + word.substring(last + 2);
				last += 4;
				smallerTemp-=2;
				i++;
			} else {
				// put one b
				word = word.substring(0, last + 2) + smallerChar + word.substring(last + 2);
				last += 3;
				smallerTemp--;
			}
			minPositions--;
		}
		return word;
	}

	public static void main(String[] args) {
		System.out.println(solution(1, 4));
		System.out.println(solution(3, 3));
		System.out.println(solution(5, 3));
		System.out.println(solution(7, 3));
		System.out.println(solution(7, 5));
		System.out.println(solution(7, 4));
		System.out.println(solution(1, 1));
	}
}
