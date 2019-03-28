package com.java8;

import java.util.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorting {

	public static void main(String args[]) {
		List<String> names1 = new ArrayList<String>();
		names1.add("Mahesh ");
		names1.add("Suresh ");
		names1.add("Ramesh ");
		names1.add("Naresh ");
		names1.add("Kalpesh ");

		List<String> names2 = new ArrayList<String>();
		names2.add("Mahesh ");
		names2.add("Suresh ");
		names2.add("Ramesh ");
		names2.add("Naresh ");
		names2.add("Kalpesh ");

		System.out.println("Sort using Java 7 syntax: ");

		sortUsingJava7(names1);
		System.out.println(names1);
		System.out.println("Sort using Java 8 syntax: ");

		sortUsingJava8(names2);
		System.out.println(names2);

		List<Integer> values1 = new ArrayList<Integer>();
		values1.add(1);
		values1.add(2);
		values1.add(3);
		values1.add(4);
		values1.add(5);
		values1.add(5);

		List<Integer> values2 = new ArrayList<Integer>();
		values2.add(1);
		values2.add(2);
		values2.add(3);
		values2.add(4);
		values2.add(5);
		values2.add(5);

		List<Point> points1 = new ArrayList<Point>();
		points1.add(new Point(1, 1));
		points1.add(new Point(1, 3));
		points1.add(new Point(4, 1));
		points1.add(new Point(1, 8));
		points1.add(new Point(10, 3));
		points1.add(new Point(3, 3));

		List<Point> points2 = new ArrayList<Point>();
		points2.add(new Point(1, 1));
		points2.add(new Point(1, 3));
		points2.add(new Point(4, 1));
		points2.add(new Point(1, 8));
		points2.add(new Point(10, 3));
		points2.add(new Point(3, 3));

		System.out.println("Sort using Java 7 syntax: ");

		sortDESCUsingJava7(points1);
		points1.forEach(p1 -> System.out.print(p1.distance + " "));

		System.out.println("Sort using Java 8 syntax: ");
		sortDESCUsingJava8(points2);
		points2.forEach(p2 -> System.out.print(p2.distance + " "));
	}

	private static void sortUsingJava7(List<String> names) {
		names.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
	}

	private static void sortUsingJava8(List<String> names) {
		Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
	}

	private static void sortASCUsingJava7(List<Integer> values) {
		values.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				if (i1 < i2) {
					return -1;
				} else if (i1 > i2) {
					return 1;
				}
				return 0;
			}
		});
	}

	private static void sortASCUsingJava8(List<Integer> values) {
		// values.sort(Comparator.naturalOrder());
		Collections.sort(values, (i1, i2) -> {
			if (i1 < i2)
				return -1;
			else if (i2 > i1)
				return 1;
			return 0;
		});
	}

	// private static void sortDESCUsingJava7(List<Integer> values) {
	// values.sort(new Comparator<Integer>() {
	// @Override
	// public int compare(Integer i1, Integer i2) {
	// if (i2 < i1)
	// return -1;
	// if (i2 > i1)
	// return 1;
	// return 0;
	// }
	// });
	// }
	//
	// private static void sortDESCUsingJava8(List<Integer> values) {
	// values.sort((i1, i2) -> {
	// if (i2 < i1)
	// return -1;
	// if (i2 > i1)
	// return 1;
	// else
	// return 0;
	// });
	// }
	//
	private static void sortDESCUsingJava7(List<Point> points) {
		points.sort(new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				if (p2.distance < p1.distance)
					return -1;
				if (p2.distance > p1.distance)
					return 1;
				return 0;
			}
		});
	}

	private static void sortDESCUsingJava8(List<Point> points) {
		points.sort((p1, p2) -> {
			if (p2.distance < p1.distance)
				return -1;
			if (p2.distance > p1.distance)
				return 1;
			return 0;
		});

		// points.sort(Comparator.comparingDouble(Point::getDistance).reversed());
	}
}

class Point {
	int x;
	int y;
	// distance to the start point (0,0)
	double distance;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		this.distance = calculateDistance(x, y);
	}

	public double getDistance() {
		return this.distance;
	}

	public double calculateDistance(int x, int y) {
		return Math.sqrt(x * x + y * y);
	}

	@Override
	public boolean equals(Object p) {
		if (p == null)
			return false;
		if (this == p)
			return true;
		if (!(p instanceof Point))
			return false;
		Point casted = (Point) p;
		return this.x == casted.x && this.y == casted.y;
	}
}
