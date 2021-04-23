package exercises.chapter3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JQueueTest {

	// Input = A -> C -> D -> F -> B
	// Out = A -> C -> D -> F -> B
	@Test
	public void shouldReturnInProperOrder() {
		JQueue<String> queue = new JQueue<>();
		queue.add("A");
		queue.add("C");
		queue.add("D");
		queue.add("F");
		queue.add("B");

		String[] expected = new String[] { "A", "C", "D", "F", "B" };
		String[] actual = new String[5];

		for (int i = 0; i < actual.length; i++) {
			actual[i] = queue.remove();
		}

		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}
	
	@Test
	public void testRemoveAndThenAddAgain() {
		JQueue<String> queue = new JQueue<>();
		queue.add("A");
		queue.add("C");
		
		assertEquals("A", queue.remove());
		
		queue.add("D");
		queue.add("F");
		queue.add("B");

		String[] expected = new String[] {"C", "D", "F", "B" };
		String[] actual = new String[4];

		for (int i = 0; i < actual.length; i++) {
			actual[i] = queue.remove();
		}

		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}

}
