package com.tasks;

import java.util.Iterator;
import java.util.List;

//TODO continue 
public class RemoveObstacles {
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
		int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {
			Math.min(4, 5);
			// convert lot to matrix
			int[][] lotMatrix = new int[numRows + 1][numColumns + 1];
			Iterator<List<Integer>> it = lot.iterator();
			int rowIndex = 0;
			while (it.hasNext()) {
				List<Integer> row = it.next();
				for (int i = 0; i < numColumns; i++) {
					lotMatrix[rowIndex][i] = row.get(i);
				}
				rowIndex++;
			}
			System.out.println(lotMatrix);
			return rowIndex;
		}
		
		// METHOD SIGNATURE ENDS
		public void getDistance(int[][] matrix, int row, int column, int value) {
			if (row < 0 || row >= matrix.length) {
				return;
			}
			if (column < 0 || column >= matrix[0].length) {
				return;
			}
			if (matrix[row][column] == 9) {
				return;
			}
			if (matrix[row][column] == 0) {
				return;
			}
//			// up column -1, row
//			// down column+1, row
//			return Math.min(getDistance(matrix, row + 1, column, value), Math.min(
//					getDistance(matrix, row - 1, column, value),
//					Math.min(getDistance(matrix, row, column - 1, value), getDistance(matrix, row, column + 1, value))));
		}

}
