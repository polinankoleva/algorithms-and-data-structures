package com.tasks.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Imagine a robot sitting on the upper left corner of grid with r rows and c
 * columns. The robot can only move in two directions, right and down, but
 * certain cells are "off-limit" such that the robot cannot step on them.
 * 
 * @author Polina Koleva
 *
 */
public class RobotInAGrid {
	public static List<Integer> findPath(int[][] arr) {
		ArrayList<Integer> path = new ArrayList<>();
		boolean pathFound = findPath(arr, arr.length - 1, arr[0].length - 1, path);
		if (pathFound) {
			return path;
		} else {
			return null;
		}
	}

	public static boolean findPath(int[][] arr, int startRow, int startColumn, List<Integer> path) {
		if (startRow < 0 || startColumn < 0) {
			return false;
		}
		// off limits
		if (arr[startRow][startColumn] == -1)
			return false;
		boolean atOrigin = (startRow == 0 && startColumn == 0);
		if (atOrigin || findPath(arr, startRow, startColumn - 1, path)
				|| findPath(arr, startRow - 1, startColumn, path)) {
			path.add(arr[startRow][startColumn]);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] a = new int[5][3];
		a[0][1] = 1;
		a[1][1] = 1;
		a[1][0] = -1;
		a[1][2] = -1;
		a[2][1] = 3;
		a[3][1] = 11;
		a[3][2] = 16;
		a[4][2] = 19;
		a[4][0] = 9;
		System.out.println(a);
		// rows
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a[0].length; col++) {
				System.out.print(a[row][col] + " ");
			}
			System.out.println();
		}
		ArrayList<Integer> path = (ArrayList<Integer>) findPath(a);
		if (path == null) {
			System.out.println("No path found!");
		} else {
			path.forEach(value -> {
				System.out.print(value + " ");
			});
		}
	}
}

class StopWrapper {
	boolean pathFound;

	public StopWrapper() {
		this.pathFound = false;
	}

	public boolean isPathFound() {
		return pathFound;
	}
}