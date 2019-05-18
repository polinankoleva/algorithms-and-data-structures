package com.tasks.data.structures.list;

/**
 * Write a program that takes as input a singly linked list and a nonnegative
 * integer k, and returns the list cyclically shifted to the right by k. 
 * Task 8.9, EPI book
 * 
 * @author Polina Koleva
 *
 */
public class CyclicRightShift {

	public static ListNode<Integer> cyclicRightShift(ListNode<Integer> head, int k){
		if(head == null) return head;
		// find size of the list and the tail
		int size = 0;
		ListNode<Integer> tail = head;
		while(tail.next != null) {
			size++;
			tail = tail.next;
		}
		size++;
		// connect tail and head, making the list cyclic
		tail.next = head;
		// if k is greater than size
		k = k % size;
		int stepToHead = size - k;
		while(stepToHead > 0) {
			head = head.next;
			tail = tail.next;
			stepToHead--;
		}
		tail.next = null;
		return head;
	}
	
	public static void main(String[] args) {
		ListNode<Integer> head = new ListNode<>(2);
		ListNode<Integer> next = new ListNode<>(3);
		head.next = next;
		ListNode<Integer> nextNext = new ListNode<>(5);
		next.next = nextNext;
		ListNode<Integer> nextNextNext = new ListNode<>(3);
		nextNext.next = nextNextNext;
		ListNode<Integer> tail = new ListNode<>(2);
		nextNextNext.next = tail;
		ListNode<Integer> newHead = cyclicRightShift(head, 3);
		while(newHead != null) {
			System.out.println(newHead.value);
			newHead = newHead.next;
		}

	}

}
