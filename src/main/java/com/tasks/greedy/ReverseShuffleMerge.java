package com.tasks.greedy;

import java.util.Scanner;

/**
 * Given a string, A , we define some operations on the string as follows:
 * 
 * a. reverse(A) denotes the string obtained by reversing string A. Example:
 * reverse(abc) = cba
 * 
 * b. shuffle(A) denotes any string that's a permutation of string A. Example:
 * shuffle(god) = [god, gdo, ogd, odg, dgo, dog]
 * 
 * c. merge(A1, A2) denotes any string that's obtained by interspersing the two
 * strings A1 & A2, maintaining the order of characters in both.
 * 
 * Given a string s such that s = merge(reverse(A), shuffle(A)) for some string
 * A, find the lexicographically smallest A.
 * 
 * @author Polina Koleva
 *
 */
public class ReverseShuffleMerge {
	// Complete the reverseShuffleMerge function below.
    static String reverseShuffleMerge(String s) {

		return null;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String s = scanner.nextLine();

        String result = reverseShuffleMerge(s);

        System.out.println(result);
        scanner.close();
    }
}
