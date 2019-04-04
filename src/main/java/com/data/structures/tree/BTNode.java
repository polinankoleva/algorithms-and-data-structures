package com.data.structures.tree;

//TODO add comments
public class BTNode {

	public int key;
	public int rank;
	public BTNode parent;
	public BTNode left;
	public BTNode right;

	public BTNode() {

	}

	public BTNode(int key, int rank, BTNode parent) {
		this.key = key;
		this.rank = rank;
		this.parent = parent;
	}
	
	
}
