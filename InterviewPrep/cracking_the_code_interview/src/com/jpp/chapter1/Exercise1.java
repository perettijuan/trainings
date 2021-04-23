package com.jpp.chapter1;

public class Exercise1 {

	/*
	 * Implement an algorithm to determine if a string has all unique
	 * characters. What if you can not use additional data structures?
	 * 
	 * RESULT: O(n2)
	 */

	static boolean hasDuplicatesString(String s) {
		if (s == null) {
			return false;
		}

		char[] array = s.toCharArray();
		return hasDuplicates(array);
	}

	static boolean hasDuplicates(char[] s) {
		// local variable to have only one return point
		boolean hasDuplicates = false;

		// Check for null and array size
		if (s != null && s.length > 0) {

			// array size
			int size = s.length;
			// local variable to contain the current value
			char current;
			// iterate the entire String
			for (int i = 0; i < size; i++) {
				current = s[i];
				// second iteration
				for (int j = i + 1; j < size; j++) {
					if (current == s[j]) {
						// found a duplicated! -> break the loop
						hasDuplicates = true;
						break;
					}
				}

				// check if any duplicates has been found to break the outer
				// loop
				if (hasDuplicates) {
					break;
				}
			}
		}
		return hasDuplicates;
	}

}
