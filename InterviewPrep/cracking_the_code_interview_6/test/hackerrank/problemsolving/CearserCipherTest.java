package hackerrank.problemsolving;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

public class CearserCipherTest {
	
	@Test
	public void test1() {
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		char[] rotated = "klmnopqrstuvwxyzabcdefghij".toCharArray();
		
		Map<Character, Character> map = CearserCipher.createRotatedAlphabet(alphabet, 10);
		
		for (int i = 0; i < alphabet.length; i++) {
			char key = alphabet[i];
			char expected = rotated[i];
			char actual = map.get(key);
			
			assertEquals(expected, actual);
		}
		
	}

}
