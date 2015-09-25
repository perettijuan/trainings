package com.string;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		System.out.println("_______BINARY SEARCH_______");
		int[] array = new int[] {1,2,3,4,5,6,7,8,9,10};
		int lower = 2;
		int upper = 8;
		int target = 3;
		int index = performBinarySearch(array, lower, upper, target);
		System.out.println("INDEX -> " + index);
	}
	
	private static int performBinarySearch(int[] array, int lower, int upper,
			int target) {
		int index = -1;

		int middle = array.length / 2;
		int middleValue = array[middle];

		if (middleValue == target) {
			return middle;
		} else if (lower < middleValue && upper < middleValue) {
			int[] sub = Arrays.copyOfRange(array, 0, middle);
			return performBinarySearch(sub, lower, upper, target);
		} else if (lower > middleValue && middleValue < upper) {
			int[] sub = Arrays.copyOfRange(array, middle, array.length);
			return performBinarySearch(sub, lower, upper, target);
		} else {
			for (int i = 0; i < array.length; i++) {
				if (array[i] == target) {
					return i;
				}
			}
		}

		return index;
	}

}
