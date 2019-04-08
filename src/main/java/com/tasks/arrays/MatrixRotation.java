package com.tasks.arrays;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is
 * 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
 * place?
 * 
 * @author Polina Koleva
 *
 */
public class MatrixRotation {
	public static void rotate(int[][] matrix) {
		int matrixSize = matrix.length - 1;
		for (int row = 0; row <= matrixSize / 2; row++) {
			for (int col = row; col < matrixSize - row; col++) {
				// exchange four values
				int first = matrix[row][col];
				int second = matrix[col][matrixSize - row];
				matrix[col][matrixSize - row] = first;
				int third = matrix[matrixSize - row][matrixSize - col];
				matrix[matrixSize - row][matrixSize - col] = second;
				int fourth = matrix[matrixSize - col][row];
				matrix[matrixSize - col][row] = third;
				matrix[row][col] = fourth;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[4][4];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = i+j; 
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		rotate(matrix);
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
