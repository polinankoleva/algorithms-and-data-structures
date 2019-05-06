package com.tasks.data.structures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.tasks.data.structures.graph.Cell.State;

public class SearchAMazeUsingGraph {

	public List<Cell> findPath(boolean[][] mazeArr, int startRow, int startCol, int endRow, int endCol) {
		ArrayList<Cell> path = new ArrayList<Cell>();
		// validation
		if (startRow < 0 || startRow >= mazeArr.length || endRow < 0 || endRow >= mazeArr.length || endRow < startRow) {
			return null;
		}
		if (startCol < 0 || endCol < 0 || startCol >= mazeArr[0].length || endCol >= mazeArr[0].length
				|| startCol > endCol) {
			return null;
		}
		Maze maze = buildMaze(mazeArr);
		Cell start = getCell(startRow, startCol, maze.cells);
		if (start == null) {
			// invalid start
			return null;
		}
		Cell end = getCell(endRow, endCol, maze.cells);
		if (end == null) {
			// invalid end
			return null;
		}
		return findPath(maze, start, end, path);

	}

	public List<Cell> findPath(Maze g, Cell current, Cell end, List<Cell> path) {
		// apply DFS
		current.state = State.VISITED;
		path.add(current);
		if(current == end) {
			return path;
		}
		for(Cell child : current.adjacentCells) {
			if(child.state == State.UNVISITED) {
				List<Cell> currentPath = findPath(g, child, end, path);
				if(currentPath != null) {
					return path;
				}
			}
		}
		path.remove(current);
		return null;
	}

	public Maze buildMaze(boolean[][] maze) {
		HashMap<String, Cell> cells = new HashMap<>();
		// iterate over the maze
		for (int row = 0; row < maze.length; row++) {
			for (int col = 0; col < maze[0].length; col++) {
				boolean nodeValue = maze[row][col];
				// only it it is a white cell in the matrix
				if (nodeValue) {
					Cell current = createCell(row, col, cells);
					// get adjacent nodes for this node
					// get up
					if (row + 1 >= 0 && row - 1 < maze.length && maze[row - 1][col]) {
						Cell up = createCell(row - 1, col, cells);
						current.adjacentCells.add(up);
					}
					// get down
					if (row + 1 >= 0 && row + 1 < maze.length && maze[row + 1][col]) {
						Cell down = createCell(row + 1, col, cells);
						current.adjacentCells.add(down);
					}
					// get right
					if (col + 1 >= 0 && col + 1 < maze[0].length && maze[row][col + 1]) {
						Cell right = createCell(row, col + 1, cells);
						current.adjacentCells.add(right);
					}
					// get left
					if (col - 1 >= 0 && col - 1 < maze[0].length && maze[row][col - 1]) {
						Cell left = createCell(row, col - 1, cells);
						current.adjacentCells.add(left);
					}
				}
			}
		}
		Maze g = new Maze(cells);
		return g;
	}

	public Cell getCell(int row, int col, HashMap<String, Cell> cells) {
		Cell current = null;
		String cellKey = row + " " + col;
		if (cells.containsKey(cellKey)) {
			current = cells.get(cellKey);
		}
		return current;
	}

	public Cell createCell(int row, int col, HashMap<String, Cell> cells) {
		Cell current = null;
		String cellKey = row + " " + col;
		if (cells.containsKey(cellKey)) {
			current = cells.get(cellKey);
		} else {
			current = new Cell(row, col);
			cells.put(cellKey, current);
		}
		return current;
	}
}

class Maze {
	HashMap<String, Cell> cells;

	public Maze(HashMap<String, Cell> cells) {
		this.cells = cells;
	}
}

class Cell {
	int col;
	int row;
	List<Cell> adjacentCells;
	State state;
	
	public enum State {
		VISITED, VISITING,
		// initial state
		UNVISITED;
	}
	public Cell(int row, int col) {
		this.state = State.UNVISITED;
		this.adjacentCells = new ArrayList<>();
		this.row = row;
		this.col = col;
	}
}
