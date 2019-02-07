package com.tasks.data.structures;

import com.data.structures.tree.BTNode;

/**
 * Check if a binary tree is balanced. A balanced binary tree is defined to be a
 * tree such that the heights of the two subtrees of any node never differ by
 * more than one.
 * 
 * Cracking the coding interview Task 4.4
 * 
 * @author Polina Koleva
 *
 */
public class CheckBTBalanced {

	// simple solution O(nlogn) TODO read why?
	public int height(BTNode node) {
		if(node == null) return -1;
		return Math.max(height(node.left), height(node.right)) + 1;
	}
	
	public boolean checkBalanced(BTNode root) {
		if(root == null) return true;
		if(Math.abs(height(root.left) - height(root.right)) > 1) {
			return false;
		}else {
			return checkBalanced(root.left) && checkBalanced(root.right);
		}
	}
	
	public boolean checkBalanced2(BTNode root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}
	
	// use checking the height for checking the ifBalanced condition
	// use min_value as an error code for not balanced
	public int checkHeight(BTNode root) {
		if(root == null) return -1;
		int leftHeight = checkHeight(root.left);
		if(leftHeight == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		int rightHeight = checkHeight(root.right);
		if(rightHeight == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		if(Math.abs(rightHeight - leftHeight) > 1) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
}
