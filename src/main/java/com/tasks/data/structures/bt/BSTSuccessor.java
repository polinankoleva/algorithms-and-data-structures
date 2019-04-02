package com.tasks.data.structures.bt;

import com.data.structures.tree.BTNode;

/**
 * Find the first common ancestor of two nodes in a binary tree.
 * 
 * @author Polina Koleva
 *
 */
public class BSTSuccessor {
	public static boolean commonSuccessor(BTNode root, BTNode n1, BTNode n2, BTNode firstSuccessor) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null)
			return false;
		if (root.equals(n1) || root.equals(n1))
			return true;
		boolean left = commonSuccessor(root.left, n1, n2, firstSuccessor);
		boolean right = commonSuccessor(root.right, n1, n2, firstSuccessor);
		if (left && right && firstSuccessor == null) {
			firstSuccessor = root;
		}
		return left || right;
	}

	public static void main(String[] args) {
		BTNode root = new BTNode();
		root.key = 1;
		BTNode left = new BTNode();
		left.key = 2;
		BTNode right = new BTNode();
		right.key = 2;
		root.left = left;
		root.right = right;
		BTNode leftLeft = new BTNode();
		leftLeft.key = 4;
		BTNode leftRight = new BTNode();
		leftRight.key = 5;
		left.left = leftLeft;
		left.right = leftRight;
		BTNode rLeft = new BTNode();
		rLeft.key = 6;
		BTNode rRight = new BTNode();
		rRight.key = 7;
		right.left = rLeft;
		right.right = rRight;
		BTNode rlLeft = new BTNode();
		rLeft.key = 8;
		BTNode rlRight = new BTNode();
		rlRight.key = 9;
		rLeft.right = rlRight;
		rLeft.left = rlLeft;
		
		
	}

}
