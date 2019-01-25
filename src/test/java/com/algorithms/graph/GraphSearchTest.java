package com.algorithms.graph;

import java.util.ArrayList;

import org.junit.Test;

import com.data.structures.graph.Graph;
import com.data.structures.graph.GraphNode;

public class GraphSearchTest {

	
	@Test
	public void BFS() {
		GraphNode nodeIndex1 = new GraphNode(1);
		GraphNode nodeIndex2 = new GraphNode(2);
		GraphNode nodeIndex3 = new GraphNode(3);
		GraphNode nodeIndex4 = new GraphNode(4);
		GraphNode nodeIndex5 = new GraphNode(5);
		GraphNode nodeIndex6 = new GraphNode(6);
		GraphNode nodeIndex7 = new GraphNode(7);
		GraphNode nodeIndex8 = new GraphNode(8);
		
		// node 1 connected with node 2 and node 5
		nodeIndex1.adj.add(nodeIndex2);
		nodeIndex1.adj.add(nodeIndex5);
		
		// node 2 connected with node 1 and node 6
		nodeIndex2.adj.add(nodeIndex1);
		nodeIndex2.adj.add(nodeIndex6);
		
		//node 3 connected with node 6, node 7 and node 4
		nodeIndex3.adj.add(nodeIndex6);
		nodeIndex3.adj.add(nodeIndex7);
		nodeIndex3.adj.add(nodeIndex4);
		
		// node 4 connected with node 3, node 7 and node 8
		nodeIndex4.adj.add(nodeIndex3);
		nodeIndex4.adj.add(nodeIndex7);
		nodeIndex4.adj.add(nodeIndex8);
		
		// node 5 connected with with node 1
		nodeIndex5.adj.add(nodeIndex1);
		
		// node 6 connected with node 2, node 3 and node 7
		nodeIndex6.adj.add(nodeIndex2);
		nodeIndex6.adj.add(nodeIndex3);
		nodeIndex6.adj.add(nodeIndex7);
		
		// node 7 connected with node 6, node 3, node 4 and node 8
		nodeIndex7.adj.add(nodeIndex6);
		nodeIndex7.adj.add(nodeIndex3);
		nodeIndex7.adj.add(nodeIndex4);
		nodeIndex7.adj.add(nodeIndex8);
		
		// node 8 connected with node 7 and node 4
		nodeIndex8.adj.add(nodeIndex7);
		nodeIndex8.adj.add(nodeIndex4);
		
		ArrayList<GraphNode> nodes = new ArrayList<GraphNode>();
		nodes.add(nodeIndex8);
		nodes.add(nodeIndex7);
		nodes.add(nodeIndex6);
		nodes.add(nodeIndex5);
		nodes.add(nodeIndex4);
		nodes.add(nodeIndex3);
		nodes.add(nodeIndex2);
		nodes.add(nodeIndex1);
		
		Graph graph = new Graph(nodes);
		
		GraphSearch.bfs(graph, nodeIndex2);
		
		System.out.println("PATH:  ------------------");
		// shortest path between node 2 and node 8 (length 3)
		GraphNode currentNode = nodeIndex8;
//		System.out.println(currentNode.parent.index);
		boolean notFound = true;
		int pathLength = 0;
		while(notFound){
			//continue
			if(currentNode.index != nodeIndex2.index){
				System.out.println(currentNode.index);
//				currentNode = currentNode.parent;
				pathLength++;
			} else {
				System.out.println(currentNode.index);
				// end of path
				notFound = false;
			}
		}
		
	}
}
