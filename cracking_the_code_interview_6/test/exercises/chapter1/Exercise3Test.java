package exercises.chapter1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Exercise3Test {
	
	@Test
	public void test1() {
		String expected = "Mr%20John%20Smith";
		String actual = Exercise3.urlIfy("Mr John Smith " ,13);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		String expected = "My%20airplane";
		String actual = Exercise3.urlIfy("My airplane " ,11);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3() {
		String expected = "NoSpaces";
		String actual = Exercise3.urlIfy("NoSpaces" ,8);
		assertEquals(expected, actual);
	}

}
