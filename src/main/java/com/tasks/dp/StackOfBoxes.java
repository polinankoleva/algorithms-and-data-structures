package com.tasks.dp;

import java.util.List;

/**
 * You have a stack of n boxes, with widths w i , heights h i , and depths d i .
 * The boxes cannot be rotated and can only be stacked on top of one another if
 * each box in the stack is strictly larger than the box above it in width,
 * height, and depth. Implement a method to compute the height of the tallest
 * possible stack. The height of a stack is the sum of the heights of each box.
 * Task 8.13, CCI
 * 
 * @author Polina Koleva
 *
 */
public class StackOfBoxes {

	public int stackHeight(Box last, List<Box> leftBoxes, int index, int[] stackMap) {
		if (index >= leftBoxes.size())
			return 0;
		if (index == leftBoxes.size() - 1) {
			Box firstBox = leftBoxes.get(index);
			return firstBox.h;
		}
		Box nextBox = leftBoxes.get(index);
		int heightWith = 0;
		if (last == null || last.larger(nextBox)) {
			if (stackMap[index] == 0) {
				int height = stackHeight(nextBox, leftBoxes, index + 1, stackMap);
				stackMap[index] = last.h + height;
			}
			heightWith = stackMap[index];
		}
		int heightWithoutNext = stackHeight(last, leftBoxes, index + 1, stackMap);
		return Math.max(heightWith, heightWithoutNext);
	}
}

class Box {
	// ask if dimensions of box can be double
	int h;
	int w;
	int d;

	public Box(int h, int w, int d) {
		this.h = h;
		this.w = w;
		this.d = d;
	}

	public boolean larger(Box b) {
		if (this.h > b.h && this.w > b.w && this.d > b.d) {
			return true;
		}
		return false;
	}
}
