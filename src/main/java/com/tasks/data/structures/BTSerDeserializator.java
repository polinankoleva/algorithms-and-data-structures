package com.tasks.data.structures;

import com.data.structures.tree.BTNode;

/**
 * Serialization is to store tree in a file so that it can be later restored.
 * The structure of tree must be maintained. Deserialization is reading tree
 * back from file
 * 
 * @author Polina Koleva
 *
 */
public class BTSerDeserializator {

	// store in order traversal + -1 for null values
	public String serialize(BTNode root) {
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root, sb);
		return sb.toString().substring(0, sb.length() - 1);
	}
	
	public void preOrderTraverse(BTNode root, StringBuilder sb) {
		if(root == null) sb.append("-1,");
		sb.append(root.key + ",");
		preOrderTraverse(root.left, sb);
		preOrderTraverse(root.right, sb);
	}
	
	// todo continue
	public BTNode deserialize(String s) {
		return null;
	}
}
