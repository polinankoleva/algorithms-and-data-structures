package com.tasks.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Consider a foreman responsible for a number of tasks on the factory floor.
 * Each task starts at a fixed time and ends at a fixed time. The foreman wants
 * to visit the floor to check on the tasks. Your job is to help him minimize
 * the number of visits he makes. In each visit, he can check on all the tasks
 * taking place at the time of the visit. A visit takes place at a fixed time,
 * and he can only check on tasks taking place at exactly that time. For
 * example, if there are tasks at times [0, 3], [2, 6], [3, 4], [6, 9], then
 * visit times 0, 2, 3, 6 cover all tasks. A smaller set of visit times that
 * also cover all tasks is 3, 6. You are given a set of closed intervals. Design
 * an efficient algorithm for finding a minimum sized set of numbers that covers
 * all the intervals. Task 18.3. EPI book
 * 
 * @author Polina Koleva
 *
 */
public class IntervalCoveringProblem {

	public static List<Integer> findMinSet(ArrayList<Interval> intervals) {
		List<Integer> timePoints = new ArrayList<>();
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.end - i2.end;
			}
		});
		for (int i = 0; i < intervals.size(); i++) {
			Interval current = intervals.get(i);
			timePoints.add(current.end);
			int j = i+1;
			while(j < intervals.size()) {
				Interval next = intervals.get(j);
				if(next.start<= current.end && next.end >= current.end) {
					j++;
				} else {
					break;
				}
			}
			i = j -1;
		}
		return timePoints;
	}
	
	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(2, 3));
		intervals.add(new Interval(3, 4));
		intervals.add(new Interval(2, 3));
		intervals.add(new Interval(3, 4));
		intervals.add(new Interval(4, 5));
		List<Integer> timePoints = findMinSet(intervals);
		timePoints.forEach(i -> System.out.println(i));
		
	}}
class Interval {
	int start;
	int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
