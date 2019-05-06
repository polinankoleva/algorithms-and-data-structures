package com.data.structures.graph;

import java.util.ArrayList;

public class GraphNode {
	public ArrayList<GraphNode> adj;
	public int index;
	public State state;

	public enum State {
		VISITED, VISITING,
		// initial state
		UNVISITED;
	}
	public GraphNode() {
		this.adj = new ArrayList<GraphNode>();
	}
	
	public GraphNode(int index) {
		this.index = index;
		this.adj = new ArrayList<GraphNode>();
	}

	public void visit() {
		this.state = State.VISITED;
		System.out.println(index);
	}
}
