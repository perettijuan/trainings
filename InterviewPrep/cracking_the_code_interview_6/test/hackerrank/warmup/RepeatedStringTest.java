package hackerrank.warmup;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class RepeatedStringTest {
	
	
	@Test
	public void test1() {	
		String s = "abcac";
		int n = 10;
		
		long expected = 4;
		long actual = RepeatedString.repeatedString(s, n);
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test2() {	
		String s = "aba";
		int n = 10;
		
		long expected = 7;
		long actual = RepeatedString.repeatedString(s, n);
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test3() {	
		String s = "a";
		long n = 1000000000000L;
		
		long expected = 1000000000000L;
		long actual = RepeatedString.repeatedString(s, n);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test4() {	
		String s = "sbr";
		int n = 10;
		
		long expected = 0;
		long actual = RepeatedString.repeatedString(s, n);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test5() {	
		String s = "sbra";
		int n = 10;
		
		long expected = 2;
		long actual = RepeatedString.repeatedString(s, n);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test6() {	
		String s = "kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm";
		long n = 736778906400L;
		
		long expected = 51574523448l;
		long actual = RepeatedString.repeatedString(s, n);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test7() {	
		String s = "epsxyyflvrrrxzvnoenvpegvuonodjoxfwdmcvwctmekpsnamchznsoxaklzjgrqruyzavshfbmuhdwwmpbkwcuomqhiyvuztwvq";
		long n = 549382313570L;
		
		long expected = 16481469408L;
		long actual = RepeatedString.repeatedString(s, n);
		
		assertEquals(expected, actual);
	}

}
