package com.tasks.dp;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Implement the "paint fill" function that one might see on many image editing
 * programs. That is, given a screen (represented by a two-dimensional array of
 * colors), a point, and a new color, fill in the surrounding area until the
 * color changes from the original color.
 * 
 * @author Polina Koleva
 *
 */
public class PaintFill {
	public static int[][] paintFill(int[][] image, int rowPoint, int colPoint, int newColor) {
		int oldColor = image[rowPoint][colPoint];
		paintFill(image, rowPoint, colPoint, oldColor, newColor);
		return image;
	}

	public static void paintFill(int[][] matrix, int row, int col, int oldColor, int newColor) {
		// base case
		// out of matrix
		if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length)
			return;
		// cell with different from oldColour
		if (matrix[row][col] != oldColor)
			return;
		// change the colour of the current cell
		matrix[row][col] = newColor;
		// explore other cells around
		// vertically and horizontally
		paintFill(matrix, row, col + 1, oldColor, newColor);
		paintFill(matrix, row, col - 1, oldColor, newColor);
		paintFill(matrix, row + 1, col, oldColor, newColor);
		paintFill(matrix, row - 1, col, oldColor, newColor);
		// diagonally
		paintFill(matrix, row - 1, col + 1, oldColor, newColor);
		paintFill(matrix, row - 1, col - 1, oldColor, newColor);
		paintFill(matrix, row + 1, col + 1, oldColor, newColor);
		paintFill(matrix, row + 1, col - 1, oldColor, newColor);
	}

	public static void paintFillBFS(int[][] matrix, Point p, int oldColor, int newColor) {
		boolean[][] visiting = new boolean[matrix.length][matrix[0].length];
		LinkedList<Point> toVisit = new LinkedList<>();
		toVisit.add(p);
		while (!toVisit.isEmpty()) {
			Point current = toVisit.removeFirst();
			ArrayList<Point> children = getNeighbours(current);
			for (int i = 0; i < children.size(); i++) {
				Point child = children.get(i);
				if (child.row < 0 || child.row >= matrix.length || child.col < 0 || child.col >= matrix[0].length) {
					continue;
				}
				if (!visiting[child.row][child.col]) {
					visiting[child.row][child.col] = true;
					if (matrix[child.row][child.col] == oldColor) {
						// change the color and add its children
						matrix[child.row][child.col] = newColor;
						toVisit.add(child);
					}
				}
			}
		}
	}

	public static ArrayList<Point> getNeighbours(Point p) {
		ArrayList<Point> neighbours = new ArrayList<>();
		neighbours.add(new Point(p.row + 1, p.col));
		neighbours.add(new Point(p.row, p.col - 1));
		neighbours.add(new Point(p.row + 1, p.col));
		neighbours.add(new Point(p.row - 1, p.col));
		// diagonally
		neighbours.add(new Point(p.row - 1, p.col + 1));
		neighbours.add(new Point(p.row - 1, p.col - 1));
		neighbours.add(new Point(p.row + 1, p.col + 1));
		neighbours.add(new Point(p.row + 1, p.col - 1));
		return neighbours;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[4][4];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = i + j;
			}
		}
		matrix[1][2] = 4;
		matrix[2][1] = 4;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		paintFill(matrix, 2, 2, 9);
		// paintFillBFS(matrix, new Point(2, 2), 4, 9);
		// zeroMatrixNoAddSpace(matrix);
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}
}

class Point {
	int row;
	int col;

	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}