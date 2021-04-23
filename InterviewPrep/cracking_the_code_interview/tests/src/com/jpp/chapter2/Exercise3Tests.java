package com.jpp.chapter2;

import junit.framework.Assert;

import org.junit.Test;

public class Exercise3Tests {
	
	
	@Test
	public void deleteC() {
		Node<String> a = new Node<String>("A");
		Node<String> b = a.addToTail("B");
		Node<String> c = b.addToTail("C");
		Node<String> d = c.addToTail("D");
		Node<String> e = d.addToTail("E");
		
		printList("enters", a);
		Exercise3.deleteNode(c);
		printList("exits", a);
		
		Assert.assertEquals("D", b.next().getData());
		Assert.assertEquals("E", c.next().getData());
		Assert.assertNull(e.next());		
	}
	
	
	@Test
	public void deleteRoot() {
		Node<String> a = new Node<String>("A");
		Node<String> b = a.addToTail("B");
		Node<String> c = b.addToTail("C");
		Node<String> d = c.addToTail("D");
		Node<String> e = d.addToTail("E");
		
		printList("enters", a);
		Exercise3.deleteNode(a);
		printList("exits", a);
		
		Assert.assertEquals("B", a.getData());
		Assert.assertEquals("C", b.getData());
		Assert.assertEquals("D", c.getData());
		Assert.assertEquals("E", d.getData());
		Assert.assertNull(e.next());		
	}
	
	
	@Test
	public void deleteLast() {
		Node<String> a = new Node<String>("A");
		Node<String> b = a.addToTail("B");
		Node<String> c = b.addToTail("C");
		Node<String> d = c.addToTail("D");
		Node<String> e = d.addToTail("E");
		
		printList("enters", a);
		Exercise3.deleteNode(e);
		printList("exits", a);
		
		Assert.assertEquals("A", a.getData());
		Assert.assertEquals("B", b.getData());
		Assert.assertEquals("C", c.getData());
		Assert.assertEquals("D", d.getData());
		Assert.assertNull(e.getData());		
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
