package exercises.chapter3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exercises.chapter3.StackExercise2.JStackMin;
public class StackExercise2Test {

	
	@Test
	public void testMin1() {
		Integer expected = new Integer(1);
		JStackMin<Integer> stack = new JStackMin<>();
		stack.push(new Integer(5));
		stack.push(new Integer(7));
		stack.push(new Integer(2));
		stack.push(new Integer(8));
		stack.push(new Integer(9));
		stack.push(expected);
		stack.push(new Integer(3));
		
		
		assertEquals(expected, stack.min());
	}
	
	
}
