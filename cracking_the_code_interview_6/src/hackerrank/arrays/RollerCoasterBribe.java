package hackerrank.arrays;

/*
 * n = 8, person 5 bribes person 4 => 1, 2, 3, 5, 4, 6, 7, 8
 * 
 * 2 1 5 3 4 => 3
 * 
 * 2 5 1 3 4 => TC
 * 
 * 2 1 5 3 4 6 8 9 7 => 5
 *  
 * One person can bribe at most two persons
 *   When this rule is break, print Too chaotic
 *
 *   
 * IMPORTANT = the input is [originally] ordered
 *    because it is a queue with increments of one, starting on one
 *    
 * Algorithm:
 * 1 - Iterate the input (current).
 * 2 - If current > next => 1 bribe
 * 	   If current > next + 1 => 1 bribe
 *     If current > next + 2 => Too chaotic // stop the algorithm
 *     If current < next => skip the analysis for current
 *     
 * 2 1 5 3 4 6 8 9 7
 * 1 2 3 4 5 6 7 8 9
 * 2 1 3 4 5 6 7 8 9
 * 2 1 3 5 4 6 7 8 9
 * 2 1 5 3 4 6 7 8 9
 * 2 1 5 3 4 6 8 7 9
 * 2 1 5 3 4 6 8 9 7  
 *          
 *          
 * 1 2 5 3 7 8 6 4 => 7
 * 
 * 1 - iterate the input.
 * 2 - iterate from current to end.
 * 3 - count how many positions are lower than current.
 * 4 - if (3) is > 2 (positions) == Too chaotic. 
 *     else sum(3)
 * 
 * 
 * THE SOLUTION: ITERATION FROM THE CURRENT POSITION TO THE END OF THE ARRAY.
 */
public class RollerCoasterBribe {

	static void minimumBribes(int[] q) { // 2 5 1 3 4
		int bribes = minimumBribesImpl(q);
		if (bribes < 0) {
			System.out.println("Too chaotic");
		} else {
			System.out.println(bribes);
		}

	}

	static int minimumBribesImpl(int[] q) {
		int bribes = 0;

		for (int i = 0; i < q.length; i++) { // 0 = 1; q = 1 2 5 3 7 8 6 4
			int current = q[i];
			int innerBribes = 0;
			for (int j = i; j < q.length; j++) {
				int next = q[j];
				if (current > next) {
					innerBribes = innerBribes + 1;
				}
			}
			
			if (innerBribes > 2) {
				bribes = -1;
				break;				
			} else {
				bribes = bribes + innerBribes;
			}
		}

		return bribes;
	}

}
