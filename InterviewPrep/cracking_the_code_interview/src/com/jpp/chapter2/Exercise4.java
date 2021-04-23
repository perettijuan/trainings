package com.jpp.chapter2;

public class Exercise4 {

	/*
	 * You have two numbers represented by a linked list, where each node
	 * contains a single digit. The digits are stored in reverse order, such
	 * that the 1’s digit is at the head of the list. Write a function that adds
	 * the two numbers and returns the sum as a linked list. EXAMPLE Input: (3
	 * -> 1 -> 5) + (5 -> 9 -> 2) Output: 8 -> 0 -> 8
	 */

	public static Node<Integer> sum(Node<Integer> n1, Node<Integer> n2,
			int carry) {

		if (n1 == null && n2 == null) {
			return null;
		}

		int v1 = 0;
		int v2 = 0;
		if (n1 != null) {
			v1 = n1.getData();
		}

		if (n2 != null) {
			v2 = n2.getData();
		}

		int result = v1 + v2 + carry;

		// Carry
		if (result >= 10) {
			carry = 1;
		}

		Node<Integer> resultNode = new Node<Integer>(result % 10);

		// Recursive add
		Node<Integer> more = sum(n1 != null ? n1.next() : null,
				n2 != null ? n2.next() : null, carry);
		if (more != null) {
			resultNode.setNext(more);
		}

		return resultNode;
	}

}
