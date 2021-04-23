package exercises.chapter3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StackExercise5Test {

	/*
	 * INPUT = 3 -> 4 -> 1 -> 5 -> 2 -> 6 -> 7 -> 9 -> 8 -> 10
	 * OUTPUT = 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
	 */
	@Test
	public void test1() {
		JStack<Integer> input = new JStack<Integer>();
		input.push(3);
		input.push(4);
		input.push(1);
		input.push(5);
		input.push(2);
		input.push(6);
		input.push(7);
		input.push(9);
		input.push(8);
		input.push(10);

		JStack<Integer> actual = StackExercise5.sortStack(input);

		int[] expected = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] actualAsArray = new int[10];
		
		for (int i = 0; i < actualAsArray.length; i++) {
			actualAsArray[i] = actual.pop();
		}
		
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actualAsArray[i]);
		}
	}
	
	
	/*
	 * INPUT = 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
	 * OUTPUT = 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
	 */
	@Test
	public void test2() {
		JStack<Integer> input = new JStack<Integer>();
		input.push(10);
		input.push(9);
		input.push(8);
		input.push(7);
		input.push(6);
		input.push(5);
		input.push(4);
		input.push(3);
		input.push(2);
		input.push(1);

		JStack<Integer> actual = StackExercise5.sortStack(input);

		int[] expected = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] actualAsArray = new int[10];
		
		for (int i = 0; i < actualAsArray.length; i++) {
			actualAsArray[i] = actual.pop();
		}
		
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actualAsArray[i]);
		}
	}
	
	/*
	 * INPUT = 10 -> 9 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1
	 * OUTPUT = 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
	 */
	@Test
	public void test3() {
		JStack<Integer> input = new JStack<Integer>();
		input.push(1);
		input.push(2);
		input.push(3);
		input.push(4);
		input.push(5);
		input.push(6);
		input.push(7);
		input.push(8);
		input.push(9);
		input.push(10);

		JStack<Integer> actual = StackExercise5.sortStack(input);

		int[] expected = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] actualAsArray = new int[10];
		
		for (int i = 0; i < actualAsArray.length; i++) {
			actualAsArray[i] = actual.pop();
		}
		
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actualAsArray[i]);
		}
	}
	
	/*
	 * INPUT = 10 -> 9 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> 1
	 * OUTPUT = 1 -> 1-> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
	 */
	@Test
	public void test4() {
		JStack<Integer> input = new JStack<Integer>();
		input.push(1);
		input.push(2);
		input.push(3);
		input.push(4);
		input.push(5);
		input.push(6);
		input.push(7);
		input.push(8);
		input.push(9);
		input.push(10);
		input.push(1);

		JStack<Integer> actual = StackExercise5.sortStack(input);

		int[] expected = new int[] { 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] actualAsArray = new int[11];
		
		for (int i = 0; i < actualAsArray.length; i++) {
			actualAsArray[i] = actual.pop();
		}
		
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actualAsArray[i]);
		}
	}

}
