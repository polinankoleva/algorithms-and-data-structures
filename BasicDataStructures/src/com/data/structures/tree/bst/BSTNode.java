package com.data.structures.tree.bst;

//TODO add comments
public class BSTNode {

	int key;
	int rank;
	BSTNode parent;
	BSTNode left;
	BSTNode right;

	public BSTNode(int key, int rank, BSTNode parent) {
		this.key = key;
		this.rank = rank;
		this.parent = parent;
	}
}
