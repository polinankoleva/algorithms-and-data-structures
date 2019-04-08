package com.tasks.data.structures.list;

import com.data.structures.list.CustomLinkedList;
import com.data.structures.list.Node;

/**
 * Partition a linked list around a value x, such that all nodes less than x
 * come before all nodes greater than or equal to x. If x is contained within
 * the list, the values of x only need to be after the elements less than x. The
 * partition element x can appear anywhere in the "right partition", it does not
 * need to appear between the left and right partitions.
 * 
 * CtCI book, Task 2.4
 * 
 * @author Polina Koleva
 *
 */
public class Partition {
	// keep two lists one with nodes that are smaller
	// and one with nodes that are greater
	// merge two lists and return the head of the newly created list
	public static Node partitionByValueTwoLists(int x, Node head) {
		if (head == null)
			return null;
		Node smallerHead = null;
		Node smallerTail = null;
		Node greaterHead = null;
		Node greaterTail = null;
		while (head != null) {
			// append to smaller list
			if (head.data < x) {
				// first element added
				if (smallerHead == null) {
					smallerHead = head;
					smallerTail = head;
				} else {
					smallerTail.next = head;
					smallerTail = smallerTail.next;
				}
			} else {
				// first element added to greater list
				if (greaterHead == null) {
					greaterHead = head;
					greaterTail = head;
				} else {
					greaterTail.next = head;
					greaterTail = greaterTail.next;
				}
			}
			head = head.next;
		}
		// create the next reference of the greater tail
		greaterTail.next = null;
		// if no smaller values than k
		if (smallerHead == null) {
			return greaterHead;
		} else if (greaterHead == null) {
			return smallerHead;
		} else {
			// merge both lists
			smallerTail.next = greaterHead;
			return smallerHead;
		}
	}

	public static void partitionByValue(int x, Node head) {
		// find first >= that x element
		while (head != null && head.data < x) {
			head = head.next;
		}
		// no elements or all elements smaller than, no need of partitioning
		if (head == null)
			return;
		Node greater = head;
		Node smaller = head.next;
		// exchange smaller with greater elements
		while (smaller != null) {
			if (smaller.data < x) {
				// exchange needed
				int temp = smaller.data;
				smaller.data = greater.data;
				greater.data = temp;
				greater = greater.next;
			}
			smaller = smaller.next;
		}
	}

	public static String toString(Node head) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		Node current = head;
		while (current != null) {
			sb.append(current.data + " ");
			current = current.next;
		}
		sb.append("}");
		return sb.toString();
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

		partitionByValueTwoLists(5, list.head);
		System.out.println(list);
	}

}
