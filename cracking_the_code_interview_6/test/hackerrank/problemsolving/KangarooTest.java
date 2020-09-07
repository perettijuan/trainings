package hackerrank.problemsolving;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KangarooTest {

	@Test 
	public void test1() {
		String expected = "NO";
		String actual = Kangaroo.kangaroo(0, 2, 5, 3);
		
		assertEquals(expected, actual);
	}
	
}
