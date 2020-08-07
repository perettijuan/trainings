package hackerrank.greedy;

import java.util.ArrayList;
import java.util.Collections;

/*
 * A contest is represented by two arrays:
 *  L = the amount of luck associated with a contest.
 *     ->  Contest won means luck is decreased L[i]. 
 *     ->  Contest lose means luck is increased L[i].
 *  T = importance of a contest.
 *  	1 -> contest is important.
 *  	0 -> contest is not important.
 *  
 * k represents the maximum number of contest that can loose.
 * 
 * k = 2
 * Contest   L[i]   T[i]
 *   1        5      1
 *   2        1      1
 *   3        4      0
 *   
 *  Sum of all L = 10
 *  	k = 2 (at the most 2 important contests)
 *  	Loosing 1 and 2, gives = 10
 *  	Maximum amount of luck = 10
 * for k = 1
 * 	Sum of all L = 10
 * 	Minimum important contest = contest[2] -> L = 1
 *  Out = 5 + 4 - 1 = 8
 *  
 *   
 * Example:
 *    L = [5, 2, 1, 8, 10, 5]
 *    T = [1, 1, 1, 1, 0, 0]
 *    k = 3
 *   Important contest with minimum amount of luck = [3,8][0,5][1,2][2, 1]
 *   				[Context index, Contest luck] Ordered from higher to lower
 *   Sum Unimportant contests = 10 + 5 = 15
 *   Sum tournaments can be loss until k = 8 + 5 + 2 = 15
 *   Remaining important contest = 1
 *   Total = 15 + 16 - 1 = 29
 *   
 * Algorithm:
 * 1 - Create an array with the luck of important contests.
 * 2 - Sort (1) from higher luck to lowest luck.
 * 3 - Sum all non-important contest values (can be done in (1)).
 * 4 - Sum values in (2) from 0 to k - 1.
 * 5 - Substract values in (2) from k - 1 to the end. 
 * 
 * 
 * TOOK ME 30 minutes
 * ALL GREEN!
 *  
 */
public class LuckBalance {
	
	private static final int IMPORTANT_CONTEST = 1;
	
	static int luckBalance(int k, int[][] contests) {
		int balance = 0;
		ArrayList<Integer> importants = new ArrayList<Integer>();
		
		for (int contest = 0; contest < contests.length; contest++) {
			int luck = contests[contest][0];
			int importance = contests[contest][1];
			
			if (importance == IMPORTANT_CONTEST) { // contest is imporant
				importants.add(luck); // check if two contest have the same importance.
			} else {
				balance = balance + luck; // Sum non-important ones
			}			
		}
		
		
		
		Collections.sort(importants, Collections.reverseOrder());
		
		for (int i = 0; i < importants.size(); i++) {
			System.out.println("Important sorted[" + i + "] is " + importants.get(i));
		}
		
		System.out.println("Balance so far " + balance);
		
		for (int i = 0; i < importants.size(); i++) {
			if (i <= k-1) {
				System.out.println("Adding[" + i + "] - " + importants.get(i));
				balance = balance + importants.get(i);
			} else {
				System.out.println("Substracting[" + i + "] - " + importants.get(i));
				balance = balance - importants.get(i);
			}			
		}
		
		
		return balance;
    }

}
