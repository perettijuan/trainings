package com.jpp.chapter2;

public class Exercise3 {

	/*
	 * Implement an algorithm to delete a node in the middle of a single linked
	 * list, given only access to that node. EXAMPLE Input: the node ‘c’ from
	 * the linked list a->b->c->d->e Result: nothing is returned, but the new
	 * linked list looks like a->b->d->e
	 */

	public static void deleteNode(Node<String> node) {
		if (node == null) {
			return;
		}

		// Check if is tail
		if(node.next() == null) {
			node.setData(null);
			return;
		}
		
		Node<String> current = node;
		Node<String> next = current.next();
		while (current != null) {
			current.setData(next.getData());
			if (next.next() == null) {
				current.setNext(null);
				break;
			}
			current = next;
			next = current.next();
		}
	}
}
