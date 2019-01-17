package com.tasks.arrays;

public class ArrayRotation {

	// rotate an array of size n by d elements
	// O(d) auxiliary space, O(n) time complexity
	public static int[] rotate1(int[] arr, int d) {
		if (d > arr.length) {
			throw new IllegalArgumentException();
		}
		int[] reversedPart = new int[d];
		for (int i = 0; i < arr.length; i++) {
			if (i < d) {
				reversedPart[i] = arr[i];
			} else {
				arr[i - d] = arr[i];
			}
		}
		for (int i = 0; i < reversedPart.length; i++) {
			arr[arr.length - d + i] = reversedPart[i];
		}
		return arr;
	}

	// rotate an array of size n by d elements
	// rotate one by one, leftRotate
	// no auxiliary space, time complexity o(d*n)
	public static int[] rotate2(int[] arr, int d) {
		for (int i = 0; i < d; i++) {
			leftRotate(arr);
		}
		return arr;
	}

	// Rotate the array by one from left to right
	public static void leftRotate(int[] arr) {
		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			arr[i - 1] = arr[i];
		}
		arr[arr.length - 1] = temp;
	}

	// the juggling algorithm
	// TODO implement
	public static int[] rotate3(int[] arr, int d) {
		return arr;
	}

	// the reverse algorithm
	// time complexity O(n), no additional space
	public static int[] rotate4(int[] arr, int d) {
		// reverse arr[1:d]
		reverse(arr, 0, d);
		// reverse arr[d+1, arr.lenght]
		reverse(arr, d+1, arr.length);
		reverse(arr, 0, arr.length);
		return arr;
	}
	
	public static int[] reverse(int[] arr, int beginning, int end) {
		for (int i = beginning; i < beginning + (end-beginning) / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[end-i + beginning - 1];
			arr[end - i + beginning-1] = temp;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] answer = rotate4(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 2);
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

}
