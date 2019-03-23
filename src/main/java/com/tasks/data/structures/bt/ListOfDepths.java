package com.tasks.data.structures.bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.data.structures.tree.BTNode;

/**
 * Given a binary tree design an algorithm which creates a linked list of all
 * the nodes at each depth.
 * 
 * Cracking the coding interview Task 4.3
 * 
 * @author Polina Koleva
 *
 */
public class ListOfDepths {

	public void addToLists(List<LinkedList<BTNode>> depthLists, LinkedList<BTNode> nodes) {
		if(nodes.isEmpty()) return;
		depthLists.add(nodes);
		LinkedList<BTNode> current = new LinkedList<>();
		for(BTNode node : nodes) {
			current.add(node.left);
			current.add(node.right);
		}
		addToLists(depthLists, current);
	}
	
	public List<LinkedList<BTNode>> listOfDepths(BTNode root){
		ArrayList<LinkedList<BTNode>> collection = new ArrayList<>();
		LinkedList<BTNode> list = new LinkedList<>();
		list.add(root);
		addToLists(collection, list);
		return collection;
	}
}
