package com.tasks.data.structures.list;

import com.data.structures.list.Node;
import com.data.structures.list.LinkedList;;

/**
 * Find the k-th to last element of a singly linked list. CtCI book Task 2.2
 * 
 * @author Polina Koleva
 *
 */
public class KthToLast {

	public static Node kthToLast(LinkedList list, int k) {
		int size = list.size();
		if (k > size)
			return null;
		int searchedIndex = size - k;
		Node current = list.head;
		int index = 1;
		while (current != null) {
			if (index == searchedIndex) {
				return current;
			}
			index++;
			current = current.next;
		}
		return null;
	}

	// swicth two variables without a temporary one
	public static void exchange(int a, int b) {
		a += b;
		b -= a;
		b = Math.abs(b);
		a -= b;
		System.out.println(a);
		System.out.println(b);
	}

	public int kthToLastRecursive(Node head, int k) {
		// base case
		if (head == null)
			return 0;
		int depth = kthToLastRecursive(head.next, k) + 1;
		if (depth == k) {
			return head.data;
		}
		return depth;
	}

	public static Node kthToLastIterative(Node head, int k) {
		Node p1 = head;
		Node p2 = head;
		// move p1 k positions
		for (int i = 0; i < k; i++) {
			p1 = p1.next;
			if (p1 == null) {
				return null;
			}
		}
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(2);
		list.add(3);
		list.add(4);
		Node searchedNode = kthToLastIterative(list.head, 1);
		System.out.println(searchedNode.data);
	}
}
