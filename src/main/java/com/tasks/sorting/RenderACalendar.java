package com.tasks.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Write a program that takes a set of events, and determines the maximum number
 * of events that take place concurrently.
 * 
 * Task 14.4, EPI book
 * 
 * @author Polina Koleva
 *
 */
public class RenderACalendar {
	public static int findMaximumSimultaneousEvent(List<Event> events) {
		int maxEvents = 0;
		List<EndPoint> endpoints = new ArrayList<>();
		for (Event event : events) {
			endpoints.add(new EndPoint(event.start, true));
			endpoints.add(new EndPoint(event.end, false));
		}
		Collections.sort(endpoints);
		int currentEvents = 0;
		for (EndPoint e : endpoints) {
			if(e.isStart) {
				currentEvents++;
				maxEvents = Math.max(maxEvents, currentEvents);
			} else {
				currentEvents--;
			}
		}
		return maxEvents;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

class Event {
	int start;
	int end;

	public Event(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

class EndPoint implements Comparable<EndPoint> {
	int time;
	boolean isStart;

	public EndPoint(int time, boolean isStart) {
		this.time = time;
		this.isStart = isStart;
	}

	@Override
	public int compareTo(EndPoint e) {
		if (e.time == this.time) {
			if (e.isStart && !this.isStart) {
				return 1;
			} else if (!e.isStart && this.isStart) {
				return -1;
			} else {
				return 0;
			}
		} else {
			return this.time - e.time;
		}
	}
}