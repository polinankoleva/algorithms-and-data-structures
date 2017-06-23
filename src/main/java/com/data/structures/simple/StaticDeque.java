/**
 * This code is produced with learning purposes.
 * 
 * Polina Koleva, 02.08.2016
 */
package com.data.structures.simple;

/**
 * Static deque implementation. This structure is similar to queue with one
 * difference that you can dequeue/enqueue from the front and from the end of
 * the queue.
 * 
 * @author Polina Koleva
 *
 */
public class StaticDeque {

	// represents the head of the deque
	int headIndex;
	// represents the next free index where new element can be added
	int tailIndex;

	int[] deque;

	public StaticDeque(int size) {
		this.deque = new int[size];

		// MIN_VALUE represents an empty cell in an array/deque
		for (int i = 0; i < deque.length; i++) {
			deque[i] = Integer.MIN_VALUE;
		}
		this.headIndex = 0;
		this.tailIndex = 0;
	}

	/**
	 * Inserts element at the front of deque.
	 * 
	 * @param element
	 *            element that is inserted.
	 */
	public void endequeAtFront(int element) {
		if (isEmpty()) {
			// if this is the first added element
			// adds it to the position of the head
			// and increase the tail
			this.deque[headIndex] = element;
			tailIndex++;
			return;
		}
		if (isFull()) {
			System.out.println("Overflows...");
			return;
		}
		// adds element to the front - so decrease the headIndex which points to
		// the new element's cell
		headIndex--;
		// if no free cell to the right of the head - moves to the end of deque
		if (headIndex == -1) {
			// points to the last element
			headIndex = this.deque.length - 1;
		}
		deque[headIndex] = element;
	}

	/**
	 * Removes an element to which the head is pointing and returns it as a
	 * result.
	 * 
	 * @return the element to which the head is pointing
	 */
	public int dedequeAtFront() {
		if (isEmpty()) {
			// no elements at all
			System.out.println("Underflows...");
			return Integer.MIN_VALUE;
		}
		int element = this.deque[headIndex];
		// makes cell "empty" again
		deque[headIndex] = Integer.MIN_VALUE;
		// increases the head's index
		headIndex++;
		// if there is no more free cells to the left of the head - makes head
		// points to the first element of an array
		if (headIndex > deque.length - 1) {
			headIndex = 0;
		}
		return element;
	}

	/**
	 * Adds element at the end of the deque.
	 * 
	 * @param element
	 *            element that is added.
	 */
	public void endequeAtEnd(int element) {
		if (isEmpty()) {
			// if this is the first added element
			// adds it to the position of the head
			// and increase the tail
			tailIndex++;
			this.deque[headIndex] = element;
			return;
		}
		if (isFull()) {
			System.out.println("Overflows...");
			return;
		}
		// adds the new element
		deque[tailIndex] = element;
		// increase the tail's index - if it reaches the end of the array, makes
		// to point to the first element of the array
		tailIndex++;
		if (tailIndex > deque.length - 1) {
			tailIndex = 0;
		}
	}

	/**
	 * Removes an element at the end of the deque.
	 * 
	 * @return the element at the end
	 */
	public int dedequeAtEnd() {
		if (isEmpty()) {
			System.out.println("Underflows...");
			return Integer.MIN_VALUE;
		}
		tailIndex--;
		if (tailIndex == -1) {
			tailIndex = deque.length - 1;
		}
		int element = this.deque[tailIndex];
		// makes the cell "empty"
		this.deque[tailIndex] = Integer.MIN_VALUE;
		return element;
	}

	/**
	 * Checks if the deque is empty.
	 * 
	 * @return true if deque is empty; otherwise false
	 */
	public boolean isEmpty() {
		if (headIndex == tailIndex && deque[headIndex] == Integer.MIN_VALUE) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if deque is full - no more free cells.
	 * 
	 * @return true if deque is full; otherwise false
	 */
	public boolean isFull() {
		if ((headIndex == tailIndex && deque[headIndex] != Integer.MIN_VALUE)
				|| ((headIndex == 0 && tailIndex == this.deque.length - 1))) {
			return true;
		}
		return false;
	}
}
