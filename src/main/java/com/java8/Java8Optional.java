package com.java8;

import java.util.Optional;

public class Java8Optional {

	public static void main(String[] args) {
		Integer value1 = null;
		Integer value2 = new Integer(10);
		Java8Optional optionalTester = new Java8Optional();
		Optional<Integer> a = Optional.ofNullable(value1);
		Optional<Integer> b = Optional.of(value2);
		System.out.println(optionalTester.sum(a, b));
		System.out.println(optionalTester.sum(b, a));
	}

	public Integer sum(Optional<Integer> a, Optional<Integer> b) {
		// Optional.isPresent - checks the value is present or not

		System.out.println("First parameter is present: " + a.isPresent());
		System.out.println("Second parameter is present: " + b.isPresent());

		// Optional.orElse - returns the value if present otherwise returns
		// the default value passed.
		Integer value1 = a.orElse(new Integer(0));

		// Optional.get - gets the value, value should be present
		Integer value2 = b.get();
		return value1 + value2;
	}
}
