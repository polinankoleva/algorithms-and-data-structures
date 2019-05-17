package com.tasks.data.structures.bt;

import java.util.ArrayList;
import java.util.List;

import com.data.structures.tree.BTNode;

/**
 * K largest elements in BST. Task 15.3, EPI book
 * 
 * @author Polina Koleva
 *
 */
public class KLargestElements {

	public List<BTNode> kLargestELements(BTNode root, int k) {
		List<BTNode> result = new ArrayList<>();
		kLargestELements(root, k, result);
		return result;
	}

	public void kLargestELements(BTNode root, int k, List<BTNode> result) {
		if (result.size() == k)
			return;
		if (root == null)
			return;
		if (root.right != null) {
			kLargestELements(root.right, k, result);
		}
		k--;
		result.add(root);
		kLargestELements(root.left, k, result);
	}
}
