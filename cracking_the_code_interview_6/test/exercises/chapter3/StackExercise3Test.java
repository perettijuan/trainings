package exercises.chapter3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exercises.chapter3.StackExercise3.SetOfStacks;

public class StackExercise3Test {

	/*
	 * In => A -> B -> C -> D -> E -> F -> G -> H -> I -> J -> K -> L -> M -> N S0 =
	 * E -> D -> C -> B -> A S1 = J -> I -> H -> G -> F S2 = N -> M -> L -> K
	 * 
	 * Output => N -> M -> L -> K -> J -> I -> H -> G -> F -> E -> D -> C -> B -> A
	 */
	@Test
	public void shouldReturnInProperOrder() {
		SetOfStacks<String> subject = new SetOfStacks<>(5);
		subject.push("A");
		subject.push("B");
		subject.push("C");
		subject.push("D");
		subject.push("E");
		subject.push("F");
		subject.push("G");
		subject.push("H");
		subject.push("I");
		subject.push("J");
		subject.push("K");
		subject.push("L");
		subject.push("M");
		subject.push("N");

		String[] expected = new String[] { "N", "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A" };
		String[] actual = new String[14];

		for (int i = 0; i < actual.length; i++) {
			actual[i] = subject.pop();
		}

		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}
	
	/**
	 * In => A -> B -> /pop/ C -> D -> E -> F -> G -> H -> I -> J -> K -> L -> M -> N 
	 * 		S0 = F -> E -> D -> C -> A 
	 * 		S1 = K -> J -> I -> H -> G 
	 * 		S2 = N -> M -> L
	 * Output => N -> M -> L -> K -> J -> I -> H -> G -> F -> E -> D -> C -> A
	 */
	@Test
	public void testPopAndThenPushAgain() {
		SetOfStacks<String> subject = new SetOfStacks<>(5);
		subject.push("A");
		subject.push("B");
		
		String pop = subject.pop();
		assertEquals("B", pop);
		
		subject.push("C");
		subject.push("D");
		subject.push("E");
		subject.push("F");
		subject.push("G");
		subject.push("H");
		subject.push("I");
		subject.push("J");
		subject.push("K");
		subject.push("L");
		subject.push("M");
		subject.push("N");

		String[] expected = new String[] { "N", "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "A" };
		String[] actual = new String[13];

		for (int i = 0; i < actual.length; i++) {
			actual[i] = subject.pop();
		}

		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}
	
	/**
	 * In => A -> B -> /pop/ C -> D -> E -> F -> /pop/ G -> H -> I -> J -> K -> L -> M -> N 
	 * 		S0 = F -> E -> D -> C -> A 
	 * 		S1 = L -> K -> J -> I -> H  
	 * 		S2 = N -> M 
	 * Output => N -> M -> K -> J -> I -> H -> G -> F -> E -> D -> C -> A
	 */
	@Test
	public void testPopAndThenPushAgain1() {
		SetOfStacks<String> subject = new SetOfStacks<>(5);
		subject.push("A");
		subject.push("B");
		
		String pop = subject.pop();
		assertEquals("B", pop);
		
		subject.push("C");
		subject.push("D");
		subject.push("E");
		subject.push("F");
		subject.push("G");
		
		pop = subject.pop();
		assertEquals("G", pop);
		
		subject.push("H");
		subject.push("I");
		subject.push("J");
		subject.push("K");
		subject.push("L");
		subject.push("M");
		subject.push("N");

		String[] expected = new String[] { "N", "M", "L", "K", "J", "I", "H", "F", "E", "D", "C", "A" };
		String[] actual = new String[12];

		for (int i = 0; i < actual.length; i++) {
			actual[i] = subject.pop();
		}

		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}
	
	/**
	 * In => A -> B -> C -> D -> E -> /pop/ F -> G -> H -> I -> J -> K -> L -> M -> N 		
	 * Output => N -> M -> L -> K -> J -> I -> H -> G  -> E -> D -> C -> B -> A
	 */
	@Test
	public void testPopAndThenPushAgain2() {
		SetOfStacks<String> subject = new SetOfStacks<>(5);
		subject.push("A");
		subject.push("B");	
		subject.push("C");
		subject.push("D");
		subject.push("E");
		subject.push("F");
		
		String pop = subject.pop();
		assertEquals("F", pop);
		
		subject.push("G");
		subject.push("H");
		subject.push("I");
		subject.push("J");
		subject.push("K");
		subject.push("L");
		subject.push("M");
		subject.push("N");

		String[] expected = new String[] { "N", "M", "L", "K", "J", "I", "H", "G", "E", "D", "C", "B", "A" };
		String[] actual = new String[13];

		for (int i = 0; i < actual.length; i++) {
			actual[i] = subject.pop();
		}

		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}

}
