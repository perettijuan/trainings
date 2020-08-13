package hackerrank.problemsolving;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EncryptionTest {
	
	@Test
	public void test1() {
		String s  = "if man was meant to stay on the ground god would have given us roots";
		String expected = "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau";
		String actual = Encryption.encryption(s);
		
		System.out.println(expected);
		System.out.println(actual);
		assertEquals(expected, actual);
		
	}

}
