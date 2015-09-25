package com.interviewcake;

import java.util.Hashtable;

/**
 * Find pairs in an integer array whose sum is equal to 10 (bonus: do it in
 * linear time)
 */
public class PairOfNumbers {

	public static void main(String[] args) {
		int[] source = new int[] { 1, 2, 4, 8, 7, 5, 9, 3, 6, 0 };
		findPairOfnumbers(10, source);
	}

	private static void findPairOfnumbers(int sum, int[] source) {
		// Put all the values in a HashTable using the value as hash and the
		// index as value.
		Hashtable<Integer, Integer> values = new Hashtable<Integer, Integer>();
		for (int i = 0; i < source.length; i++) {
			values.put(source[i], i);
		}

		// Traverse the array again
		for (int i = 0; i < source.length; i++) {
			if (values.get(sum - source[i]) != i) {
				System.out.println("The pair " + source[i] + ", "
						+ (sum - source[i]) + " Has SUM " + sum);
			}
		}

	}

}
