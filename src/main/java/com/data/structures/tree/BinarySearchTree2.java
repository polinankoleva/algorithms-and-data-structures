package com.data.structures.tree;

/**
 * Binary Search tree is a binary tree in which all left descendants of a node
 * are smaller or equal than the node and all right descendants of the node are
 * greater. This rule is valid not only for direct descendants but for of them.
 * You can have balanced or unbalanced BST. The height of an unbalanced BST
 * might reach n-1 (O(n)). When a BST is balanced, it means that its height is
 * O(logn). Therefore, All operations as insert/find/smallest/biggest.
 * 
 * @author polina
 *
 */
public class BinarySearchTree2 {

	
	public void insert(BTNode node) {

	}

	public void delete(BTNode node) {

	}

	public void inOrder() {

	}

	public void postOrder() {

	}

	public void preOrder() {

	}

	private int height(BTNode root) {
		if(root == null) return -1;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	private int search() {
		return 0;
	}
}
