package com.jpp.chapter2;

public class Exercise1 {

	public static Node<String> removeDuplicates(Node<String> root) {

		if (root == null) {
			return null;
		}

		if (root.next() == null) {
			return root;
		}

		Node<String> current = root;
		while (current != null) {
			String data = current.getData();
			Node<String> next = current.next();
			// 2nd round
			next = deleteNode(next, data);
			current.setNext(next);
			current = current.next();
		}

		return root;
	}

	private static Node<String> deleteNode(Node<String> root, String data) {
		if (root == null || data == null) {
			return null;
		}

		if (data.equals(root.getData())) {
			return root.next();
		}

		Node<String> current = root;
		while (current.next() != null) {
			if (data.equals(current.next().getData())) {
				Node<String> newNext = current.next().next();
				current.setNext(newNext);
			}
			current = current.next();
		}

		return root;
	}

}
