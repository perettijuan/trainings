package exercises.chapter2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LinkedLists5Test {

	// Input = (7 -> 1 -> 6) + (5 -> 9 -> 2)
	// Output = 2 -> 1 -> 9
	@Test
	public void test1() {
		test(new int[] { 7, 1, 6 }, new int[] { 5, 9, 2 }, new int[] { 2, 1, 9 });
	}

	// Input = (5 -> 2 -> 8) + (2 -> 3 -> 4)
	// Output = 7 -> 5 -> 2 -> 1
	@Test
	public void test2() {
		test(new int[] { 5, 2, 8 }, new int[] { 2, 3, 4 }, new int[] { 7, 5, 2, 1 });
	}

	// Input = (5 -> 2 -> 8) + (7 -> 9 -> 4)
	// Output = 2 -> 2 -> 3 -> 1
	@Test
	public void test3() {
		test(new int[] { 5, 2, 8 }, new int[] { 7, 9, 4 }, new int[] { 2, 2, 3, 1 });
	}

	// Input = (5 -> 2 -> 8 -> 9) + (7 -> 9 -> 4 -> 9) // 9825 + 9497
	// Output = 2 -> 2 -> 3 -> 9 -> 1 // 19322
	@Test
	public void test4() {
		test(new int[] { 5, 2, 8, 9 }, new int[] { 7, 9, 4, 9 }, new int[] { 2, 2, 3, 9, 1 });
	}

	private void test(int[] sum1, int[] sum2, int[] out) {
		Node<Integer> input1 = LinkedListExtras.produceLinkedListFrom(sum1);
		Node<Integer> input2 = LinkedListExtras.produceLinkedListFrom(sum2);
		Node<Integer> expected = LinkedListExtras.produceLinkedListFrom(out);

		Node<Integer> actual = LinkedLists5.sumNumbers(input1, input2);

		assertEquals(expected, actual);
		Node<Integer> currentExpected = expected;
		Node<Integer> currentActual = actual;
		while (currentExpected != null && actual != null) {		
			assertEquals(currentExpected, currentActual);
			currentExpected = currentExpected.getNext();
			currentActual = currentActual.getNext();
		}
	}

}
