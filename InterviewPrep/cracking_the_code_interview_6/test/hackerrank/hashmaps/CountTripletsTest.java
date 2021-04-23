package hackerrank.hashmaps;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CountTripletsTest {
	
	@Test
	public void test1() {
		List<Long> arr = new ArrayList<Long>();
		arr.add(1L);
		arr.add(2L);
		arr.add(2L);
		arr.add(4L);
		int r = 2;
		long expected = 2;
		
		
		long actual = CountTriplets.countTriplets(arr, r);
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test2() {
		List<Long> arr = new ArrayList<Long>();
		arr.add(1L);
		arr.add(2L);
		arr.add(2L);
		arr.add(4L);
		arr.add(4L);
		int r = 2;
		long expected = 4;
		
		
		long actual = CountTriplets.countTriplets(arr, r);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3() {
		List<Long> arr = new ArrayList<Long>();
		arr.add(1L);
		arr.add(3L);
		arr.add(9L);
		arr.add(9L);
		arr.add(27L);
		arr.add(81L);
		int r = 3;
		long expected = 6;
		
		
		long actual = CountTriplets.countTriplets(arr, r);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test4() {
		List<Long> arr = new ArrayList<Long>();
		arr.add(1L);
		arr.add(5L);
		arr.add(5L);
		arr.add(25L);
		arr.add(125L);
		
		int r = 5;
		long expected = 4;
		
		
		long actual = CountTriplets.countTriplets(arr, r);
		
		assertEquals(expected, actual);
	}

	
	@Test
	public void test5() {
		List<Long> arr = new ArrayList<Long>();
		arr.add(1L);
		arr.add(1L);
		arr.add(2L);
		arr.add(2L);
		arr.add(4L);
		arr.add(4L);
		int r = 2;
		long expected = 8;
		
		
		long actual = CountTriplets.countTriplets(arr, r);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test6() {
		List<Long> arr = new ArrayList<Long>();
		for (int i= 0; i < 100; i++) {
			arr.add(1l);
		}
		int r = 1;
		long expected = 8;
		
		
		long actual = CountTriplets.countTriplets(arr, r);
		
		assertEquals(expected, actual);
	}

}
