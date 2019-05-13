package com.tasks.data.structures.bt;

import com.data.structures.tree.BTNode;

/**
 * Implement a function to check if a binary tree is a binary search tree.
 * 
 * @author Polina Koleva
 *
 */
public class BSTValidation {
	boolean isBTValid(BTNode root) {
		return ifNodeValid(root, 0, Integer.MAX_VALUE);
	}

	public boolean isBST(BTNode root, int min, int max) {
		if (root == null)
			return true;
		if (root.left != null) {
			if (root.left.key > root.key || root.left.key < min || root.left.key > max) {
				return false;
			}
		}
		if (root.right != null) {
			if (root.right.key < root.key || root.right.key < min || root.right.key > max) {
				return false;
			}
		}
		return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
	}

	boolean ifNodeValid(BTNode root, int smaller, int bigger) {
		if (root == null)
			return true;
		// validate all the constraints, distinct elements
		boolean rootValid = (root.key > smaller && root.key < bigger);
		if (!rootValid)
			return false;
		boolean leftValid = ifNodeValid(root.left, smaller, root.key);
		boolean rightValid = ifNodeValid(root.right, root.key, bigger);
		return (leftValid && rightValid);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
