package com.tasks.data.structures.list;

/**
 * Write a program that takes two lists, assumed to be sorted, and returns their
 * The only field your program can change in a node is its next field.
 * 
 * @author Polina Koleva
 *
 */
public class MergeTwoSortedLists {

	public static ListNode<Integer> merge(ListNode<Integer> l1, ListNode<Integer> l2) {
		if(l1 != null && l2 == null) return l1;
		if(l1 == null && l2 != null) return l2;
		ListNode<Integer> resultHead = null;
		ListNode<Integer> lastInserted = null;
		// iterate while reaches the end of one of the list
		while (l1 != null && l2 != null) {
			ListNode<Integer> toBeInserted = null;
			if (l1.value <= l2.value) {
				toBeInserted = l1;
				l1 = l1.next;
			} else {
				toBeInserted = l2;
				l2 = l2.next;
			}
			if (lastInserted == null) {
				resultHead = toBeInserted;
				lastInserted = toBeInserted;
			} else {
				lastInserted.next = toBeInserted;
				lastInserted = toBeInserted;
			}
		}
		// check l1 for more nodes
		if (l1 != null) {
			// append to the result list
			lastInserted.next = l1;
		}
		// check l2 for more nodes
		if (l2 != null) {
			// append to the result list
			lastInserted.next = l2;
		}
		return resultHead;
	}
	
	public static void main(String[] args) {
		ListNode<Integer> firstHead = new ListNode(3);
		ListNode<Integer> firstNext = new ListNode(11);
		firstHead.next = firstNext;
		
		ListNode<Integer> secondHead = new ListNode(2);
		ListNode<Integer> secondNext = new ListNode(5);
		secondHead.next = secondNext;
		ListNode<Integer> secondNextNext = new ListNode(7);
		secondNext.next = secondNextNext;
		
		ListNode<Integer> resultHead = merge(firstHead, secondHead);
		while(resultHead != null) {
			System.out.println(resultHead.value);
			resultHead = resultHead.next;
		}
	}
}

// node in a singly linked list
class ListNode<T> {
	ListNode<Integer> next;
	T value;
	
	public ListNode(T value) {
		this.value = value;
	}

}