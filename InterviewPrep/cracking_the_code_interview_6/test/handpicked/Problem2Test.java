package handpicked;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Problem2Test {

	@Test
	public void test1() {
		String s= "423692";
		String keypad = "923857614";
		int expected = 8;
		int actual = Problem2.timeToInput(s, keypad);
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test2() {
		String s= "44444";
		String keypad = "923857614";
		int expected = 0;
		int actual = Problem2.timeToInput(s, keypad);
		
		assertEquals(expected, actual);
	}
	
	

	
	@Test
	public void test4() {
		String s= "91566165";
		String keypad = "639485712";
		int expected =11;
		int actual = Problem2.timeToInput(s, keypad);
		
		assertEquals(expected, actual);
	}
}
