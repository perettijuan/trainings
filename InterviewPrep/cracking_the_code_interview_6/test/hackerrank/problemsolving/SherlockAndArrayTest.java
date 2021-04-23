package hackerrank.problemsolving;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class SherlockAndArrayTest {
	
	@Test
	public void test1() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(3);
		
		String expected = "YES";
		
		String actual = SherlockAndArray.balancedSums(arr);
		
		assertEquals(expected, actual);
	}

}
