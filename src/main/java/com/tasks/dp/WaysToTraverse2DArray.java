package com.tasks.dp;
/**
 * 
 * @author Polina Koleva
 *
 */
public class WaysToTraverse2DArray {

	public static int waysRecursive(int row, int col, int rows, int columns) {
		if (row > rows - 1 || row < 0) {
			return 0;
		}
		if (col > columns - 1 || col < 0) {
			return 0;
		}
		if (row == rows - 1 && col == columns - 1) {
			return 1;
		}
		// go right or down
		return waysRecursive(row + 1, col, rows, columns) + waysRecursive(row, col + 1, rows, columns);
	}

	public static int waysDP(int rows, int columns) {
		int[][] ways = new int[rows][columns];
		// initialise first row
		for (int col = 0; col < columns; col++) {
			ways[0][col] = 1;
		}
		// initialize first column
		for (int row = 0; row < rows; row++) {
			ways[row][0] = 1;
		}
		// fill the left
		for (int col = 1; col < columns; col++) {
			for (int row = 1; row < rows; row++) {
				ways[row][col] = ways[row - 1][col] + ways[row][col - 1];
			}
		}
		return ways[rows - 1][columns - 1];
	}

	public static void main(String[] args) {
		System.out.println(waysRecursive(0, 0, 5, 6));
		System.out.println(waysDP(5, 6));
	}
}
