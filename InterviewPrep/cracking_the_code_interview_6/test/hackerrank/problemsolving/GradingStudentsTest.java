package hackerrank.problemsolving;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GradingStudentsTest {
	
	@Test
	public void test1() {
		int expected = 100;
		int actual = GradingStudents.getRoundedGrade(98);
		assertEquals(expected, actual);
	}

}
