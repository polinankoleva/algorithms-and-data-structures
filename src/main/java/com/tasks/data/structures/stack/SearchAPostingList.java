package com.tasks.data.structures.stack;

import java.util.Stack;

/**
 * Write recursive and iterative routines that take a postings list, and compute
 * the jump first order. Assume each node has an integer-valued field that holds
 * the order, and is initialized to -1. Task 9.5 EPI
 * 
 * @author Polina Koleva
 *
 */
public class SearchAPostingList {

	public static void orderRecursive(PostingListNode head) {
		setOrderHelper(head, 0);
	}

	public static int setOrderHelper(PostingListNode head, int order) {
		// if visited or non existing
		if (head == null || head.order != -1)
			return 0;
		order++;
		head.order = order;
		order = setOrderHelper(head.jump, order);
		order = setOrderHelper(head.next, order);
		return order;
	}

	public static void orderIteratively(PostingListNode head) {
		Stack<PostingListNode> next = new Stack<>();
		int order = 0;
		while (head != null) {
			if (head.order != -1) {
				order++;
				head.order = order;
			}
			// need to jump
			if (head.jump != null && head.jump.order != 1) {
				next.add(head.next);
				head = head.jump;
			} else if (head.next != null && head.next.order != -1) {
				head = head.next;
			} else if (!next.isEmpty()) {
				head = next.pop();
			} else {
				head = null;
			}
		}
	}

	public static void orderIterativelySimpler(PostingListNode head) {
		Stack<PostingListNode> toBeProcessed = new Stack<>();
		int order = 0;
		toBeProcessed.add(head);
		while (!toBeProcessed.isEmpty()) {
			PostingListNode node = toBeProcessed.pop();
			if (node.order != -1) {
				order++;
				node.order = order;
			}
			toBeProcessed.push(node.next);
			toBeProcessed.push(node.jump);
		}
	}
}

class PostingListNode {
	PostingListNode next;
	PostingListNode jump;
	int order;

	public PostingListNode() {
		this.order = -1;
	}
}