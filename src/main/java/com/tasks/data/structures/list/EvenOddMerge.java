package com.tasks.data.structures.list;

/**
 * Consider a singly linked list whose nodes are numbered starting at 0. Define
 * the evenodd merge of the list to be the list consisting of the even-numbered
 * nodes followed by the odd-numbered nodes.
 * 
 * @author Polina Koleva
 *
 */
public class EvenOddMerge {

	public static ListNode<Integer> evenOddMerge(ListNode<Integer> head) {
		if (head == null)
			return head;
		ListNode<Integer> evenPointer = head;
		ListNode<Integer> oddListHead = head.next;
		ListNode<Integer> oddPointer = head.next;
		while (oddPointer != null && oddPointer.next != null) {
			ListNode<Integer> evenNext = evenPointer.next.next;
			evenPointer.next = evenPointer.next.next;
			evenPointer = evenNext;
			if (evenPointer.next != null) {
				ListNode<Integer> oddNext = oddPointer.next.next;
				oddPointer.next = oddPointer.next.next;
				oddPointer = oddNext;
			} else {
				oddPointer.next = null;
				break;
			}
		}
		// merge even and odd pointer
		evenPointer.next = oddListHead;
		return head;
	}

	public static void main(String[] args) {
		ListNode<Integer> head = new ListNode<>(0);
		ListNode<Integer> next = new ListNode<>(1);
		head.next = next;
		ListNode<Integer> nextNext = new ListNode<>(2);
		next.next = nextNext;
		ListNode<Integer> nextNextNext = new ListNode<>(3);
		nextNext.next = nextNextNext;
		ListNode<Integer> tail = new ListNode<>(4);
		nextNextNext.next = tail;
		ListNode<Integer> newHead = evenOddMerge(head);
		while (newHead != null) {
			System.out.println(newHead.value);
			newHead = newHead.next;
		}
	}
}
