package com.tasks;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * {@linkplain https://www.hackerrank.com/challenges/frequency-queries/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps}
 * 
 * @author Polina Koleva
 *
 */
public class FrequencyQueries {

	// Complete the freqQuery function below.
	static List<Integer> freqQuery(List<List<Integer>> queries) {
		List<Integer> result = new ArrayList<>();
		// key - integer value, value - its frequency
		HashMap<Integer, Integer> valueFreq = new HashMap<>();
		// key - frequency, value - how many values have such frequency
		HashMap<Integer, Integer> frequencies = new HashMap<>();
		for (List<Integer> pair : queries) {
			Integer action = pair.get(0);
			Integer value = pair.get(1);
			if (action == 3) {
				// check existence
				if (frequencies.get(value) != null) {
					result.add(1);
				} else {
					result.add(0);
				}
			} else {
				Integer oldFrequency = valueFreq.get(value);
				oldFrequency = oldFrequency == null ? 0 : oldFrequency;
				Integer oldFrequenceValues = frequencies.get(oldFrequency);
				oldFrequenceValues = oldFrequenceValues == null ? 0 : oldFrequenceValues;
				Integer newFrequency = null;
				if (action == 1) {
					newFrequency = oldFrequency + 1;
				} else {
					newFrequency = oldFrequency - 1;
				}
				Integer newFrequenceValues = frequencies.get(newFrequency);
				newFrequenceValues = newFrequenceValues == null ? 0 : newFrequenceValues;

				// update valueFreq
				if (newFrequency <= 0) {
					valueFreq.remove(value);
				} else {
					valueFreq.put(value, newFrequency);
				}

				// update frequencies
				// decrease number of values with old frequency
				if (oldFrequenceValues - 1 < 1) {
					frequencies.remove(oldFrequency);
				} else {
					frequencies.put(oldFrequency, oldFrequenceValues - 1);
				}
				// increase number of values with new frequency
				frequencies.put(newFrequency, newFrequenceValues + 1);
			}
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int q = Integer.parseInt(scanner.next());

		List<List<Integer>> queries = new ArrayList<>();

		IntStream.range(0, q).forEach(i -> {
			queries.add(Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
					.collect(toList()));
		});

		List<Integer> ans = freqQuery(queries);

		System.out.println(ans.stream().map(Object::toString).collect(joining("\n")));
	}
}
