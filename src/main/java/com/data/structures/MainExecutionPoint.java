package com.data.structures;
/**
 * This code is produced with learning purposes.
 * 
 * Polina Koleva, 02.08.2016.
 */

import com.data.structures.simple.StaticDeque;
import com.data.structures.simple.StaticQueue;
import com.data.structures.simple.StaticStack;
import com.data.structures.tree.BinarySearchTree;

/**
 * Main class which is used for testing the implemented data structures.
 * 
 * @author Polina Koleva
 *
 */
public class MainExecutionPoint {

	public static void main(String[] args) {
		// testStaticStack();
		// testStaticQueue();
		// testTwoStacks();
		// testDeque();
		// testBinarySearchTree();
	}

	// TODO move to tests
	public static void testBinarySearchTree() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(40);
		bst.insert(25);
		bst.insert(78);
		bst.insert(10);
		bst.insert(32);

		System.out.println("Max:" + bst.findMaximumKey());
		System.out.println("Min:" + bst.findMinimumKey());

		bst.traverseInorder(bst.root);
		System.out.println();
		bst.traversePreorder(bst.root);
		System.out.println();
		bst.traversePostorder(bst.root);

	}

	public static void testDeque() {
		StaticDeque deque = new StaticDeque(5);

		System.out.println("Test undeflow...");
		deque.dedequeAtEnd();
		deque.dedequeAtFront();

		deque.endequeAtFront(1);
		deque.endequeAtFront(2);
		deque.endequeAtFront(3);
		deque.endequeAtEnd(4);
		deque.endequeAtEnd(5);

		// test overflow
		System.out.println("Test overflow...");
		deque.endequeAtEnd(1);
		deque.endequeAtFront(2);

		System.out.println("Dequeue at front:" + deque.dedequeAtFront() + ". Expected result: 3");
		System.out.println("Dequeue at end:" + deque.dedequeAtEnd() + ". Expected result: 5");
		System.out.println("Dequeue at end:" + deque.dedequeAtEnd() + ". Expected result: 4");
		System.out.println("Dequeue at front:" + deque.dedequeAtFront() + ". Expected result: 2");
		System.out.println("Dequeue at front:" + deque.dedequeAtFront() + ". Expected result: 1");

		// System.out.println("Test undeflow...");
		deque.dedequeAtEnd();
		deque.dedequeAtFront();

		deque.endequeAtEnd(1);
		System.out.println("Deque at end: " + deque.dedequeAtEnd() + ". Expected result: 1");
		deque.endequeAtEnd(2);
		System.out.println("Deque at front: " + deque.dedequeAtFront() + ". Expected result: 2");
		deque.endequeAtFront(3);
		System.out.println("Deque at front: " + deque.dedequeAtFront() + ". Expected result: 3");
		deque.endequeAtFront(4);
		System.out.println("Deque at end: " + deque.dedequeAtEnd() + ". Expected result: 4");

	}

	// public static void testTwoStacks() {
	// StaticTwoStacksQueue twoStacks = new StaticTwoStacksQueue(5);
	//
	// // test underflow
	// System.out.println("Test underflow...");
	// // pops from the first stack
	// twoStacks.pop(1);
	// // pops from the second stack
	// twoStacks.pop(2);
	//
	// twoStacks.push(1, 1);
	// twoStacks.push(1, 2);
	// twoStacks.push(1, 3);
	// twoStacks.push(2, 10);
	// twoStacks.push(2, 9);
	//
	// System.out.println("Test overflow...");
	// // test overflow
	// twoStacks.push(1, 4);
	// twoStacks.push(2, 8);
	//
	// System.out.println("Pop from 1st stack:" + twoStacks.pop(1) + ". Expected
	// number: 3");
	// System.out.println("Pop from 2nd stack:" + twoStacks.pop(2) + ". Expected
	// number: 9");
	// System.out.println("Pop from 1st stack:" + twoStacks.pop(1) + ". Expected
	// number: 2");
	// System.out.println("Pop from 2nd stack:" + twoStacks.pop(2) + ". Expected
	// number: 10");
	// System.out.println("Pop from 1st stack:" + twoStacks.pop(1) + ". Expected
	// number: 1");
	//
	// // test underflow
	// System.out.println("Testing underflow...");
	// twoStacks.pop(1);
	// twoStacks.pop(2);
	//
	// }

	public static void testStaticQueue() {
		StaticQueue queue = new StaticQueue(5);

		// test emptiness
		System.out.println("Is queue empty:" + queue.isEmpty() + ". Expected : true");

		// test underflow
		queue.dequeue();

		queue.enqueue(1);
		queue.enqueue(2);

		System.out.println("Dequeue:" + queue.dequeue() + ". Expected : 1");
		System.out.println("Is the queue empty:" + queue.isEmpty() + ". Expected : false");
		System.out.println("Dequeue:" + queue.dequeue() + ". Expected : 2");
		System.out.println("Is the queue empty:" + queue.isEmpty() + ". Expected :  true");

		// test overflow
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);

		System.out.println("Dequeue:" + queue.dequeue() + ". Expected : 1");
		System.out.println("Dequeue:" + queue.dequeue() + ". Expected : 2");

		queue.enqueue(6);
		queue.enqueue(7);

		System.out.println("Is queue empty:" + queue.isEmpty() + ". Expected : false");

		// overflow
		queue.enqueue(8);

		System.out.println("Dequeue:" + queue.dequeue() + ". Expected : 3");
		System.out.println("Dequeue:" + queue.dequeue() + ". Expected : 4");
		System.out.println("Dequeue:" + queue.dequeue() + ". Expected : 5");
		System.out.println("Dequeue:" + queue.dequeue() + ". Expected : 6");
		System.out.println("Dequeue:" + queue.dequeue() + ". Expected : 7");
		System.out.println("Is queue empty: " + queue.isEmpty() + ". Expected : true");
	}

	public static void testStaticStack() {
		// Static stack testing ...
		StaticStack stack = new StaticStack(5);

		System.out.println("Push 1...");
		stack.push(1);
		int result = stack.pop();
		System.out.println("Pop... Result:" + result);

		result = stack.pop();
		System.out.println("Pop empty stack... Result:" + result);

		System.out.println("Is stack empty:" + stack.isEmpty());

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		// Overflow...
		stack.push(6);

		System.out.println("Is stack empty:" + stack.isEmpty());

		System.out.println("Pop.... Result:" + stack.pop());
		System.out.println("Pop... Result:" + stack.pop());
		System.out.println("Pop... result:" + stack.pop());
		System.out.println("And so on...");
	}
}
