package com.jpp.chapter3;

import junit.framework.Assert;

import org.junit.Test;

public class MultiStackTests {
	
	
	@Test
	public void pushAnPop() {
		MultiStack<String> stack = new MultiStack<String>(0);
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		stack.push("5");
		stack.push("6");
		stack.push("7");
		stack.push("8");
		stack.push("9");
		stack.push("10");
		stack.push("11");
		stack.push("12");

		Assert.assertEquals(3, stack.mStackCount());
		
		Assert.assertEquals("12", stack.pop());
		Assert.assertEquals("11", stack.pop());
		Assert.assertEquals("10", stack.pop());
		Assert.assertEquals("9", stack.pop());
		
		
		Assert.assertEquals("8", stack.pop());
		Assert.assertEquals("7", stack.pop());
		Assert.assertEquals("6", stack.pop());
		Assert.assertEquals("5", stack.pop());
		Assert.assertEquals(2, stack.mStackCount());
		
		Assert.assertEquals("4", stack.pop());
		Assert.assertEquals("3", stack.pop());
		Assert.assertEquals("2", stack.pop());
		Assert.assertEquals("1", stack.pop());
		Assert.assertEquals(1, stack.mStackCount());
		
		Assert.assertNull(stack.pop());
	}

}
