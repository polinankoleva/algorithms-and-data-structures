package com.tasks.data.structures.graph;

import java.util.LinkedList;
import com.data.structures.graph.Graph;
import com.data.structures.graph.GraphNode;
import com.data.structures.graph.GraphNode.State;

/**
 * Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes.
 * 
 * Cracking the coding interview Task 4.1
 * 
 * @author Polina Koleva
 *
 */
public class RouteBetweenNodes {

	public boolean hasRoute(Graph g, GraphNode start, GraphNode end) {
		if (start == end)
			return true;
		if (start == null)
			return false;
		LinkedList<GraphNode> queue = new LinkedList<>();

		// initialize all nodes of the graph
		for (GraphNode node : g.vertices) {
			node.state = State.UNVISITED;
		}
		start.state = State.VISITING;
		queue.add(start);
		GraphNode current;
		while (!queue.isEmpty()) {
			current = queue.poll();
			for (GraphNode child : current.adj) {
				if (child.state == State.UNVISITED) {
					if (child == end) {
						return true;
					}
					child.state = State.VISITING;
					queue.add(child);
				}
			}
			current.state = State.VISITED;
		}
		return false;
	}
}
