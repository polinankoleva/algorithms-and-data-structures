package com.tasks.data.structures.bt;

import com.data.structures.tree.BTNode;

/**
 * Find lowest common ancestor in BST.
 * 
 * Task 10.3, EPI book
 * 
 * @author Polina Koleva
 *
 */
public class LowestCommonAncestor {

	public boolean lowestCommonAncestor(BTNode root, BTNode p, BTNode q, BTNode lca) {
		if (root == null)
			return false;
		if (lca != null)
			return true;
		boolean left = lowestCommonAncestor(root.left, p, q, lca);
		boolean right = lowestCommonAncestor(root.right, p, q, lca);
		if (root == p && (left || right)) {
			lca = root;
			return true;
		}
		if (root == q && (left || right)) {
			lca = root;
			return true;
		}
		if (p == root || q == root)
			return true;
		if (left && right) {
			lca = root;
		}
		return left || right;
	}
}
