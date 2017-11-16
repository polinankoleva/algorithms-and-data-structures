package com.data.structures.tree;

import java.util.List;

//TODO add comments
public class BinarySearchTree {

	public BSTNode root;
	List<BSTNode> nodes;

	public BinarySearchTree() {

	}

	public void insert(int key) {
		if (root == null) {
			BSTNode rootNode = new BSTNode(key, 1, null);
			this.root = rootNode;
			return;
		}
		BSTNode node = this.root;
		while (node != null) {
			if (key <= node.key) {
				if (node.left == null) {
					BSTNode newNode = new BSTNode(key, 1, node);
					node.left = newNode;
					return;
				}
				node.rank += 1;
				node = node.left;
			} else if (key >= node.key) {
				if (node.right == null) {
					BSTNode newNode = new BSTNode(key, 1, node);
					node.right = newNode;
					return;
				}
				node.rank += 1;
				node = node.right;
			}
		}

	}

	public int findMinimumKey() {
		if (root == null) {
			System.out.println("The tree is empty.");
			return Integer.MIN_VALUE;
		}
		return findMinimumNode().key;
	}

	public BSTNode findMinimumNode() {
		BSTNode node = this.root;
		if (node == null) {
			System.out.println("The tree is empty.");
			return null;
		}
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	public int findMaximumKey() {
		BSTNode node = this.root;
		if (node == null) {
			System.out.println("The tree is empty.");
			return Integer.MAX_VALUE;
		}
		while (node.right != null) {
			node = node.right;
		}
		return node.key;
	}

	public void traverseInorder(BSTNode startNode){
		if(startNode == null){
			return;
		}
		traverseInorder(startNode.left);
		System.out.print(startNode.key + " ");
		traverseInorder(startNode.right);
	}
	
	public void traversePreorder(BSTNode startNode){
		if(startNode == null){
			return;
		}
		System.out.print(startNode.key + " ");
		traverseInorder(startNode.left);
		traverseInorder(startNode.right);
	}
	
	public void traversePostorder(BSTNode startNode){
		if(startNode == null){
			return;
		}
		traverseInorder(startNode.left);
		traverseInorder(startNode.right);
		System.out.print(startNode.key + " ");
	}
}
