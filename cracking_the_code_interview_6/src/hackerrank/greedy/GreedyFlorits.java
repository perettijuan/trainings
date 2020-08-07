package hackerrank.greedy;

import java.util.Arrays;

/*
 * Output: the minimum cost to purchase all the flowers.
 * 
 *  For each customer: first flower = (0 + 1) * original price
 *  								  (1 + 1) * original price
 *  								  (2 + 1) * original price
 *  									...
 *  								  (n + 1) * original price
 *  
 * k = number of customers in the group.
 * n = number of flowers to buy.
 * c = array with the prices of each flower (apparently sorted).
 *
 * k = 3
 * n = 4
 * c = 1, 2, 3, 4
 * 
 *    To more expensive flowers are 2, 3 and 4
 *    It is better to multiply by higher factors the less expensive flowers (first-most prices)
 *    First flower buyed by each customer: from length to start
 *    customer 1 ==> buys length()-1 flower = (0+1)x4 = 4
 *    customer 2 ==> buys length()-2 flower = (0+1)x3 = 3
 *    customer 3 ==> buys length()-3 flower = (0+1)x2 = 2
 *    
 *    // could buy
 *    customer 1 ==> buys length()-4 flower = (1+1)x1 = 2
 *    
 *    Minimum total cost = 4 + 3 + 2 + 2 = 11
 *    
 * k = 3
 * n = 5
 * c = 1 3 5 7 9
 * 
 *    1 => (0+1)*9 = 9
 *    2 => (0+1)*7 = 7
 *    3 => (0+1)*5 = 5
 *    -----------------
 *    1 => (1+1)*3 = 6
 *    2 => (1+1)*1 = 2
 *    ------------------
 *    				 29
 *    
 *     
 * Algorithm: (assuming prices are sorted)
 * 1 - Go from length() - 1 to zero.
 * 2 - Keep multiplier = 0
 * 3 - Keep a counter to count the number of purchases.
 * 4 - Every time counter == k ==> multiplier++
 *
 *
 * ALL GREEN
 * 31 MINUTES
 */
public class GreedyFlorits {
	
	
	static int getMinimumCost(int k, int[] c) {
		Arrays.sort(c);
		int minimumCost = 0;
		int multiplier = 0;
		int counter = 0;
		
		for (int i = c.length - 1; i > -1; i--) {
			int localCost = (multiplier + 1) * c[i];				
			minimumCost = minimumCost + localCost;
			
			counter++;
			if (counter == k) {						
				multiplier++;
				counter = 0;
			}
		}
		
		
		return minimumCost;
    }

}
