package com.data.structures.graph;

import java.util.List;

import com.data.structures.graph.GraphNode.State;

/**
 * Write a program that takes as input a directed graph and checks if the graph
 * contains a cycle.
 * 
 * @author Polina Koleva
 *
 */
public class CycleDetection {

	public boolean hasCycle(Graph g) {
		List<GraphNode> nodes = g.vertices;
		while (!nodes.isEmpty()) {
			boolean hasCycle = hasCycle(nodes.get(0), nodes);
			if (hasCycle)
				return hasCycle;
		}
		return false;
	}

	public boolean hasCycle(GraphNode start, List<GraphNode> nodes) {
		if (start.state == State.VISITING) {
			return true;
		}
		nodes.remove(start);
		start.state = State.VISITING;
		for (GraphNode child : start.adj) {
			if (child.state != State.VISITED) {
				boolean cycle = hasCycle(child, nodes);
				if (cycle)
					return cycle;
			}
		}
		start.state = State.VISITED;
		return false;
	}
}
