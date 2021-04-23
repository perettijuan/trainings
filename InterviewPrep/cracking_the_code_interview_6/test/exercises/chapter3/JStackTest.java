package exercises.chapter3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JStackTest {

	// Input = A -> C -> D -> F -> B
	// Out = B -> F -> D -> C -> A
	@Test
	public void shouldReturnInProperOrder() {
		JStack<String> stack = new JStack<>();
		stack.push("A");
		stack.push("C");
		stack.push("D");
		stack.push("F");
		stack.push("B");

		String[] expected = new String[] { "B", "F", "D", "C", "A" };
		String[] actual = new String[5];
		
		for (int i = 0; i < actual.length; i++) {
			actual[i] = stack.pop();
		}
		
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}

	
	@Test
	public void testPopAndThenPushAgain() {
		JStack<String> stack = new JStack<>();
		stack.push("A");
		stack.push("C");
		
		assertEquals("C", stack.pop());
		
		stack.push("D");
		stack.push("F");
		stack.push("B");
		
		String[] expected = new String[] { "B", "F", "D", "A" };
		String[] actual = new String[4];
		
		for (int i = 0; i < actual.length; i++) {
			actual[i] = stack.pop();
		}
		
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}
}
