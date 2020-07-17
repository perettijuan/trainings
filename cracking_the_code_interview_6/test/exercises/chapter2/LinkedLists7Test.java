package exercises.chapter2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class LinkedLists7Test {

	/*
	 * Input: 
	 * List1 => 1 -> 3 -> 6 -> 7 -> 20 -> 5 
	 * List2 => 2 -> 4 -> 8 -> 5 -> 12 -> 13 
	 * Intersection Node = 5
	 */
	@Test
	public void test1() {
		Node<Integer> intersect = new Node<Integer>(5);
		
		// yeah, not the most stylish way to do it, but it works for now
		Node<Integer> input1 = new Node<Integer>(1);
		input1.setNext(new Node<Integer>(3));
		input1.getNext().setNext(new Node<Integer>(6));
		input1.getNext().getNext().setNext(new Node<Integer>(7));
		input1.getNext().getNext().getNext().setNext(new Node<Integer>(20));
		input1.getNext().getNext().getNext().getNext().setNext(new Node<Integer>(5));
		
		Node<Integer> input2 = new Node<Integer>(2);
		input2.setNext(new Node<Integer>(4));
		input2.getNext().setNext(new Node<Integer>(8));
		input2.getNext().getNext().setNext(new Node<Integer>(5));
		input2.getNext().getNext().getNext().setNext(new Node<Integer>(12));
		input2.getNext().getNext().getNext().getNext().setNext(new Node<Integer>(13));
		
		Node<Integer> obtained = LinkedLists7.findIntersection(input1, input2);
		
		assertEquals(intersect.getValue(), obtained.getValue());		
	}
	
	
	/*
	 * Input: 
	 * List1 => 1 -> 3 -> 6 -> 7 -> 20 -> 5 
	 * List2 => 2 -> 1 -> 8 -> 5 -> 12 -> 13 
	 * Intersection Node = 1
	 */
	@Test
	public void test2() {
		Node<Integer> intersect = new Node<Integer>(1);
		
		// yeah, not the most stylish way to do it, but it works for now
		Node<Integer> input1 = new Node<Integer>(1);
		input1.setNext(new Node<Integer>(3));
		input1.getNext().setNext(new Node<Integer>(6));
		input1.getNext().getNext().setNext(new Node<Integer>(7));
		input1.getNext().getNext().getNext().setNext(new Node<Integer>(20));
		input1.getNext().getNext().getNext().getNext().setNext(new Node<Integer>(5));
		
		Node<Integer> input2 = new Node<Integer>(2);
		input2.setNext(new Node<Integer>(1));
		input2.getNext().setNext(new Node<Integer>(8));
		input2.getNext().getNext().setNext(new Node<Integer>(5));
		input2.getNext().getNext().getNext().setNext(new Node<Integer>(12));
		input2.getNext().getNext().getNext().getNext().setNext(new Node<Integer>(13));
		
		Node<Integer> obtained = LinkedLists7.findIntersection(input1, input2);
		
		assertEquals(intersect.getValue(), obtained.getValue());		
	}
	
	
	/*
	 * Input: 
	 * List1 => 1 -> 3 -> 6 -> 7 -> 20 -> 10 
	 * List2 => 2 -> 4 -> 8 -> 5 -> 12 -> 13 
	 * Intersection Node = 1
	 */
	@Test
	public void test3() {	
		// yeah, not the most stylish way to do it, but it works for now
		Node<Integer> input1 = new Node<Integer>(1);
		input1.setNext(new Node<Integer>(3));
		input1.getNext().setNext(new Node<Integer>(6));
		input1.getNext().getNext().setNext(new Node<Integer>(7));
		input1.getNext().getNext().getNext().setNext(new Node<Integer>(20));
		input1.getNext().getNext().getNext().getNext().setNext(new Node<Integer>(10));
		
		Node<Integer> input2 = new Node<Integer>(2);
		input2.setNext(new Node<Integer>(4));
		input2.getNext().setNext(new Node<Integer>(8));
		input2.getNext().getNext().setNext(new Node<Integer>(5));
		input2.getNext().getNext().getNext().setNext(new Node<Integer>(12));
		input2.getNext().getNext().getNext().getNext().setNext(new Node<Integer>(13));
		
		Node<Integer> obtained = LinkedLists7.findIntersection(input1, input2);
		
		assertNull(obtained);		
	}
	
	
	/*
	 * Input: 
	 * List1 => 1 -> 3 -> 6 -> 7 -> 20 -> 5 
	 * List2 => 2 -> 4 -> 8 -> 5 -> 12 -> 13 
	 * Intersection Node = 5
	 */
	@Test
	public void test11() {
		Node<Integer> intersect = new Node<Integer>(5);
		
		// yeah, not the most stylish way to do it, but it works for now
		Node<Integer> input1 = new Node<Integer>(1);
		input1.setNext(new Node<Integer>(3));
		input1.getNext().setNext(new Node<Integer>(6));
		input1.getNext().getNext().setNext(new Node<Integer>(7));
		input1.getNext().getNext().getNext().setNext(new Node<Integer>(20));
		input1.getNext().getNext().getNext().getNext().setNext(new Node<Integer>(5));
		
		Node<Integer> input2 = new Node<Integer>(2);
		input2.setNext(new Node<Integer>(4));
		input2.getNext().setNext(new Node<Integer>(8));
		input2.getNext().getNext().setNext(new Node<Integer>(5));
		input2.getNext().getNext().getNext().setNext(new Node<Integer>(12));
		input2.getNext().getNext().getNext().getNext().setNext(new Node<Integer>(13));
		
		Node<Integer> obtained = LinkedLists7.findIntersectionImproved(input1, input2);
		
		assertEquals(intersect.getValue(), obtained.getValue());		
	}
	
	/*
	 * Input: 
	 * List1 => 1 -> 3 -> 6 -> 7 -> 20 -> 5 
	 * List2 => 2 -> 1 -> 8 -> 5 -> 12 -> 13 
	 * Intersection Node = 1
	 */
	@Test
	public void test12() {
		Node<Integer> intersect = new Node<Integer>(1);
		
		// yeah, not the most stylish way to do it, but it works for now
		Node<Integer> input1 = new Node<Integer>(1);
		input1.setNext(new Node<Integer>(3));
		input1.getNext().setNext(new Node<Integer>(6));
		input1.getNext().getNext().setNext(new Node<Integer>(7));
		input1.getNext().getNext().getNext().setNext(new Node<Integer>(20));
		input1.getNext().getNext().getNext().getNext().setNext(new Node<Integer>(5));
		
		Node<Integer> input2 = new Node<Integer>(2);
		input2.setNext(new Node<Integer>(1));
		input2.getNext().setNext(new Node<Integer>(8));
		input2.getNext().getNext().setNext(new Node<Integer>(5));
		input2.getNext().getNext().getNext().setNext(new Node<Integer>(12));
		input2.getNext().getNext().getNext().getNext().setNext(new Node<Integer>(13));
		
		Node<Integer> obtained = LinkedLists7.findIntersectionImproved(input1, input2);
		
		assertEquals(intersect.getValue(), obtained.getValue());		
	}

	/*
	 * Input: 
	 * List1 => 1 -> 3 -> 6 -> 7 -> 20 -> 10 
	 * List2 => 2 -> 4 -> 8 -> 5 -> 12 -> 13 
	 * Intersection Node = 1
	 */
	@Test
	public void test13() {	
		// yeah, not the most stylish way to do it, but it works for now
		Node<Integer> input1 = new Node<Integer>(1);
		input1.setNext(new Node<Integer>(3));
		input1.getNext().setNext(new Node<Integer>(6));
		input1.getNext().getNext().setNext(new Node<Integer>(7));
		input1.getNext().getNext().getNext().setNext(new Node<Integer>(20));
		input1.getNext().getNext().getNext().getNext().setNext(new Node<Integer>(10));
		
		Node<Integer> input2 = new Node<Integer>(2);
		input2.setNext(new Node<Integer>(4));
		input2.getNext().setNext(new Node<Integer>(8));
		input2.getNext().getNext().setNext(new Node<Integer>(5));
		input2.getNext().getNext().getNext().setNext(new Node<Integer>(12));
		input2.getNext().getNext().getNext().getNext().setNext(new Node<Integer>(13));
		
		Node<Integer> obtained = LinkedLists7.findIntersectionImproved(input1, input2);
		
		assertNull(obtained);		
	}

}
