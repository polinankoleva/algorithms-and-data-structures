package com.java8;

import java.util.*;
import java.util.stream.*;

/**
 * Java 8 introduced the concept of stream that lets the developer to process
 * data declaratively and leverage multicore architecture without the need to
 * write any specific code for it.
 *
 */
public class Java8Streams {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		List<String> filtered = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
		filtered.forEach(System.out::println);

		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		List<Integer> greaterThanTen = numbers.stream().map(a -> a * a).filter(a -> (a > 10)).sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		greaterThanTen.forEach(System.out::println);
	}
}
