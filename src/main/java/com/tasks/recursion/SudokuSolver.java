package com.tasks.recursion;

/**
 * Implement a sudoku solver. Task 16.9, EPI book
 * 
 * @author Polina Koleva
 *
 */
public class SudokuSolver {

	public static boolean solveSudoku(int[][] partialAssignment) {
		return sudokuSolverHelper(0, 0, partialAssignment);
	}

	public static boolean sudokuSolverHelper(int row, int column, int[][] partialAssignment) {
		System.out.println(row + " " + column);
		if (row == partialAssignment.length) {
			return true;
		}
		if (column == partialAssignment[0].length) {
			// advance to the next row, all values in the previous already checked
			return sudokuSolverHelper(row + 1, 0, partialAssignment);
		}
		// empty cell continue
		if (partialAssignment[row][column] != 0) {
			return sudokuSolverHelper(row, column + 1, partialAssignment);
		}
		// assign values to the cell
		for (int i = 1; i <= 9; i++) {
			if (checkValidity(row, column, i, partialAssignment)) {
				partialAssignment[row][column] = i;
				boolean result = sudokuSolverHelper(row, column + 1, partialAssignment);
				if (result) {
					return result;
				}
				// wipe the value you have stored in row, column
				partialAssignment[row][column] = 0;
			}
		}
		return false;
	}

	public static boolean checkValidity(int row, int col, int value, int[][] partialAssignment) {
		// check row
		int[] rows = partialAssignment[row];
		for (int i = 0; i < rows.length; i++) {
			if (rows[i] == value) {
				return false;
			}
		}
		// check column
		for (int rowIndex = 0; rowIndex < partialAssignment.length; rowIndex++) {
			if (partialAssignment[rowIndex][col] == value) {
				return false;
			}
		}
		// check the square to which the points belongs
		int startRow = getIndex(row);
		int startColumn = getIndex(col);
		for (int i = startRow; i < startRow + 3; i++) {
			for (int j = startColumn; j < startColumn + 3; j++) {
				if (partialAssignment[i][j] == value) {
					return false;
				}
			}
		}
		return true;
	}

	public static int getIndex(int row) {
		while (row != 0 && row != 3 && row != 6) {
			row--;
		}
		return row;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[9][9];
		matrix[0][0] = 5;
		matrix[0][1] = 3;
		matrix[1][0] = 6;
		matrix[3][0] = 8;
		matrix[4][0] = 4;
		matrix[5][0] = 7;
		matrix[0][4] = 7;
		matrix[1][3] = 1;
		matrix[1][4] = 9;
		matrix[1][5] = 5;
		System.out.println(solveSudoku(matrix));
	}
}
