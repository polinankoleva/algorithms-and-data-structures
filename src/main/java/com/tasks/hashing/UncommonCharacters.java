package com.tasks.hashing;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class UncommonCharacters {
    public static void uncommonChars(String str1, String str2) {
    	// store all unique chars of str1
    	HashSet<Character> s1Letters = new HashSet<>();
    	char[] str1Letters = str1.toCharArray();
    	for(int i = 0; i < str1Letters.length; i++) {
    		s1Letters.add(str1Letters[i]);
    	}
    	HashSet<Character> s2Letters = new HashSet<>();
    	char[] str2Letters = str2.toCharArray();
    	for(int i = 0; i < str2Letters.length; i++) {
    		s2Letters.add(str2Letters[i]);
    	}
    	HashSet<Character> toBeRemoved = new HashSet<>();
    	s2Letters.forEach(v -> {
    		if(s1Letters.contains(v)) {
    			toBeRemoved.add(v);
    		}
    	});
    	s1Letters.removeAll(toBeRemoved);
    	s2Letters.removeAll(toBeRemoved);
    	s1Letters.addAll(s2Letters);
    	Character[] foundUncommonLetters = s1Letters.stream().toArray(Character[]::new);
    	Arrays.sort(foundUncommonLetters);
    	for(int i = 0 ; i < foundUncommonLetters.length; i ++) {
    		System.out.print(foundUncommonLetters[i]);
    	}
    }
    
    private static final Scanner in = new Scanner(System.in);
    
	public static void main(String[] args) {
		int testCases = in.nextInt();
		for (int i = 0; i < testCases; i++) {
			String str1 = in.next();
			String str2 = in.next();
			uncommonChars(str1, str2);
		}

	}
}
