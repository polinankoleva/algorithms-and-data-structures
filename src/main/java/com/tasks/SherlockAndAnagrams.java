package com.tasks;

import java.util.Scanner;

public class SherlockAndAnagrams {

	// Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
    	int pairs = 0;
    	for (int i = 0; i < s.length() - 1; i++) {
    		for (int j = i+1; j < s.length(); j++) {
				String current = s.substring(i, j);
				pairs += findAllSimilarSubstring(current, s.substring(i+1));
			}
		}
    	return pairs;
    }

    public static int findAllSimilarSubstring(String searched, String text) {
    	String temp = text.replace(searched, "");
    	int occ = (text.length() - temp.length()) / searched.length();
    	return occ;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            System.out.println(String.valueOf(result));
            System.out.println();
        }
        scanner.close();
    }

}
