package com.data.structures.graph;

import java.util.ArrayList;

public class GraphNode {
	public ArrayList<GraphNode> adj;
	public int index;
	
	public GraphNode(int index){
		this.index =  index;
		this.adj = new ArrayList<GraphNode>();
	}
}
