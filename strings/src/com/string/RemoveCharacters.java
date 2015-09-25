package com.string;

import java.util.Hashtable;

public class RemoveCharacters {

	public static void main(String[] args) {
		System.out.println("_______REMOVE SPECIAL CHARACTERS_______");
		String src = "thisistheoriginal";
		System.out.println("ORIGINAL -> " + src);
		String rmv = "oiae";
		System.out.println("TO REMOVE -> " + rmv);
		String processed = removeChars(src, rmv);
		System.out.println("PROCESSED -> " + processed);
	}

	/**
	 * <p>
	 * Change both Strings to char arrays
	 * </p>
	 * <p>
	 * Create a HashTable<Character, Boolean> to hold all the remove characters
	 * </p>
	 * <p>
	 * Traverse remove and put each element in the HashTable
	 * </p>
	 * <p>
	 * Traverse src and check if the character is in the HashTable. If it is,
	 * remove it.
	 * </p>
	 */
	private static String removeChars(String src, String rmv) {
		assert src != null : "SRC can not be null";
		assert rmv != null : "remove can not be null";

		char[] original = src.toCharArray();
		char[] remove = rmv.toCharArray();

		StringBuilder sb = new StringBuilder();
		Hashtable<Character, Boolean> ht = new Hashtable<Character, Boolean>();

		for (char c : remove) {
			ht.put(c, true);
		}

		for (char c : original) {
			if (!ht.containsKey(c)) {
				sb.append(c);
			}
		}

		return sb.toString();
	}
}
