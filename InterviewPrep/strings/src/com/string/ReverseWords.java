package com.string;

import java.util.Stack;

public class ReverseWords {

	public static void main(String[] args) {
		System.out.println("_______REVERSE WORDS_______");
		String src = "Do or do not, there is no try.";
		System.out.println("ORIGINAL -> " + src);
		String processed = reverseWords(src);
		System.out.println("PROCESSED -> " + processed);
	}

	private static String reverseWords(String src) {
		assert src != null : "SRC can not be null";

		char[] original = src.toCharArray();
		Stack<String> stack = new Stack<String>();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < original.length; i++) {
			char c = original[i];
			if (c == ' ' || i == original.length -1) {
				sb.append(c);
				stack.push(sb.toString());
				sb.setLength(0);				
			} else {
				sb.append(c);
			}
		}

		sb = new StringBuilder();
		while (!stack.isEmpty()) {
			String current = stack.pop();
			sb.append(current);
		}

		return sb.toString();
	}

}
