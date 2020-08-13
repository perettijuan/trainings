package hackerrank.problemsolving;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GridChallengeTest {

	@Test
	public void test1() {
		String[] grid = new String[5];
		grid[0] = "ebacd";
		grid[1] = "fghij";
		grid[2] = "olmkn";
		grid[3] = "trpqs";
		grid[4] = "xywuv";
		
		String expected = "YES";
		
		String actual = GridChallenge.gridChallenge(grid);
		
		assertEquals(expected, actual);
	}
}
