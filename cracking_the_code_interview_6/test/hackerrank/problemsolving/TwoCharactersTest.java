package hackerrank.problemsolving;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class TwoCharactersTest {
	
	@Test
	public void test1() {
		String s = "beabeefeab";
		int expected = 5;
		
		int actual = TwoCharacters.alternate(s);
		
		assertEquals(expected, actual);		
	}
	
	
//	@Test 
//	public void testIsValid() {
//		assertTrue(TwoCharacters.isValid('b', 'd',"bdbd"));
//	}

}
