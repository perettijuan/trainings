package exercises.chapter1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Exercise4Test {
	
	@Test
	public void test1() {
		assertTrue(Exercise4.areEdit("pale", "ple"));
	}
	
	@Test
	public void test2() {
		assertTrue(Exercise4.areEdit("pales", "pale"));
	}
	
	@Test
	public void test3() {
		assertTrue(Exercise4.areEdit("pale", "bale"));
	}
	
	@Test
	public void test4() {
		assertFalse(Exercise4.areEdit("pale", "bake"));
	}
	
	@Test
	public void test5() {
		assertTrue(Exercise4.areEdit("paae", "paaae"));
	}
}
