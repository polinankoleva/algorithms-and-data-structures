package com.tasks.data.structures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

import com.data.structures.graph.Graph;
import com.data.structures.graph.GraphNode;
import com.data.structures.list.LinkedList;

/**
 * Graph Traversal implementation - BFS and DFS.
 * 
 * @author Polina Koleva
 *
 */
public class GraphSearch {

	public static void bfs(Graph graph, GraphNode sourceNode) {
		if (graph.vertices.isEmpty()) {
			System.out.println("Graph is empty.");
			return;
		}
		System.out.println("Starting traversing from:" + sourceNode.index);
		// map that contains key:index of Node, value: level
		HashMap<Integer, Integer> levels = new HashMap<Integer, Integer>();
		int level = 0;
		levels.put(sourceNode.index, level);
		ArrayList<GraphNode> frontier = new ArrayList<GraphNode>();
		frontier.add(sourceNode);
		while (!frontier.isEmpty()) {
			ArrayList<GraphNode> next = new ArrayList<GraphNode>();
			for (int i = 0; i < frontier.size(); i++) {
				GraphNode current = frontier.get(i);
				for (int j = 0; j < current.adj.size(); j++) {
					GraphNode currentAdj = current.adj.get(j);
					if (!levels.containsKey(currentAdj.index)) {
						levels.put(currentAdj.index, level);
						System.out.println(currentAdj.index);
						next.add(currentAdj);
					}
				}
			}
			frontier = next;
		}
	}

	// start from random node
	public static void bfs(Graph graph) {
		if (graph.vertices.isEmpty()) {
			System.out.println("Graph is empty.");
			return;
		}
		// pick a source node
		GraphNode sourceNode = graph.vertices.get(0);
		System.out.println(sourceNode.index);
		// map that contains key:index of Node, value: level
		HashMap<Integer, Integer> levels = new HashMap<Integer, Integer>();
		// node index, its parent index
		HashMap<Integer, Integer> parents = new HashMap<Integer, Integer>();
		int level = 0;
		levels.put(sourceNode.index, level);
		ArrayList<GraphNode> frontier = new ArrayList<GraphNode>();
		frontier.add(sourceNode);
		while (!frontier.isEmpty()) {
			ArrayList<GraphNode> next = new ArrayList<GraphNode>();
			for (int i = 0; i < frontier.size(); i++) {
				GraphNode current = frontier.get(i);
				for (int j = 0; j < current.adj.size(); j++) {
					GraphNode currentAdj = current.adj.get(j);
					if (!levels.containsKey(currentAdj.index)) {
						levels.put(currentAdj.index, level);
						parents.put(currentAdj.index, current.index);
						System.out.println(currentAdj.index);
						next.add(currentAdj);
					}
				}
			}
			frontier = next;
		}
	}
}
