package com.tasks;

/**
 * Write an efficient function that takes stock_prices and returns the best
 * profit I could have made from one purchase and one sale of one share of Apple
 * stock yesterday.
 * 
 * @author Polina Koleva
 *
 */
public class BestStockProfit {
	public static int bestStockProfit(int[] arr) {
		if(arr.length <= 1) throw new IllegalArgumentException("Needed two values for having a profit.");
		int bestProfit = Integer.MIN_VALUE;
		int smallestPrice = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int currentPrice = arr[i];
			int currentBestProfit = currentPrice - smallestPrice;
			if (currentBestProfit > bestProfit) {
				bestProfit = currentBestProfit;
			}
			if (currentPrice < smallestPrice) {
				smallestPrice = currentPrice;
			}
		}
		return bestProfit;
	}

	public static void main(String[] args) {
		System.out.println(bestStockProfit(new int[] {10, 7, 5, 8, 11, 9}));
		System.out.println(bestStockProfit(new int[] {10, 7, 5, 4, 1}));
		System.out.println(bestStockProfit(new int[] {10, 15, 14, 13, 1, 2}));
		System.out.println(bestStockProfit(new int[] {10, 10, 10, 10, 10, 10}));
	}
}
