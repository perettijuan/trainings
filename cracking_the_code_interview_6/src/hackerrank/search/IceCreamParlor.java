package hackerrank.search;

/*
 * cost = {2,1,3,5,6}
 *  /// IMPORTANT = cost is 1-indexed, meaning that starts at 1 not at 0.
 * money = 5
 *  best probable combination = cost[1] = 2 and cost[3] = 3 => 2 + 3 = 5
 *  
 * THERE IS ALWAYS ONE SOLUTION 
 *   
 * money = 4
 * cost = {1,4,5,3,2}
 *     1 + 4 = 5 x
 *     1 + 5 = 6 x
 *     1 + 4 = 4 DONE
 * 
 * money = 4
 * cost = {2,2,4,3}
 *  2 + 2 = 4 =>  DONE
 *  
 *  
 * money = 12 
 * cost = {2,4,4,6,7} 
 *  2 + 4 = 6
 *  2 + 4 = 6
 *  2 + 6 = 8
 *  2 + 7 = 9
 *  4 + 6 = 10 THIS
 *  4 + 7 = 11 THIS
 *  6 + 7 = 13
 *  
 *  
 * Algorithm:
 * 1 - Iterate from i = 0.
 * 2 - Iterate from j = i+1
 * 3 - cost[i] + cost[j] = sum
 * 		if sum == money ---> DONE (only one solution)
 * 		else {
 * 			result = money - sum
 * 			
 * 			if (result > 0) {
 * 				if (result < smallestDifference) {
 * 					smallestDifference = result
 * 					cost1 = cost[i]
 * 					cost2 = cost[j]
 * 				} 			
 * 			} 
 * 		}
 * 
 * IMPORTANT = ADJUST INDEX DOING i+1 j+1
 * 
 * DONE (OUT OF LIMITS)
 * TIME = 18min
 * 
 */
public class IceCreamParlor {
	
	static void whatFlavors(int[] cost, int money) {
		int cost1 = 0;
		int cost2 = 0;
		int smallestDifference = -1;
		
		for (int i = 0; i < cost.length; i++) {
			for (int j = i + 1; j < cost.length; j++) {
				int sum = cost[i] + cost[j];
				
				if (sum == money) {
					cost1 = i;
					cost2 = j;
					break;
				}
				
				int difference = money - sum;
				
				if (smallestDifference == -1) {
					smallestDifference = difference;
				}
				
				if (difference > 0 && difference < smallestDifference) {
					 smallestDifference = difference;
					 cost1 = i;
					 cost2 = j;					
				}			
			}
		}
		
		// adjust indexes
		cost1 = cost1 + 1;
		cost2 = cost2 + 1;
		
		System.out.println("" + cost1 + " " + cost2);
    }

}
