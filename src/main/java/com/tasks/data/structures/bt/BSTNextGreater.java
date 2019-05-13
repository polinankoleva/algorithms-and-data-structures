package com.tasks.data.structures.bt;

import com.data.structures.tree.BTNode;

/**
 * Write a program that takes as input a BST and a value, and returns the first
 * key that would appear in an inorder traversal which is greater than the input
 * value.
 * Task 15.2, EPI book
 * @author Polina Koleva
 *
 */
public class BSTNextGreater {

	public int nextGreaterIteratively(BTNode root, int value) {
		BTNode greaterSoFar = null;
		BTNode current = root;
		while (current != null) {
			if (current.key > value) {
				greaterSoFar = current;
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return greaterSoFar.key;
	}

	public int nextGreaterRecusrively(BTNode root, int value) {
		BTNode node = search(root, value);
		if (node.left != null) {
			return smallest(node.left).key;
		} else {
			return node.parent.key;
		}

	}

	public BTNode smallest(BTNode root) {
		if (root.right == null)
			return root;
		return smallest(root.right);
	}

	public BTNode search(BTNode root, int value) {
		if (root == null)
			return root;
		if (root.key == value)
			return root;
		return value > root.key ? search(root.right, value) : search(root.left, value);
	}
}
