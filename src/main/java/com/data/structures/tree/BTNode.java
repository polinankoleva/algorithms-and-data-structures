package com.data.structures.tree;

//TODO add comments
public class BTNode {

	int key;
	int rank;
	BTNode parent;
	BTNode left;
	BTNode right;

	public BTNode(int key, int rank, BTNode parent) {
		this.key = key;
		this.rank = rank;
		this.parent = parent;
	}
}
