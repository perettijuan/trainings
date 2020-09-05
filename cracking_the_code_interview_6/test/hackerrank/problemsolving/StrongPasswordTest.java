package hackerrank.problemsolving;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StrongPasswordTest {
	
	@Test
	public void test1() {
		int n = 4;
		String password = "goxg";
		int expected = 3;
		
		int actual = StrongPassword.minimumNumber(n, password);
		
		assertEquals(expected, actual);
		
	}

}
