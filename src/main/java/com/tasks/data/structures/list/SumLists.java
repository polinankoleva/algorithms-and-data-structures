package com.tasks.data.structures.list;

import com.data.structures.list.LinkedList;
import com.data.structures.list.Node;

/**
 * You have two numbers represented by a linked list where each node contains a
 * single digit. The digits are stored in reverse order, such that the 1's digit
 * is at the head of the list. Write a function that adds the two numbers and
 * returns the sum as a linked list. CCI book - Task 2.5 Follow Up: Suppose the
 * digits are stored in forward order.
 * 
 * @author Polina Koleva
 *
 */
public class SumLists {
	public static Node sumLists(Node head1, Node head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		Node headSumHead = null;
		Node headSumTail = null;
		int addition = 0;
		while (head1 != null && head2 != null) {
			int sum = head1.data + head2.data + addition;
			if (sum >= 10) {
				addition = 1;
				sum = sum % 10;
			} else {
				addition = 0;
			}
			Node nodeToAdd = new Node(sum);
			if (headSumTail == null) {
				headSumHead = nodeToAdd;
				headSumTail = nodeToAdd;
			} else {
				headSumTail.next = nodeToAdd;
				headSumTail = nodeToAdd;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		if (head1 != null) {
			while (head1 != null && addition != 0) {
				int sum = head1.data + addition;
				if (sum >= 10) {
					addition = 1;
					sum = sum % 10;
				} else {
					addition = 0;
				}
				Node nodeToAdd = new Node(sum);
				headSumTail.next = nodeToAdd;
				headSumTail = nodeToAdd;
				head1 = head1.next;
			}
			headSumTail.next = head1;
		} else if (head2 != null) {
			while (head2 != null && addition != 0) {
				int sum = head2.data + addition;
				if (sum >= 10) {
					addition = 1;
					sum = sum % 10;
				} else {
					addition = 0;
				}
				Node nodeToAdd = new Node(sum);
				headSumTail.next = nodeToAdd;
				headSumTail = nodeToAdd;
				head2 = head2.next;
			}
			headSumTail.next = head2;
		}
		return headSumHead;
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

	public static Node sumListsReverse(Node head1, Node head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		Node headSum = null;
		Node tailSum = null;
		// assuming the same length
		while (head1 != null && head2 != null) {
			Node nodeToAdd = new Node(head1.data + head2.data);
			if (headSum == null) {
				headSum = nodeToAdd;
				tailSum = nodeToAdd;
			} else {
				tailSum.next = nodeToAdd;
				tailSum = nodeToAdd;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		transferAddition(headSum);
		return headSum;
	}

	public static int transferAddition(Node head) {
		if (head == null)
			return 0;
		int addition = transferAddition(head.next);
		int sum = head.data + addition;
		if (sum >= 10) {
			addition = sum / 10;
			head.data = sum % 10;
		} else {
			head.data = sum;
			addition = 0;
		}
		return addition;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(6);
		list.add(1);
		list.add(7);
		LinkedList list2 = new LinkedList();
		list2.add(2);
		list2.add(9);
		list2.add(5);
		System.out.println(list.toString());
		System.out.println(list2.toString());
		Node head = sumListsReverse(list.head, list2.head);
		System.out.println(toString(head));
	}
}
