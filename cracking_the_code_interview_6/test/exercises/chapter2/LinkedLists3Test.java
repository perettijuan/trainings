package exercises.chapter2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LinkedLists3Test {

	// Input = 3 in 1 -> 2 -> 3 -> 4 -> 5
	// Output = 1 -> 2 -> 4 -> 5
	@Test
	public void test1() {
		Node<Integer> one = new Node<Integer>(1);
		Node<Integer> two = new Node<Integer>(2);
		Node<Integer> three = new Node<Integer>(3);
		Node<Integer> four = new Node<Integer>(4);
		Node<Integer> five = new Node<Integer>(5);

		one.setNext(two);
		two.setNext(three);
		three.setNext(four);
		four.setNext(five);

		LinkedLists3.deleteNodeInMiddle(three);

		assertEquals(two, one.getNext());
		assertEquals(four, two.getNext());
		assertEquals(five, four.getNext());
	}

	// Input = 4 in 1 -> 2 -> 3 -> 4 -> 5
	// Output = 1 -> 2 -> 3 -> 5
	@Test
	public void test2() {
		Node<Integer> one = new Node<Integer>(1);
		Node<Integer> two = new Node<Integer>(2);
		Node<Integer> three = new Node<Integer>(3);
		Node<Integer> four = new Node<Integer>(4);
		Node<Integer> five = new Node<Integer>(5);

		one.setNext(two);
		two.setNext(three);
		three.setNext(four);
		four.setNext(five);

		LinkedLists3.deleteNodeInMiddle(four);

		assertEquals(two, one.getNext());
		assertEquals(three, two.getNext());
		assertEquals(five, three.getNext());
	}

	// Input = 2 in 1 -> 2 -> 3 -> 4 -> 5
	// Output = 1 -> 3 -> 4 -> 5
	@Test
	public void test3() {
		Node<Integer> one = new Node<Integer>(1);
		Node<Integer> two = new Node<Integer>(2);
		Node<Integer> three = new Node<Integer>(3);
		Node<Integer> four = new Node<Integer>(4);
		Node<Integer> five = new Node<Integer>(5);

		one.setNext(two);
		two.setNext(three);
		three.setNext(four);
		four.setNext(five);

		LinkedLists3.deleteNodeInMiddle(two);

		assertEquals(three, one.getNext());
		assertEquals(four, three.getNext());
		assertEquals(five, four.getNext());
	}

	// Input = 2 in 1 -> 2 -> 3
	// Output = 1 -> 3
	@Test
	public void test4() {
		Node<Integer> one = new Node<Integer>(1);
		Node<Integer> two = new Node<Integer>(2);
		Node<Integer> three = new Node<Integer>(3);

		one.setNext(two);
		two.setNext(three);

		LinkedLists3.deleteNodeInMiddle(two);

		assertEquals(three, one.getNext());
	}

}
