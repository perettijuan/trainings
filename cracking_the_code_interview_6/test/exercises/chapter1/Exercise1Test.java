package exercises.chapter1;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class Exercise1Test {

	@Test
	public void test1() {
		assertTrue(Exercise1.isUnique("abcde"));
	}
	
	@Test
	public void test2() {
		assertFalse(Exercise1.isUnique("#aifa"));
	}
	
	@Test
	public void test3() {
		assertTrue(Exercise1.isUnique("#1"));
	}
	
	@Test
	public void test4() {
		assertTrue(Exercise1.isUnique("#122"));
	}
	
	@Test
	public void test5() {
		assertFalse(Exercise1.isUnique("#131"));
	}
	
	@Test
	public void test6() {
		assertTrue(Exercise1.isUnique("#34tU"));
	}

}
