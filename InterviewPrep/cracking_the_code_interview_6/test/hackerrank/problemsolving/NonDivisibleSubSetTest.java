package hackerrank.problemsolving;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class NonDivisibleSubSetTest {
	
	@Test 
	public void test1() {
		int k = 7;
		ArrayList<Integer> s = new ArrayList<Integer>();		             
		s.add(278);
		s.add(576);
		s.add(496);
		s.add(727);
		s.add(410);
		s.add(124);
		s.add(338);
		s.add(149);
		s.add(209);
		s.add(702);
		s.add(282);
		s.add(718);
		s.add(771);
		s.add(575);
		s.add(436);
		
		int expected = 11;
		
		int actual = NonDivisibleSubSet.nonDivisibleSubset(k, s);
		
		assertEquals(expected, actual);
	}

}
