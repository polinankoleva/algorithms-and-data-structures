package com.tasks.data.structures.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchAMazeRecursive {

	public List<Cell> findPath(boolean[][] maze, Cell current, Cell end, List<Cell> path){
		if(current == end) {
			return path;
		}
		// get up 
		Cell up = getUp(maze, current);
		if(up != null) {
			List<Cell> newPath = new ArrayList<>();
			Collections.copy(path, newPath);
			newPath.add(up);
			List<Cell> returnPath = findPath(maze, current, end, newPath);
			if(returnPath != null) {
				return path;
			}
		}
		// get down
		// get right
		// get left
		return null;
	}
	
	public Cell getUp(boolean[][] maze, Cell current) {
		if(current.row - 1 > maze.length) {
			boolean value = maze[current.row - 1][current.col];
			// not a black one
			if(value) {
				return new Cell(current.row - 1, current.col);
			}
		}
		return null;
	}
}
class Cell{
	int row;
	int col;
	
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
	}
}