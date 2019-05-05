package com.tasks.dp;

import java.util.Stack;

/**
 * you have 3 towers and N disks of different sizes which can slide onto any
 * tower. The puzzle starts with disks sorted in ASC order of size from top to
 * bottom (each disk sits on top of an even larger one). You have the following
 * constraints: 1. Only one disk can be moved at a time. 2. A disk is slid off
 * the top of one tower onto another tower. 3. A disk cannot be placed on top of
 * a smaller disk. Write a program to move the disks from the first tower to the
 * last using stacks.
 * 
 * @author Polina Koleva
 *
 */
public class TowerOfHanoi {
	
	public static Stack<Integer> towersOfHanoi(int disks) {
		Stack<Integer> x = new Stack<>();
		for (int i = disks; i > 0; i--) {
			x.push(i);
		}
		Stack<Integer> y = new Stack<>();
		Stack<Integer> z = new Stack<>();
		towersOfHanoiSimple(x.size(), x, y, z);
		return z;
	}
	
	// move all disks from x to z following the rules
	public static void towersOfHanoi(int disks, Stack<Integer> x, Stack<Integer> y , Stack<Integer> z) {
		// base cases
		if(disks <= 0) return;
		if(disks == 1) {
			z.push(x.pop());
			return;
		}
		if(disks == 2) {
			y.push(x.pop());
			z.push(x.pop());
			z.push(y.pop());
			return;
		}
		// recursive calls
		// move the first N-1 elements to the second stack y
		towersOfHanoi(disks - 1, x, z, y);
		//move the Nth element from x to z
		z.push(x.pop());
		// move back the first N-1 to the z stack
		towersOfHanoi(disks - 1, y, x, z);
	}
	
	// remove the base cases when disks are 1 and 2
	public static void towersOfHanoiSimple(int disks, Stack<Integer> x, Stack<Integer> y , Stack<Integer> z) {
		if(disks == 0) return;
		towersOfHanoiSimple(disks-1, x, z, y);
		System.out.println("Element " + x.peek() + " moved from pile: " + x +" to pile: " + z);
		z.push(x.pop());
		towersOfHanoiSimple(disks-1, y, x, z);
	}
	public static void towersOfHanoiWithoutRecursion(int disks, Stack<Integer> x, Stack<Integer> y , Stack<Integer> z) {
		if(disks == 0) return;
		towersOfHanoiSimple(disks-1, x, z, y);
		System.out.println("Element " + x.peek() + " moved from pile: " + x +" to pile: " + z);
		z.push(x.pop());
		towersOfHanoiSimple(disks-1, y, x, z);
	}
	public static void main(String[] args) {
		Stack<Integer> z = towersOfHanoi(10);
		while(!z.isEmpty()) {
			System.out.println(z.pop());
		}
	}
}
