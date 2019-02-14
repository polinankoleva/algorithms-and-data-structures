package com.tasks.data.structures;

import com.data.structures.tree.BTNode;
import com.data.structures.tree.BinarySearchTree;

/**
 * Given a sorted (increasing order) array with unique integer elements, write
 * an algorithm to create a binary search tree with minimal height.
 * 
 * Cracking the coding interview Task 4.2
 * 
 * @author Polina Koleva
 *
 */
public class MinimalBSTree {

	// return the root of the tree
	public BTNode createMinimalBST(int[] array) {
		return createMinimalBST(array, 0, array.length - 1);
	}

	private BTNode createMinimalBST(int[] array, int start, int end) {
		if (start > end)
			return null;
		BTNode node = new BTNode();
		int middle = (start + end) / 2;
		node.key = array[middle];
		node.left = createMinimalBST(array, start, middle - 1);
		node.right = createMinimalBST(array, middle + 1, end);
		return node;
	}

	public BinarySearchTree createMinimalBST2(int[] array) {
		BinarySearchTree tree = new BinarySearchTree();
		BTNode root = new BTNode();
		tree.root = root;
		connectNodes(root, array, 0, array.length);
		return tree;
	}

	public void connectNodes(BTNode node, int[] array, int start, int end) {
		if (start == end) {
			node.key = array[start];
			return;
		}
		int middle = (start + end) / 2;
		node.key = array[middle];
		if (middle - 1 >= start) {
			// add left node
			BTNode left = new BTNode();
			left.parent = node;
			node.left = left;
			connectNodes(left, array, start, middle - 1);
		}
		if (middle + 1 <= end) {
			// add right node
			BTNode right = new BTNode();
			right.parent = node;
			node.right = right;
			connectNodes(right, array, middle + 1, end);
		}
	}
}
