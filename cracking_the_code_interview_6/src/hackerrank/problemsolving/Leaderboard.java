package hackerrank.problemsolving;

import java.util.ArrayList;
import java.util.List;

/*
 * scores = {100, 100, 50, 40, 40, 20, 10} => rankings = {100x2,50,40x2,20,10}
 * alice = {5, 25, 50, 120}                                1    2  3    4  5
 * 
 * Alice played 4 games.
 * after 1st game -> scores 5 -> rank 6
 * 		 2nd game -> scores 25 -> rank 4
 *       3rd game -> scores 50 -> rank 2
 *       4rd game -> scores 120 -> rank 1
 * 
 * Question: scores is always sorted from max to min?
 * 
 * 
 * Algorithm:
 *   for each game
 *   	binary search with the score
 *   	position is i+1
 * 
 * ALL GREEN (TIME OUT)
 * 24 minutes
 */
public class Leaderboard {

	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		int[] output =  new int[alice.length];
		List<Integer> scoreClean = cleanUpScores(scores);
		
		for (int i = 0; i < alice.length; i++) {
			int aliceScore = alice[i];
			boolean found = false;
			
			for (int j = 0; j < scoreClean.size(); j++) {
				int current = scoreClean.get(j);
				
				if (aliceScore >= current) {					
					output[i] = j + 1;
					found = true;
					break;
				} 				
				
				if (!found) {
					output[i] = scoreClean.size() + 1;
				}
			}			
		}

		return output;
    }
	
	static List<Integer> cleanUpScores(int[] original) {
		ArrayList<Integer> out = new ArrayList<Integer>();
		
		for (int i = 0; i < original.length; i++) {
			int current = original[i];
			if (!out.contains(current)) {
				out.add(original[i]);
			}
		}
		
		return out;
	}
	
	
	
	
	
}
