package com.tasks.data.structures.list;

import com.data.structures.list.CustomLinkedList;
import com.data.structures.list.Node;

/**
 * Delete a node in the middle (any node but the first and the last one, not
 * necessarily the exact middle) of a singly linked list, given only access to
 * that node.
 * CtCI book - Task 2.3
 * @author Polina Koleva
 *
 */
public class DeleteMiddleNode {
	
	// constant time
	public static boolean deleteMiddleNode(Node middle) {
		if (middle == null || middle.next == null)
			return false;
		middle.data = middle.next.data;
		middle.next = middle.next.next;
		return true;
	}

	public static void main(String[] args) {
		CustomLinkedList list = new CustomLinkedList();
		list.add(1);
		list.add(3);
		list.add(3);
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(2);
		list.add(3);
		list.add(4);
		// get access to a middle node
		Node middle = list.head;
		for (int i = 0; i < 4; i++) {
			middle = middle.next;
		}
		deleteMiddleNode(middle);
		System.out.println(list);
	}
}
