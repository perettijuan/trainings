package com.jpp.chapter3;

import junit.framework.Assert;

import org.junit.Test;

public class StackTests {

	@Test
	public void pushAnPop() {
		Stack<String> stack = new Stack<String>();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");

		Assert.assertEquals("4", stack.pop());
		Assert.assertEquals("3", stack.pop());
		Assert.assertEquals("2", stack.pop());
		Assert.assertEquals("1", stack.pop());
		Assert.assertNull(stack.pop());
	}

	@Test
	public void popEmpty() {
		Stack<String> stack = new Stack<String>();
		Assert.assertNull(stack.pop());
	}

	@Test
	public void pushAnPopOneValue() {
		Stack<String> stack = new Stack<String>();
		stack.push("1");

		Assert.assertEquals("1", stack.pop());
		Assert.assertNull(stack.pop());
	}
}
