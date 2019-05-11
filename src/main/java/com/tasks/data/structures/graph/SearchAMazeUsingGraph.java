package com.tasks.data.structures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.tasks.data.structures.graph.GCell.GState;

public class SearchAMazeUsingGraph {

	public List<GCell> findPath(boolean[][] mazeArr, int startRow, int startCol, int endRow, int endCol) {
		ArrayList<GCell> path = new ArrayList<GCell>();
		// validation
		if (startRow < 0 || startRow >= mazeArr.length || endRow < 0 || endRow >= mazeArr.length || endRow < startRow) {
			return null;
		}
		if (startCol < 0 || endCol < 0 || startCol >= mazeArr[0].length || endCol >= mazeArr[0].length
				|| startCol > endCol) {
			return null;
		}
		Maze maze = buildMaze(mazeArr);
		GCell start = getCell(startRow, startCol, maze.cells);
		if (start == null) {
			// invalid start
			return null;
		}
		GCell end = getCell(endRow, endCol, maze.cells);
		if (end == null) {
			// invalid end
			return null;
		}
		return findPath(maze, start, end, path);

	}

	public List<GCell> findPath(Maze g, GCell current, GCell end, List<GCell> path) {
		// apply DFS
		current.state = GState.VISITED;
		path.add(current);
		if(current == end) {
			return path;
		}
		for(GCell child : current.adjacentCells) {
			if(child.state == GState.UNVISITED) {
				List<GCell> currentPath = findPath(g, child, end, path);
				if(currentPath != null) {
					return path;
				}
			}
		}
		path.remove(current);
		return null;
	}

	public Maze buildMaze(boolean[][] maze) {
		HashMap<String, GCell> cells = new HashMap<>();
		// iterate over the maze
		for (int row = 0; row < maze.length; row++) {
			for (int col = 0; col < maze[0].length; col++) {
				boolean nodeValue = maze[row][col];
				// only it it is a white cell in the matrix
				if (nodeValue) {
					GCell current = createCell(row, col, cells);
					// get adjacent nodes for this node
					// get up
					if (row + 1 >= 0 && row - 1 < maze.length && maze[row - 1][col]) {
						GCell up = createCell(row - 1, col, cells);
						current.adjacentCells.add(up);
					}
					// get down
					if (row + 1 >= 0 && row + 1 < maze.length && maze[row + 1][col]) {
						GCell down = createCell(row + 1, col, cells);
						current.adjacentCells.add(down);
					}
					// get right
					if (col + 1 >= 0 && col + 1 < maze[0].length && maze[row][col + 1]) {
						GCell right = createCell(row, col + 1, cells);
						current.adjacentCells.add(right);
					}
					// get left
					if (col - 1 >= 0 && col - 1 < maze[0].length && maze[row][col - 1]) {
						GCell left = createCell(row, col - 1, cells);
						current.adjacentCells.add(left);
					}
				}
			}
		}
		Maze g = new Maze(cells);
		return g;
	}

	public GCell getCell(int row, int col, HashMap<String, GCell> cells) {
		GCell current = null;
		String cellKey = row + " " + col;
		if (cells.containsKey(cellKey)) {
			current = cells.get(cellKey);
		}
		return current;
	}

	public GCell createCell(int row, int col, HashMap<String, GCell> cells) {
		GCell current = null;
		String cellKey = row + " " + col;
		if (cells.containsKey(cellKey)) {
			current = cells.get(cellKey);
		} else {
			current = new GCell(row, col);
			cells.put(cellKey, current);
		}
		return current;
	}
}

class Maze {
	HashMap<String, GCell> cells;

	public Maze(HashMap<String, GCell> cells) {
		this.cells = cells;
	}
}

class GCell {
	int col;
	int row;
	List<GCell> adjacentCells;
	GState state;
	
	public enum GState {
		VISITED, VISITING,
		// initial state
		UNVISITED;
	}
	public GCell(int row, int col) {
		this.state = GState.UNVISITED;
		this.adjacentCells = new ArrayList<>();
		this.row = row;
		this.col = col;
	}
}
