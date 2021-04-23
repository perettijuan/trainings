package com.jpp.chapter2;

import junit.framework.Assert;

import org.junit.Test;

public class Exercise4Tests {

	@Test
	public void addThreeNumbersWithCarry() {

		Node<Integer> a1 = new Node<Integer>(3);
		Node<Integer> a2 = new Node<Integer>(1);
		Node<Integer> a3 = new Node<Integer>(5);
		a1.setNext(a2);
		a2.setNext(a3);
		
		
		Node<Integer> b1 = new Node<Integer>(5);
		Node<Integer> b2 = new Node<Integer>(9);
		Node<Integer> b3 = new Node<Integer>(2);
		b1.setNext(b2);
		b2.setNext(b3);
		
		printList("A", a1);
		printList("B", b1);
		Node<Integer> result = Exercise4.sum(a1, b1, 0);
		printList("RESULT", result);
		
		Assert.assertTrue(8 == result.getData());
		Assert.assertTrue(0 == result.next().getData());
		Assert.assertTrue(8 == result.next().next().getData());;
	}
	
	
	@Test
	public void addThreeNumbersNoCarry() {

		Node<Integer> a1 = new Node<Integer>(3);
		Node<Integer> a2 = new Node<Integer>(1);
		Node<Integer> a3 = new Node<Integer>(5);
		a1.setNext(a2);
		a2.setNext(a3);
		
		
		Node<Integer> b1 = new Node<Integer>(5);
		Node<Integer> b2 = new Node<Integer>(6);
		Node<Integer> b3 = new Node<Integer>(2);
		b1.setNext(b2);
		b2.setNext(b3);
		
		printList("A", a1);
		printList("B", b1);
		Node<Integer> result = Exercise4.sum(a1, b1, 0);
		printList("RESULT", result);
		
		Assert.assertTrue(8 == result.getData());
		Assert.assertTrue(7 == result.next().getData());
		Assert.assertTrue(7 == result.next().next().getData());;
	}
	
	
	
	@Test
	public void addNumbersDifferentLngth() {

		Node<Integer> a1 = new Node<Integer>(3);
		Node<Integer> a2 = new Node<Integer>(1);
		a1.setNext(a2);
		
		
		Node<Integer> b1 = new Node<Integer>(5);
		Node<Integer> b2 = new Node<Integer>(6);
		Node<Integer> b3 = new Node<Integer>(2);
		b1.setNext(b2);
		b2.setNext(b3);
		
		printList("A", a1);
		printList("B", b1);
		Node<Integer> result = Exercise4.sum(a1, b1, 0);
		printList("RESULT", result);
		
		Assert.assertTrue(8 == result.getData());
		Assert.assertTrue(7 == result.next().getData());
		Assert.assertTrue(2 == result.next().next().getData());;
	}

	private void printList(String header, Node<Integer> root) {
		System.out.println(header);
		System.out.println("{");
		Node<Integer> current = root;
		while (current != null) {
			String data = "" + current.getData();
			if (current.next() != null) {
				data += ", ";
			}
			System.out.println(data);
			current = current.next();
		}

		System.out.println("}");
	}

}
