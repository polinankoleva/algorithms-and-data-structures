package com.tasks.data.structures.bt;

import com.data.structures.tree.BTNode;

/**
 * A binary tree is said to be height-balanced if for each node in the tree, the
 * difference in the height of its left and right subtrees is at most one. Write
 * a program that takes as tree is height-balanced.
 * 
 * Task 10.1, EPI book
 * @author Polina Koleva
 *
 */
public class CheckHeightBalancy {

	// n nodes
	// O(n) time, O(h) space for the recursive call
	public int isHeightBalanced(BTNode root) {
		if (root == null)
			return 0;
		int leftHeight = isHeightBalanced(root.left);
		// propagete unbalancy, either left of right tree are unbalanced
		if (leftHeight == -1) {
			return -1;
		}
		int rightHeight = isHeightBalanced(root.right);
		if (rightHeight == -1) {
			return -1;
		}
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		return 1 + Math.max(leftHeight, rightHeight);
	}
}
