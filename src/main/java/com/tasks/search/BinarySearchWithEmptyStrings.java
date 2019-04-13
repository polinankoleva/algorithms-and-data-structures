package com.tasks.search;

/**
 * Given a sorted array of strings that is interspersed with empty strings,
 * write a method to find the location of a given string.
 * 
 * @author Polina Koleva
 *
 */
public class BinarySearchWithEmptyStrings {
	public static int binarySearchWithEmtpyStrings(int start, int end, String element, String[] arr) {
		if (start > end)
			return -1;
		int middleIndex = (end - start) / 2 + start;
		String middleElement = arr[middleIndex];
		int comparison = middleElement.compareTo(element);
		if (comparison == 0) {
			return middleIndex;
		} else if (middleElement.isEmpty()) {
			// do binary search of both sides
			int left = binarySearchWithEmtpyStrings(start, middleIndex - 1, element, arr);
			int right = binarySearchWithEmtpyStrings(middleIndex + 1, end, element, arr);
			if (left == right) {
				return left;
			} else if (left != -1) {
				return left;
			} else {
				return right;
			}
		} else if (comparison > 0) {
			// go left
			return binarySearchWithEmtpyStrings(start, middleIndex - 1, element, arr);
		} else if (comparison < 0) {
			// go right
			return binarySearchWithEmtpyStrings(middleIndex + 1, end, element, arr);
		}
		return -1;
	}
	public static int binarySearchWithEmtpyStrings2(int start, int end, String element, String[] arr) {
		if (start > end)
			return -1;
		int middleIndex = (end - start) / 2 + start;
		String middleElement = arr[middleIndex];
		// find fisrt non-empty element
		int leftMiddle = middleIndex - 1;
		int rightMiddle = middleIndex + 1;
		if(middleElement == "") {
			while(leftMiddle >= start || rightMiddle <= end) {
				// check left element for emptiness
				if(leftMiddle >= start && !arr[leftMiddle].equals("")) {
					middleIndex = leftMiddle;
					middleElement = arr[middleIndex];
					break;
				}
				// check right element for emptiness
				if(rightMiddle <= end && !arr[rightMiddle].equals("")) {
					middleIndex = rightMiddle;
					middleElement = arr[middleIndex];
					break;
				}
				rightMiddle++;
				leftMiddle--;
			}
		}
		int comparison = middleElement.compareTo(element);
		if(middleElement.equals("")) {
			return -1;
		} else if (comparison > 0) {
			// go left
			return binarySearchWithEmtpyStrings(start, middleIndex - 1, element, arr);
		} else if (comparison < 0) {
			// go right
			return binarySearchWithEmtpyStrings(middleIndex + 1, end, element, arr);
		}
		return middleIndex;
		
	}
	public static void main(String[] args) {
		String[] arr = new String[] { "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "" };
		System.out.println(binarySearchWithEmtpyStrings2(0, arr.length - 1, "dad", arr));

	}

}
