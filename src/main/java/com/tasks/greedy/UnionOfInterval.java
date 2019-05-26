package com.tasks.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Design an algorithm that takes as input a set of intervals, and outputs their
 * union expressed as a set of disjoint intervals. Task 14.6, EPI book
 * 
 * @author Polina Koleva
 *
 */
public class UnionOfInterval {

	public static List<InnerInterval> union(List<InnerInterval> intervals) {
		List<InnerInterval> result = new ArrayList<InnerInterval>();
		Collections.sort(intervals);
		for (int i = 0; i < intervals.size(); i++) {
			InnerInterval current = intervals.get(i);
			InnerInterval toBeAdded = new InnerInterval(current.start, current.isStartInclusive, current.end,
					current.isEndInclusive);
			// merge until possible
			for (int j = i + 1; j < intervals.size(); j++) {
				if (toBeAdded.end > intervals.get(j).start || (toBeAdded.end == intervals.get(j).start
						&& (toBeAdded.isEndInclusive || intervals.get(j).isStartInclusive))) {
					// merge both interval and continue
					if (toBeAdded.end < intervals.get(j).end) {
						toBeAdded.end = intervals.get(j).end;
						toBeAdded.isEndInclusive = intervals.get(j).isEndInclusive;
					} else if (toBeAdded.end == intervals.get(j).end) {
						toBeAdded.isEndInclusive = (toBeAdded.isEndInclusive || intervals.get(j).isEndInclusive);
					}
				} else {
					i = j - 1;
					break;
				}
			}
			result.add(toBeAdded);
		}
		return result;
	}

	public static void main(String[] args) {
		List<InnerInterval> input = new ArrayList<>();
		InnerInterval i = new InnerInterval(0, true, 0, true);
		input.add(i);
		InnerInterval j = new InnerInterval(0, false, 3, true);
		input.add(j);
		InnerInterval p = new InnerInterval(2, true, 4, false);
		input.add(p);
		InnerInterval q = new InnerInterval(3, true, 4, false);
		input.add(q);
		InnerInterval z = new InnerInterval(5, false, 7, false);
		input.add(z);
		List<InnerInterval> result = union(input);
		for (InnerInterval in : result) {
			System.out.print(in.isStartInclusive ? "[" : "(");
			System.out.print(in.start + ", " + in.end);
			System.out.print(in.isEndInclusive ? "]" : ")");
		}
	}
}

class InnerInterval implements Comparable<InnerInterval> {
	int start;
	boolean isStartInclusive;
	int end;
	boolean isEndInclusive;

	public InnerInterval(int start, int end) {
		this.start = start;
		this.isStartInclusive = true;
		this.end = end;
		this.isEndInclusive = true;
	}

	public InnerInterval(int start, boolean isStartInclusive, int end, boolean isEndInclusive) {
		this.start = start;
		this.isStartInclusive = isStartInclusive;
		this.end = end;
		this.isEndInclusive = isEndInclusive;
	}

	@Override
	public int compareTo(InnerInterval i) {
		if (this.start == i.start) {
			// return first the inclusive of the start
			if (this.isStartInclusive) {
				return -1;
			} else if (i.isStartInclusive) {
				return 1;
			} else {
				if (this.isEndInclusive) {
					return -1;
				} else if (i.isEndInclusive) {
					return 1;
				}
				return 0;
			}
		}
		return this.start - i.start;
	}
}