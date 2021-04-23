package com.interviewcake;

import java.util.Hashtable;

/**
 * Given 2 integer arrays, determine of the 2nd array is a rotated version of
 * the 1st array. Ex. Original Array A={1,2,3,5,6,7,8} Rotated Array
 * B={5,6,7,8,1,2,3}
 */
public class RotatedVectors {

	public static void main(String[] args) {
		int[] A = new int[] { 1, 2, 3, 5, 6, 7, 8 };
		int[] B = new int[] { 5, 6, 7, 8, 1, 2, 3 };

		boolean isRotated = isRotatedVersion(A, B);

		System.out.println(" 1 IS ROTATED => " + isRotated);

		A = new int[] { 1, 2, 3, 5, 6, 7, 8 };
		B = new int[] { 1, 2, 3, 5, 6, 7, 8 };

		isRotated = isRotatedVersion(A, B);

		System.out.println(" IS ROTATED (EQUALS) => " + isRotated);
		
		
		A = new int[] { 1, 2, 3, 5, 6, 7, 8 };
		B = new int[] { 1, 2, 3, 5, 6, 7, 9 };

		isRotated = isRotatedVersion(A, B);

		System.out.println(" IS ROTATED (NO) => " + isRotated);
	}

	private static boolean isRotatedVersion(int[] A, int[] B) {

		if (A == null || B == null) {
			return false;
		}

		if (A.length != B.length) {
			return false;
		}

		// 1 - Create a HashMap to hold A[i] and A[i+1]
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();

		boolean equals = false;

		// 2 - Iterate over A and set the values to the table
		for (int i = 0; i < A.length; i++) {
			int j = i + 1;

			equals = A[i] == B[i]; // 1

			// if it is the end of A, then put A[i] and A[0]
			if (i == (A.length - 1)) {
				ht.put(A[i], A[0]); // 2
			} else {
				ht.put(A[i], A[j]); // 3
			}
		}

		if (equals) {
			return false;
		}

		// 3 - Iterate over B and check if B[i] is in HT
		for (int i = 0; i < B.length; i++) {

			int j = i + 1;

			// if the value is in the table, then compare the next one
			if (ht.containsKey(B[i])) { // 4 - O(1)

				// check for the end of B
				if (i == (B.length - 1)) {
					if (B[0] != ht.get(B[i])) { // 5
						return false;
					}
				} else {
					if (B[j] != ht.get(B[i])) { // 6
						return false;
					}
				}

			} else {
				// if not, means that the arrays are different
				return false;
			}
		}

		return true;
	}
}
