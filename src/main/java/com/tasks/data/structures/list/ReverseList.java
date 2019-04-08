package com.tasks.data.structures.list;

import com.data.structures.list.Node;

/**
 * Reverse a singly linked list.
 * 
 * @author Polina Koleva
 *
 */
public class ReverseList {
	public static Node reverse(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		return reverse(head.next, head);
	}

	public static Node reverse(Node current, Node previous) {
		if (current == null) {
			return previous;
		}
		Node head = reverse(current.next, current);
		current.next = previous;
		previous.next = null;
		return head;
	}

}
