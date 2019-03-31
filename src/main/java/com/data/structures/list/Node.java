package com.data.structures.list;

/**
 * Node of a singly linked list. Each node contains one integer field and a
 * pointer to the next node in the list. If the pointer is null, the node is
 * considered as the tail of the list.
 * 
 * @author Polina Koleva
 *
 */
public class Node {

	public int data;
	public Node next;

	/**
	 * Initialize the node with data and next pointing to null.
	 * 
	 * @param data
	 */
	public Node(int data) {
		this.data = data;
		this.next = null;
	}

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}
