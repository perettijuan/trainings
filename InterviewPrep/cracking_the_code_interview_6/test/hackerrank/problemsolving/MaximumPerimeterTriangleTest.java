package hackerrank.problemsolving;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaximumPerimeterTriangleTest {
	
//	@Test
//	public void test1() {
//		int[] sticks = new int[50];
//		
//		for (int i = 0; i < sticks.length; i++) {
//			sticks[i] = 1000000000;
//		}
//		
//		int[] expected = {1000000000, 1000000000, 1000000000};
//		
//		int[] actual = MaximumPerimeterTriangle.maximumPerimeterTriangle(sticks);
//		
//		for (int i = 0; i < expected.length; i++) {
//			assertEquals(expected[i], actual[i]);
//		}
//	}
	
	
	@Test
	public void test2() {
		int[] sticks = {1,1,1,3,3};
				
		
		int[] expected = {1, 3, 3};
		
		int[] actual = MaximumPerimeterTriangle.maximumPerimeterTriangle(sticks);
		
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}

}
