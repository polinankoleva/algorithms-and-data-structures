package com.tasks.greedy;

import java.util.Arrays;

/**
 * A database has to respond to a set of client SQL queries. The service time
 * required for each query is known in advance. For this application, the
 * queries must be processed by the database one at a time, but can be done in
 * any order. The time a query waits before its turn comes is called its waiting
 * time. Given service times for a set of queries, compute a schedule for
 * processing the queries that minimizes the total waiting time. Return the
 * minimum waiting time. For example, if the service times are (2, 5, 1, 3), if
 * we schedule in the given order, the total waiting time is0+(2)+(2+5)+(2+5+l)
 * = 17. If however, we schedule queries in order of decreasing service times,
 * the total waiting time is 0 + (5) + (5 + 3) + (5 + 3 + 2) = 23. As we will
 * see, for this example, the minimum waiting time is 10.
 * 
 * Task 18.2, EPI book
 * 
 * @author Polina Koleva
 *
 */
public class MinimumWaitingTime {

	public static int minWaitingTime(int[] serviceTimes) {
		Arrays.sort(serviceTimes);
		int totalWaitingTime = 0;
		int totalTime = 0;
		for(int i = 1; i <serviceTimes.length;i++) {
			totalTime += serviceTimes[i-1];
			totalWaitingTime += totalTime;
		}
		return totalWaitingTime;
	}
	
	public static void main(String[] args) {
		int[] serviceTimes = new int[] {2, 5, 1, 3};
		System.out.println(minWaitingTime(serviceTimes));
	}
}
