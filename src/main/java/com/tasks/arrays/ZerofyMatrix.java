package com.tasks.arrays;

import java.util.HashSet;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column are set to 0. CCI - Task 1.8
 * 
 * @author Polina Koleva
 *
 */
public class ZerofyMatrix {
	public static int[][] zeroMatrix(int[][] matrix) {
		int rowSize = matrix.length;
		int columnSize = matrix[0].length;
		HashSet<Integer> columns = new HashSet<>();
		HashSet<Integer> rows = new HashSet<>();
		// find rows/columns that has to be zerofied
		for (int row = 0; row < rowSize; row++) {
			for (int col = 0; col < columnSize; col++) {
				if (matrix[row][col] == 0) {
					columns.add(col);
					rows.add(row);
				}
			}
		}

		// zerofied all rows
		rows.forEach(r -> {
			for (int col = 0; col < columnSize; col++) {
				matrix[r][col] = 0;
			}
		});

		// zerofied all columns
		HashSet<Integer> rowsToZerofied = new HashSet<Integer>();
		for (int i = 0; i < rowSize; i++) {
			if (!rows.contains(i))
				rowsToZerofied.add(i);
		}
		columns.forEach(c -> {
			rowsToZerofied.forEach(r -> {
				matrix[r][c] = 0;
			});
		});
		return matrix;
	}

	public static int[][] zeroMatrixNoAddSpace(int[][] matrix) {
		int rowSize = matrix.length;
		int columnSize = matrix[0].length;
		// use the 0 row and the 0 column as an index which row/column need to be
		// zerofied
		for (int row = 0; row < rowSize; row++) {
			for (int col = 0; col < columnSize; col++) {
				if (matrix[row][col] == 0) {
					// mark the column to be zerofied
					matrix[0][col] = 0;
					// mark the row to be zerofied
					matrix[row][0] = 0;
				}
			}
		}
		// zerofy columns, leave column 0 for later because it stored which rows to
		// zerofied
		for (int col = 1; col < columnSize; col++) {
			if (matrix[0][col] == 0) {
				// zerofy column col
				for (int row = 0; row < rowSize; row++) {
					matrix[row][col] = 0;
				}
			}
		}
		// zerofy row, leave column 0 for later because it stored which rows to zerofied
		for (int row = 1; row < rowSize; row++) {
			if (matrix[row][0] == 0) {
				// zerofy row col
				for (int col = 0; col < columnSize; col++) {
					matrix[row][col] = 0;
				}
			}
		}

		if (matrix[0][0] == 0) {
			// zerofy the 0 row and the 0 column that were used as indexes
			for (int row = 0; row < rowSize; row++) {
				matrix[row][0] = 0;
			}
			for (int col = 0; col < columnSize; col++) {
				matrix[0][col] = 0;

			}
		}
		return matrix;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[4][4];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = i + j;
			}
		}
		matrix[2][2] = 0;
		// matrix[5][3] = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		zeroMatrixNoAddSpace(matrix);
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

}
