package com.jpp.chapter1;

public class Exercise3 {

	/*
	 * Design an algorithm and write code to remove the duplicate characters in
	 * a string without using any additional buffer. NOTE: One or two additional
	 * variables are fine. An extra copy of the array is not. FOLLOW UP Write
	 * the test cases for this method.
	 */

	public static void removeDuplicates(char[] s) {

		int tail = 1;
		for (int i = 0; i < s.length; i++) {
			int j;
			for (j = 0; j < tail; j++) {
				if (s[i] == s[j]) {
					break;
				}
			}
			if (j == tail) {
				s[tail] = s[i];
				++tail;
			}
		}
		s[tail] = ' ';
	}

}
