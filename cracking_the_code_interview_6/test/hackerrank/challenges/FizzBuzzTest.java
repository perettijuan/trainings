package hackerrank.challenges;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FizzBuzzTest {
	
	@Test
	public void testDivisible() {
		assertTrue(FizzBuzz.isDivisible(9, 3));
		assertTrue(FizzBuzz.isDivisible(15, 5));
		assertTrue(FizzBuzz.isDivisible(15, 3));
		
		
		assertFalse(FizzBuzz.isDivisible(8, 3));
		assertFalse(FizzBuzz.isDivisible(9, 5));
	}

}
