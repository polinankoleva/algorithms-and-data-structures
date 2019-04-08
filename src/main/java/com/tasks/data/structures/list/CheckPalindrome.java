package com.tasks.data.structures.list;

import java.util.Stack;

import com.data.structures.list.CustomLinkedList;
import com.data.structures.list.Node;

/**
 * Check if a singly linked list is a palindrome.
 * 
 * @author Polina Koleva
 *
 */
public class CheckPalindrome {

	// solution if size is available
	public static boolean checkPalindrome(Node head) {
		boolean isPalindrome = true;
		int listSize = getSize(head);
		if (listSize <= 1)
			return true;
		int iterations = listSize / 2 - 1;
		Stack<Node> stack = new Stack();
		int currentIndex = 0;
		while (currentIndex <= iterations) {
			stack.push(head);
			head = head.next;
			currentIndex++;
		}
		if (listSize % 2 != 0) {
			head = head.next;
		}
		while (head != null) {
			Node same = stack.pop();
			if (head.data != same.data) {
				isPalindrome = false;
				break;
			}
			head = head.next;
		}
		return isPalindrome;
	}

	public static int getSize(Node head) {
		int size = 0;
		while (head != null) {
			size++;
			head = head.next;
		}
		return size;
	}

	// using slow and faster pointer to push half of the elements to the stack
	// and to check if they are similar with the other half
	public static boolean checkPalindromeWithoutSize(Node head) {
		if (head == null || head.next == null)
			return true;
		boolean isPalindrome = true;
		Stack<Node> stack = new Stack<>();
		Node slowPointer = head;
		Node fastPointer = head;
		while (fastPointer != null) {
			if (fastPointer.next == null) {
				slowPointer = slowPointer.next;
				break;
			} else {
				stack.push(slowPointer);
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next.next;
			}
		}
		while (slowPointer != null) {
			if (stack.pop().data != slowPointer.data) {
				isPalindrome = false;
				break;
			}
			slowPointer = slowPointer.next;
		}
		return isPalindrome;

	}

	// use the length of the linked list
	public boolean checkPalindromeRecursively(Node head) {
		// TODO implement it
		return false;
	}

	public static void main(String[] args) {
		CustomLinkedList list = new CustomLinkedList();
		list.add(1);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(3);
		list.add(1);
		System.out.println(checkPalindromeWithoutSize(list.head));
	}
}