package com.jpp.chapter2;

import junit.framework.Assert;

import org.junit.Test;

public class Exercise2Test {

	@Test
	public void findFromThird() {
		Node<String> root = new Node<String>("first");
		Node<String> second = root.addToTail("second");
		Node<String> third = second.addToTail("third");
		Node<String> fourht = third.addToTail("fourth");
		Node<String> fifth = fourht.addToTail("fifth");
		Node<String> sixth = fifth.addToTail("sixth");
		Node<String> seventh = sixth.addToTail("seventh");
		Node<String> eigth = seventh.addToTail("eigth");
		
		printList("enters", root);
		root = Exercise2.findNthToLast(root, 3);
		printList("exits", root);
		
		Assert.assertEquals(root, fourht);
		Assert.assertEquals(root.next(), fifth);
		Assert.assertEquals(root.next().next(), sixth);
		Assert.assertEquals(root.next().next().next(), seventh);
		Assert.assertEquals(root.next().next().next().next(), eigth);		
	}
	
	
	@Test
	public void findFromInvalidIndex() {
		Node<String> root = new Node<String>("first");
		Node<String> second = root.addToTail("second");
		Node<String> third = second.addToTail("third");
		Node<String> fourht = third.addToTail("fourth");
		Node<String> fifth = fourht.addToTail("fifth");
		Node<String> sixth = fifth.addToTail("sixth");
		Node<String> seventh = sixth.addToTail("seventh");
		Node<String> eigth = seventh.addToTail("eigth");
		
		printList("enters", root);
		root = Exercise2.findNthToLast(root, 8);
		printList("exits", root);
		
		Assert.assertEquals(root, root);
		Assert.assertEquals(root.next(), second);
		Assert.assertEquals(root.next().next(), third);
		Assert.assertEquals(root.next().next().next(), fourht);
		Assert.assertEquals(root.next().next().next().next(), fifth);
		Assert.assertEquals(root.next().next().next().next().next(), sixth);
		Assert.assertEquals(root.next().next().next().next().next().next(), seventh);
		Assert.assertEquals(root.next().next().next().next().next().next().next(), eigth);
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
