package com.tasks;

import java.io.IOException;
import java.util.Scanner;

//TODO finish 
/**
 * Emma is playing a new mobile game that starts with consecutively numbered
 * clouds. Some of the clouds are thunderheads and others are cumulus. She can
 * jump on any cumulus cloud having a number that is equal to the number of the
 * current cloud plus or . She must avoid the thunderheads. Determine the
 * minimum number of jumps it will take Emma to jump from her starting postion
 * to the last cloud. It is always possible to win the game.
 * 
 * @author Polina Koleva
 *
 */
public class JumpingTheClouds {

	static int jumpingOnClouds(int[] c) {
		int jumps = 0;
		for (int i = 0; i < c.length-2; i++) {
			int next = c[i+1];
			int afterNext = c[i+2];
			if(next == 1) {
				jumps++;
				i = i + 2;
			} else {
				
			}
		}
		return jumps;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] c = new int[n];

		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		int result = jumpingOnClouds(c);

		System.out.println(String.valueOf(result));
		scanner.close();
	}
}
