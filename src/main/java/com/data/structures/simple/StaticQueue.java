/**
 * This code is produced with learning purposes.
 * 
 * Polina Koleva, 02.08.2016
 */
package com.data.structures.simple;

/**
 * Static implementation of a queue using an array.
 * 
 * @author Polina Koleva
 *
 */
public class StaticQueue {

	int[] queue;
	// an index of head of the queue
	int headIndex;
	// an index of tail of the queue
	int tailIndex;

	/**
	 * Constructor. Initializes all elements of the queue with
	 * Integer.MIN_VALUE. Sets the head's and tail's index to 0.
	 * 
	 * @param queueSize
	 */
	public StaticQueue(int queueSize) {
		this.queue = new int[queueSize];
		for (int i = 0; i < queue.length; i++) {
			queue[i] = Integer.MIN_VALUE;
		}
		this.headIndex = 0;
		this.tailIndex = 0;
	}

	/**
	 * Add element to the queue.
	 * 
	 * @param element
	 *            element that is inserted
	 */
	public void enqueue(int element) {
		// if the head and tail meets each other, but the queue is not empty -
		// no more free space
		if (headIndex == tailIndex && !isEmpty()) {
			System.out.println("Overflows...");
			return;
		}
		// adds the element to the space where tail is pointing
		queue[tailIndex] = element;
		// moves the tail to next cell
		tailIndex++;
		if (tailIndex > queue.length - 1) {
			tailIndex = 0;
		}
	}

	/**
	 * Removes an element from the queue.
	 * 
	 * @return the removed element or Integer.MIN_VALUE if the queue is empty
	 */
	public int dequeue() {
		int dequeuedElement = Integer.MIN_VALUE;
		if (isEmpty()) {
			System.out.println("Underflows...");
			return dequeuedElement;
		}
		// returned element is the head
		dequeuedElement = queue[headIndex];
		// marks cell as empty
		queue[headIndex] = Integer.MIN_VALUE;
		// makes head to points to the next element in the queue
		headIndex++;
		if (headIndex > queue.length - 1) {
			headIndex = 0;
		}
		return dequeuedElement;
	}

	/**
	 * Checks if a queue is empty.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		// if head and tail point to the same cell and it is "empty"
		if (headIndex == tailIndex && queue[headIndex] == Integer.MIN_VALUE) {
			return true;
		}
		return false;
	}
}
