package com.jpp.chapter2;

public class Exercise2 {

	public static Node<String> findNthToLast(Node<String> root, int nth) {

		if (root == null) {
			return null;
		}

		if (nth == 0) {
			// from the first to the last
			return root;
		}

		int index = 0;
		Node<String> current = root;
		Node<String> newRoot = null;

		while (current != null) {
			if (index == nth) {
				// found the nth element, make it the new root
				newRoot = current;
				break;
			}
			current = current.next();
			index++;
		}

		if (newRoot != null) {
			root = newRoot;
		}

		return root;
	}

}
