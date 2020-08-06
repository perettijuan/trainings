package hackerrank.challenges;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import hackerrank.challenges.MToLastElement;
import hackerrank.challenges.MToLastElement.KNode;

public class MToLastElementTest {

	/*
	 * M = 2
	 * List = 5 2 1 8
	 * O = 1
	 */
	@Test
	public void test1() {
		List<Integer> input = new ArrayList<Integer>();
		input.add(5);
		input.add(2);
		input.add(1);
		input.add(8);
		
		KNode head = listFrom(input);
		
		int expected = 1;
		int m = 2;
		
		int actual = MToLastElement.findMToLastelement(head, m); 
		
		assertEquals(expected, actual);
	}
	
	/*
	 * M = 4
	 * List = 10 200 3 40000 5
	 * O = 200
	 */
	@Test
	public void test2() {
		List<Integer> input = new ArrayList<Integer>();
		input.add(10);
		input.add(200);
		input.add(3);
		input.add(40000);
		input.add(5);
		
		KNode head = listFrom(input);
		
		int expected = 200;
		int m = 4;
		
		int actual = MToLastElement.findMToLastelement(head, m); 
		
		assertEquals(expected, actual);
	}
	
	
	/*
	 * M = 2
	 * List = 42
	 * O = Nil
	 */
	@Test
	public void test3() {
		List<Integer> input = new ArrayList<Integer>();
		input.add(42);
		
		KNode head = listFrom(input);
		
		int expected = -1;
		int m = 2;
		
		int actual = MToLastElement.findMToLastelement(head, m); 
		
		assertEquals(expected, actual);
	}
	
	/*
	 * M = 2
	 * List = 42
	 * O = Nil
	 */
	@Test
	public void test4() {
		List<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(7);
		input.add(6);
		
		KNode head = listFrom(input);
		
		int expected = 1;
		int m = 3;
		
		int actual = MToLastElement.findMToLastelement(head, m); 
		
		assertEquals(expected, actual);
	}
	
	/*
	 * M = 7
	 * List = 1 7 6 5 8 3 10 87 1000 76
	 * O = 6
	 */
	@Test
	public void test5() {
		List<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(7);
		input.add(6);
		input.add(5);
		input.add(8);
		input.add(3);
		input.add(10);
		input.add(87);
		input.add(1000);
		input.add(76);
		
		KNode head = listFrom(input);
		
		int expected = 5;
		int m = 7;
		
		int actual = MToLastElement.findMToLastelement(head, m); 
		
		assertEquals(expected, actual);
	}
	
	/*
	 * M = 1
	 * List = 1 7 6 5 8 3 10 87 1000 76
	 * O = 76
	 */
	@Test
	public void test6() {
		List<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(7);
		input.add(6);
		input.add(5);
		input.add(8);
		input.add(3);
		input.add(10);
		input.add(87);
		input.add(1000);
		input.add(76);
		
		KNode head = listFrom(input);
		
		int expected = 76;
		int m = 1;
		
		int actual = MToLastElement.findMToLastelement(head, m); 
		
		assertEquals(expected, actual);
	}
	
	
	private KNode listFrom(List<Integer> input) {
		KNode head = new KNode(input.get(0));
		KNode current = head;
		for (int i = 1; i < input.size(); i++) {
			if (current == null) {
				break;
			}
			current.mNext = new KNode(input.get(i));
			current = current.mNext;
		}
		return head;
	}
}
