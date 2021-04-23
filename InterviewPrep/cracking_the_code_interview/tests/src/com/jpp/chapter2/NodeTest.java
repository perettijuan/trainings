package com.jpp.chapter2;

import junit.framework.Assert;

import org.junit.Test;

public class NodeTest {

	@Test
	public void addToTail() {
		Node<String> root = new Node<String>("first");
		Node<String> second = root.addToTail("second");
		Node<String> third = second.addToTail("third");
		Node<String> last = third.addToTail("last");
		Assert.assertEquals(second, root.next());
		Assert.assertEquals(third, second.next());
		Assert.assertEquals(last, third.next());		
	}
	
	
	@Test
	public void deleteNode() {
		Node<String> root = new Node<String>("first");
		Node<String> second = root.addToTail("second");
		Node<String> third = second.addToTail("third");
		Node<String> last = third.addToTail("last");
		
		root.deleteNode(root, "third");
		
		Assert.assertEquals(second, root.next());
		Assert.assertEquals(last, second.next());
	}

}
