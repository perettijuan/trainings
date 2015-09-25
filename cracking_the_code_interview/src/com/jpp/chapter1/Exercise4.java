package com.jpp.chapter1;

public class Exercise4 {

	/*
	 * Write a method to decide if two strings are anagrams or not.
	 */

	public static boolean areAnagrams(char[] str1, char[] str2) {

		// Check for null
		if (str1 == null || str2 == null) {
			return false;
		}

		// Check size
		if (str1.length != str2.length) {
			return false;
		}

		for (int i = 0; i < str1.length; i++) {
			if (!isLetterPresent(str1[i], str2)) {
				return false;
			}
		}

		return true;
	}

	private static boolean isLetterPresent(char letter, char[] str) {
		// single return point
		boolean isPresent = false;
		for (int i = 0; i < str.length; i++) {
			if (letter == str[i]) {
				isPresent = true;
				break;
			}
		}
		return isPresent;
	}

}
