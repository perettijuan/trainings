package hackerrank.problemsolving;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TimeInWordsTest {
	
	@Test
	public void test() {
		String expected = "twenty nine minutes past seven";
		String actual = TimeInWords.timeInWords(5, 45);
		
		assertEquals(expected, actual);
		
	}

}
