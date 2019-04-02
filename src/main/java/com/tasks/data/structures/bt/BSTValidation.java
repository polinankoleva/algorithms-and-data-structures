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
