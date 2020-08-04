package hackerrank.sorting;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class CheckerTest {
	
	@Test
	public void test1() {
		Player[] unsorted = new Player[] {
				new Player("Smith", 20),
				new Player("Jones", 15),
				new Player("Jones", 20)
		};
		
		Player[] expected = new Player[] {
				new Player("Jones", 20),
				new Player("Smith", 20),
				new Player("Jones", 15)				
		};
		
		
		Arrays.sort(unsorted, new Checker());
		
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i].name, unsorted[i].name);
			assertEquals(expected[i].score, unsorted[i].score);
		}
	}
	
	
	@Test
	public void test2() {
		Player[] unsorted = new Player[] {
				new Player("Jones", 20),
				new Player("Asange", 30),
				new Player("Jonesi", 20)
		};
		
		Player[] expected = new Player[] {
				new Player("Asange", 30),
				new Player("Jones", 20),
				new Player("Jonesi", 20)				
		};
		
		
		Arrays.sort(unsorted, new Checker());
		
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i].name, unsorted[i].name);
			assertEquals(expected[i].score, unsorted[i].score);
		}
	}
	

	@Test
	public void test3() {
		Player[] unsorted = new Player[] {
				new Player("b", 3), //b 3
				new Player("a", 1), //a 1
				new Player("bb", 3), // bb 3
				new Player("b", 8), //b 8
				new Player("bba", 0), // bba 0
				new Player("bb", 2), // bb 2
				new Player("bca", 6), // bca 6
				new Player("ccc", 4), // ccc 4
				new Player("b", 3), // b 3
				new Player("ab", 8), // ab 8
				new Player("bb", 3), // bb 3
				new Player("bb", 7), // bb 7
				new Player("ccb", 8), // ccb 8
				new Player("bbb", 2), // bbb 2
				new Player("aab", 8), // aab 8
				new Player("b", 6), // b 6
				new Player("ab", 8), // ab 8
				new Player("cb", 9), // cb 9
				new Player("cbb", 8), // cbb 8
				new Player("ba", 9) // ba 9
		};
		
		Player[] expected = new Player[] {
				new Player("ba", 9),
				new Player("cb", 9),
				new Player("aab", 8),
				new Player("ab", 8),
				new Player("ab", 8),
				new Player("b", 8),
				new Player("cbb", 8),
				new Player("ccb", 8),
				new Player("bb", 7),
				new Player("b", 6),
				new Player("bca", 6),
				new Player("ccc", 4),
				new Player("b", 3),
				new Player("b", 3),
				new Player("bb", 3),
				new Player("bb", 3),
				new Player("bb", 2),
				new Player("bbb", 2),
				new Player("a", 1),
				new Player("bba", 0)
		};
		
		
		Arrays.sort(unsorted, new Checker());
		
		for (int i = 0; i < expected.length; i++) {
			Player expectedP = expected[i];
			Player actualP = unsorted[i];
			
			System.out.println("Comparing " + expectedP.toString());
			System.out.println(" with " + actualP.toString());
			
			assertEquals(expectedP.name, actualP.name);
			assertEquals(expectedP.score, actualP.score);
		}
	}
	


}
