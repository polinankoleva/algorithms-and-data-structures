package com.tasks.dp;

/**
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5
 * cents) and pennies (1 cent), write code to calculate the number of ways of
 * representing n cents.
 * 
 * @author Polina Koleva
 *
 */
public class Coins {
	public static int coins(int n) {
		if (n == 0)
			return 1;
		int oneCentWays = 0;
		int fiveCentsWays = 0;
		int tenCentsWays = 0;
		int twentyFiveCentsWays = 0;
		if (n >= 1) {
			oneCentWays = coins(n - 1);
		}
		if (n >= 5) {
			fiveCentsWays = coins(n - 5);
		}
		if (n >= 10) {
			tenCentsWays = coins(n - 10);
		}
		if (n >= 25) {
			twentyFiveCentsWays = coins(n - 25);
		}
		return oneCentWays + fiveCentsWays + tenCentsWays + twentyFiveCentsWays;
	}

	public static int coinsSimpler(int n) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		return coinsSimpler(n - 1) + coins(n - 5) + coins(n - 10) + coins(n - 25);
	}

	public static void main(String[] args) {
		System.out.println(coins(1));
		System.out.println(coinsSimpler(1));
		System.out.println(coins(10));
		System.out.println(coinsSimpler(10));
	}
}
