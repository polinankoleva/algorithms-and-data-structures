package com.data.structures.graph;

import java.util.LinkedList;

import com.data.structures.graph.GraphNode.State;

/**
 * Implementation of BFS and DFS.
 * 
 * @author Polina Koleva
 *
 */
public class GraphTraversal {

	// O(E+V) complexity, linear
	public void BFS(GraphNode root) {
		if (root == null)
			return;
		LinkedList<GraphNode> queue = new LinkedList<>();
		root.state = State.VISITING;
		queue.add(root);
		GraphNode current;
		while (!queue.isEmpty()) {
			current = queue.poll();
			current.visit();
			for (GraphNode child : current.adj) {
				if (child.state != State.VISITED && child.state != State.VISITING) {
					child.state = State.VISITING;
					queue.add(child);
				}
			}
		}
	}

	// O(E+V) complexity, linear
	public void DFS(GraphNode root) {
		if (root == null)
			return;
		root.visit();
		for (GraphNode child : root.adj) {
			if(child.state != State.VISITED) {
				DFS(child);
			}
		}
	}
}
