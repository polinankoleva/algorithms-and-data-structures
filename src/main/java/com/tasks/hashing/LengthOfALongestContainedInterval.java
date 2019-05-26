package com.tasks.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Write a program which takes as input a set of integers represented by an
 * array, and returns the size of a largest subset of integers in the array
 * having the property that if two integers are in the subset, then so are all
 * integers between them. For example, if the input is (3, -2, 7, 9, 8, 1,2,0,
 * -1,5,8), the largest such subset is {-2, -1,0, 1,2,3), so you should return
 * 6. Task 13.10, EPI book
 * 
 * @author Polina Koleva
 *
 */
public class LengthOfALongestContainedInterval {

	public static int longestContainedInterval(int[] nums) {
		int max = 0;
		// create frequency map
		HashMap<Integer, Integer> numbersFreq = new HashMap<>();
		for(int i : nums) {
			if(numbersFreq.get(i) != null) {
				numbersFreq.put(i, numbersFreq.get(i) + 1);
			} else {
				numbersFreq.put(i, 1);
			}
		}
		while(!numbersFreq.isEmpty()) {
			HashSet<Integer> keysToRemove = new HashSet<>();
			int length = 1;
			for(Map.Entry<Integer, Integer> entry : numbersFreq.entrySet()) {
				keysToRemove.add(entry.getKey());
				int i = 1;
				while(numbersFreq.containsKey(entry.getKey() - i)) {
					length += numbersFreq.get(entry.getKey() - i);
					i++;
					keysToRemove.add(entry.getKey() - i);
				}
				i = 1;
				while(numbersFreq.containsKey(entry.getKey() + i)) {
					length += numbersFreq.get(entry.getKey() + i);
					i++;
					keysToRemove.add(entry.getKey() + i);
				}
				max = Math.max(length, max);
				break;
			}
			// remove needed keys
			for(Integer key : keysToRemove) {
				numbersFreq.remove((Integer) key);
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(longestContainedInterval(new int[] {3,-2,7,9,8,1,2,0,-1,5,8}));
	}
}
