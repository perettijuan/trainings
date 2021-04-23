package com.jpp.chapter3;

import junit.framework.Assert;

import org.junit.Test;

public class QueueTests {
	
	@Test 
	public void pushAnPop() {
		Queue<String> queue = new Queue<String>();
		queue.push("1");
		queue.push("2");
		queue.push("3");
		queue.push("4");
		
		Assert.assertEquals("1", queue.pop());
		Assert.assertEquals("2", queue.pop());
		Assert.assertEquals("3", queue.pop());
		Assert.assertEquals("4", queue.pop());
		Assert.assertNull(queue.pop());
	}

	
	
	@Test 
	public void popEmpty() {
		Queue<String> queue = new Queue<String>();				
		Assert.assertNull(queue.pop());
	}
	
	@Test 
	public void pushAnPopOneValue() {
		Queue<String> queue = new Queue<String>();
		queue.push("1");
		
		Assert.assertEquals("1", queue.pop());
		Assert.assertNull(queue.pop());
	}
	
}
