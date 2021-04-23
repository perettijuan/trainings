package com.jpp.chapter2;

import junit.framework.Assert;

import org.junit.Test;

public class Exercise1Tests {

	@Test
	public void deleteOnlyOneDuplicate() {
		Node<String> root = new Node<String>("first");
		Node<String> second = root.addToTail("second");
		Node<String> third = second.addToTail("third");
		Node<String> duplicated = third.addToTail("second");
		Node<String> last = duplicated.addToTail("last");
		printList("enters", root);
		root = Exercise1.removeDuplicates(root);
		printList("exits", root);
		Assert.assertEquals(second, root.next());
		Assert.assertEquals(third, second.next());
		Assert.assertEquals(last, third.next());
	}

	@Test
	public void deleteNoDuplicate() {
		Node<String> root = new Node<String>("first");
		Node<String> second = root.addToTail("second");
		Node<String> third = second.addToTail("third");
		Node<String> last = third.addToTail("last");
		printList("enters", root);
		root = Exercise1.removeDuplicates(root);
		printList("exits", root);
		Assert.assertEquals(second, root.next());
		Assert.assertEquals(third, second.next());
		Assert.assertEquals(last, third.next());
	}

	@Test
	public void deleteTwoDuplicate() {
		Node<String> root = new Node<String>("first");
		Node<String> second = root.addToTail("second");
		Node<String> third = second.addToTail("third");
		Node<String> duplicated = third.addToTail("second");
		Node<String> fourth = duplicated.addToTail("third");
		Node<String> last = fourth.addToTail("last");

		printList("enters", root);
		root = Exercise1.removeDuplicates(root);
		printList("exits", root);

		Assert.assertEquals(second, root.next());
		Assert.assertEquals(third, second.next());
		Assert.assertEquals(last, third.next());
	}

	private void printList(String header, Node<String> root) {
		System.out.println(header);
		System.out.println("{");
		Node<String> current = root;
		while (current != null) {
			String data = current.getData();
			if (current.next() != null) {
				data += ", ";
			}
			System.out.println(data);
			current = current.next();
		}

		System.out.println("}");
	}

}
