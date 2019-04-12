package com.tasks.data.structures.bt;

/**
 * Rank from Stream: Imagine you are reading in a stream of integers.
 * Periodically, you wish to be able to look up the rank of a number x (the
 * number of values less than or equal to x). Implement the data structures and
 * algorithms to support these operations. That is, implement the method
 * track(int x), which is called when each number is generated, and the method
 * getRankOfNumber(int x), which returns the number of values less than or equal
 * to x (not including x itself). Task 10.10, CCI
 * 
 * @author Polina Koleva
 */
public class RankTracker {
	Node root;

	public RankTracker(Node root) {
		this.root = root;
	}

	public void track(int x) {
		if (root == null) {
			Node newLeaf = new Node(null, x);
			root = newLeaf;
			return;
		}
		track(null, root, x);
	}

	public int getRankOfNumber(int x) {
		return getRankOfNumber(root, x);
	}

	private int getRankOfNumber(Node root, int x) {
		if (root == null)
			return 0;
		if (root.data == x) {
			return findSmaller(root.parent, root);
		}
		if (root.data > x) {
			return getRankOfNumber(root.left, x);
		} else if (root.data < x) {
			return getRankOfNumber(root.right, x);
		}
		return -1;
	}

	public int findSmaller(Node parent, Node root) {
		int smaller = 0;
		if (root.right != null) {
			smaller += root.right.smallerNodes;
		}
		while (parent != null && parent.left == root) {
			smaller += parent.smallerNodes;
			root = parent;
			parent = parent.parent;
		}
		return smaller;
	}

	private void track(Node parent, Node root, int x) {
		if (root == null) {
			Node newLeaf = new Node(parent, x);
			if (parent.data > x) {
				parent.left = newLeaf;
			} else if (parent.data < x) {
				parent.right = newLeaf;
			}
			return;
		}
		root.smallerNodes++;
		if (root.data > x) {
			track(root, root.left, x);
		} else if (root.data < x) {
			track(root, root.right, x);
		}
	}
}

class Node {
	public int data;
	public int smallerNodes;
	Node left;
	Node right;
	Node parent;

	public Node(Node parent, int data) {
		this.data = data;
		this.smallerNodes = 1;
		this.left = null;
		this.right = null;
		this.parent = parent;
	}
}