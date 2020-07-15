package exercises.chapter2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LinkedLists1Test {

	// Input = 1 -> 2 -> 5 -> 8 -> 2 -> 7
	// Output = 1 -> 2 -> 5 -> 8 -> 7
	@Test
	public void test1() {
		test(new int[] { 1, 2, 5, 8, 2, 7 }, new int[] { 1, 2, 5, 8, 7 });
	}

	/*
	 * Input = 1 -> 2 -> 5 -> 8 -> 2 -> 7 -> 5 -> 6
	 * Output = 1 -> 2 -> 5 -> 8 -> 7 -> 6
	 */
	@Test
	public void test2() {
		test(new int[] { 1, 2, 5, 8, 2, 7, 5, 6}, new int[] { 1, 2, 5, 8, 7, 6});
	}
	
	/*
	 * Input = 1 -> 2 -> 5 -> 8 -> 2
	 * Output = 1 -> 2 -> 5 -> 8
	 */
	@Test
	public void test3() {
		test(new int[] { 1, 2, 5, 8, 2, 7, 5, 6}, new int[] { 1, 2, 5, 8, 7, 6});
	}
	
	/*
	 * Input = 1 -> 1 -> 1 -> 8 -> 2 -> 7 -> 5 -> 6
	 * Output = 1 -> 8 -> 7 -> 6
	 */
	@Test
	public void test4() {
		test(new int[] { 1, 2, 5, 8, 2, 7, 5, 6}, new int[] { 1, 2, 5, 8, 7, 6});
	}


	private void test(int[] in, int[] out) {
		Node<Integer> input = produceLinkedListFrom(in);
		Node<Integer> expected = produceLinkedListFrom(out);

		Node<Integer> actual = LinkedLists1.removeDuplicates(input);

		assertEquals(expected, actual);
		Node<Integer> currentExpected = expected;
		Node<Integer> currentActual = actual;
		while (currentExpected != null && actual != null) {
			System.out.println("Comparing value =>" + currentExpected.getValue());
			System.out.println("With value =>" + currentActual.getValue());
			assertEquals(currentExpected, currentActual);
			currentExpected = currentExpected.getNext();
			currentActual = currentActual.getNext();
		}
	}

	private Node<Integer> produceLinkedListFrom(int[] list) {
		Node<Integer> head = new Node<Integer>(list[0]);
		Node<Integer> current = head;
		for (int i = 1; i < list.length; i++) {
			if (current == null) {
				break;
			}
			current.setNext(new Node<Integer>(list[i]));
			current = current.getNext();
		}

		return head;
	}

}
