package hackerrank.problemsolving;

import java.util.List;

import org.junit.Test;

public class LeaderboardTest {
	
	@Test
	public void test1() {
		int[] scores = {100, 100, 50, 40, 40, 20, 10};
		
		List<Integer> sorted = Leaderboard.cleanUpScores(scores);
		
		for (int score : sorted) {
			System.out.println("Score " + score);
		}
		
	}

}
