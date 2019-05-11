package com.tasks.greedy;

import java.util.Arrays;

/**
 * We consider the problem of assigning tasks to workers. Each worker must be
 * assigned exactly two tasks. Each task takes a fixed amount of time. Tasks are
 * independent, i.e., there are no constraints of the form "Task 4 cannot start
 * before Task 3 is completed." Any task can be assigned to any worker. We want
 * to assign tasks to workers so as to minimize how long it takes before all
 * tasks are completed. For example, if there are 6 tasks whose durations are 5,
 * 2, 1, 6, 4, 4 hours, then an optimum assignment is to give the first two
 * tasks (i.e., the tasks with duration 5 and 2) to one worker, the next two (1
 * and 6) to another worker, and the last two tasks (4 and 4) to the last
 * worker. For this assignment, all tasks will finish after max(5 + 2, 1 + 6, 4
 * + 4) = 8 hours Task 18.1. EPI book
 * 
 * @author Polina Koleva
 *
 */
public class TaskAssignment {

	public static int taskAssignment(int[] tasks) {
		// no tasks available
		if (tasks.length == 0)
			return -1;
		// not even tasks for each worker
		if (tasks.length % 2 != 0)
			return -1;
		Arrays.sort(tasks);
		int minDuration = Integer.MIN_VALUE;
		for (int i = 0; i < tasks.length / 2; i++) {
			int localDuration = tasks[i] + tasks[tasks.length - 1 - i];
			minDuration = Math.max(minDuration, localDuration);
		}
		return minDuration;
	}

	public static void main(String[] args) {
		// expected 8
		int[] tasks = new int[] { 5, 2, 1, 6, 4, 4 };
		System.out.println(taskAssignment(tasks));
		// expected -1
		tasks = new int[] { 5, 2, 1, 6, 4 };
		System.out.println(taskAssignment(tasks));
		// no tasks available , expected -1
		tasks = new int[] {};
		System.out.println(taskAssignment(tasks));
		// expected 2
		tasks = new int[] { 1, 1, 1, 1 };
		System.out.println(taskAssignment(tasks));
	}
}
