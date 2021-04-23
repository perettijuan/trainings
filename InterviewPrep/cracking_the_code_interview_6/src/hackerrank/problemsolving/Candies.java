package hackerrank.problemsolving;

/*
 * Student's ratings = {4, 6, 4, 5, 6, 2}
 * Minimum amount    = {1, 2, 1, 2, 3, 1}
 * 
 * candieToGive = 1
 * Rule is => if rating[i] =< rating[i+1] =candieToGive--
 * 			  if rating[i] > rating[i+1] = candieToGive++ 
 * 
 * Student's ratings = {2,4,2,6,1,7,8,9,2,1}
 * Minimum amount    = {1,2,1,2,1,2,3,4,2,1}
 *            
 * candieToGive = 1
 * totalCandie = totalCandie + candieToGive
 * i  i+1 r[i] totalCandie r[i+1] candieToGive  nextRound
 * 0   1   2       1         4        1			 r[i+2] = 2 => down     
 * 1   2   4       3         2        2					= 6
 * 2   3   2       4         6        
 * 3   4   6       6         1        
 * 4   5   1       7         7        
 * 5   6   7       9         8        
 * 6   7   8       12        9        
 * 7   8   9       16        2
 * 
 *           
 * DURISIMO
 * NO PUDE           
 */
public class Candies {

}
