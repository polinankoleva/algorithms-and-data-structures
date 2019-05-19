package com.tasks.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Consider a coordinate system for the Milky Way in which Earth is at (0,0,0).
 * Model stars as points, and assume distances are in light years. The Milky Way
 * consists of approximately 1012 stars, and their coordinates are stored in a
 * file.
 * 
 * How would you compute the k stars which are closest to Earth? Task 11.4, EPI
 * book
 * 
 * @author Polina Koleva
 *
 */
public class KClosestStars {

	public List<Star> kClosestStars(List<Star> stars, int k) {
		List<Star> closest = new ArrayList<>();
		PriorityQueue<Star> maxHeap = new PriorityQueue<>(new Comparator<Star>() {
			@Override
			public int compare(Star s1, Star s2) {
				return (int) (s2.distance() - s1.distance());
			}
		});
		for (int i = 0; i <= k; i++) {
			maxHeap.add(stars.get(k));
		}
		int next = k + 1;
		for (int i = k + 1; i < stars.size(); i++) {
			Star current = stars.get(i);
			if (current.distance() < maxHeap.peek().distance()) {
				maxHeap.poll();
				maxHeap.add(current);
			}
		}
		while (!maxHeap.isEmpty()) {
			closest.add(maxHeap.poll());
		}
		return closest;
	}
}

class Star {

	int x;
	int y;
	int z;

	public Star(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double distance() {
		return Math.sqrt(x * x + y * y + x * x);
	}
}