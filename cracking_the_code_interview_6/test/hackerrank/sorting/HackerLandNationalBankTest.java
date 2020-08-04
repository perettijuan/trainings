package hackerrank.sorting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HackerLandNationalBankTest {
	
	@Test
	public void test1() {
		int d = 3;
		int[] expenditure = {10, 20, 30, 40, 50};
		
		int expected = 1;
		
		int actual = HackerLandNationalBank.activityNotifications(expenditure, d);
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test2() {
		int d = 5;
		int[] expenditure = {2, 3, 4, 2, 3, 6, 8, 4, 5};
		
		int expected = 2;
		
		int actual = HackerLandNationalBank.activityNotifications(expenditure, d);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3() {
		int d = 4;
		int[] expenditure = {1, 2, 3, 4, 4};
		
		int expected = 0;
		
		int actual = HackerLandNationalBank.activityNotifications(expenditure, d);
		
		assertEquals(expected, actual);
	}

}
