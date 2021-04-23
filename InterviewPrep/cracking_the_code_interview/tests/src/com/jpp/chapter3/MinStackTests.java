package com.jpp.chapter3;

import junit.framework.Assert;

import org.junit.Test;

public class MinStackTests {

	@Test
	public void pushAnPop() {
		MinStack<String> stack = new MinStack<String>();
		stack.push("aaaaa");
		stack.push("aaaaaaaa");
		stack.push("aaaa");
		stack.push("aaaaaa");

		Assert.assertEquals("aaaa", stack.min());
		Assert.assertEquals("aaaaaa", stack.pop());
		Assert.assertEquals("aaaa", stack.pop());
		Assert.assertEquals("aaaaaaaa", stack.pop());
		Assert.assertEquals("aaaaa", stack.pop());
		Assert.assertNull(stack.pop());
	}
}
