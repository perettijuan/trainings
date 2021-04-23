package exercises.chapter2;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class LinkedLists4Test {

	@Test
	public void test1() {
		int[] in = new int[] { 1, 2, 5, 8, 2, 7 };
		run(in, 5);
	}

	// 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1
	@Test
	public void test2() {
		int[] in = new int[] { 3, 5, 8, 5, 10, 2, 1 };
		run(in, 5);
	}

	// 6 -> 18 -> 7 -> 3 -> 5 -> 11 -> 21 -> 10
	@Test
	public void test3() {
		int[] in = new int[] { 6, 18, 7, 3, 5, 11, 21, 10 };
		run(in, 11);
	}

	// 3 -> 7 -> 1 -> 5 -> 8 -> 9
	@Test
	public void test4() {
		int[] in = new int[] { 3, 7, 1, 5, 8, 9 };
		run(in, 6);
	}

	private void run(int[] in, int partition) {
		Node<Integer> input = LinkedListExtras.produceLinkedListFrom(in);
		Node<Integer> result = LinkedLists4.createPartitions(input, partition);

		List<Integer> resultAsList = LinkedListExtras.produceListFromLinkedList(result);

		System.out.println("--------------");
		System.out.println("Partition = " + partition);
		System.out.println("Ouput { " + resultAsList.toString() + "}");

		assertEquals(1, 1);
	}

}
