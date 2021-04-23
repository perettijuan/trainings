package hackerrank.warmup;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GaryTheHickerTest {

	/*
	 * 8, "UDDDUDUU"
	 */
	@Test
	public void test1() {
		int n = 8;
		String s = "UDDDUDUU";
		
		int expected = 1;
		int actual = GaryTheHicker.countingValleys(n, s);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * 10, "DDDUUDUDDD"
	 */
	@Test
	public void test2() {
		int n = 10;
		String s = "DDDUUDUDDD";
		
		int expected = 1;
		int actual = GaryTheHicker.countingValleys(n, s);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * 10, "UDDDUUUDDU"
	 */
	@Test
	public void test3() {
		int n = 10;
		String s = "UDDDUUUDDU";
		
		int expected = 2;
		int actual = GaryTheHicker.countingValleys(n, s);
		
		assertEquals(expected, actual);
	}
}
