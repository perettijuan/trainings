package exercises.chapter1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestExercise2 {
	
	@Test
	public void test1() {
		assertTrue(Exercise2.checkPermutation("abcde" ,"bcdae"));
	}
	
	@Test
	public void test2() {
		assertFalse(Exercise2.checkPermutation("abcde" ,"bcdaef"));
	}
	
	@Test
	public void test3() {
		assertFalse(Exercise2.checkPermutation("ju7ty" ,"lkjut"));
	}
	
	@Test
	public void test4() {
		assertFalse(Exercise2.checkPermutation("aaaa" ,"aaba"));
	}
	
	@Test
	public void test5() {
		assertFalse(Exercise2.checkPermutation("12" ,"1"));
	}
	
	@Test
	public void test6() {
		assertTrue(Exercise2.checkPermutation("bbbb" ,"bbbb"));
	}

}
