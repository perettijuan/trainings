package hackerrank.challenges;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BalancedDelimitersTest {

	@Test
	public void test1() {
		String input = "([()])";
		assertTrue(BalancedDelimiters.isBalanced(input));
	}
	
}
