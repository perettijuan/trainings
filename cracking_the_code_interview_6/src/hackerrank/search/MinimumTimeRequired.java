package hackerrank.search;

/*
 * 
 * Goal = 10
 * machines = {2,3,2} /// number of days to produce an item
 * 
 * Day Production Count
 *  2     2         2
 *  3     1         3
 *  4     2         5
 *  6     3         8
 *  8     2         10
 *  
 * Output = 8
 *  
 * Goal = 5
 * machines = {2, 3}
 * 
 * Day Production Count
 *  2      1        1
 *  3      1        2
 *  4      1        3
 *  6      2        5
 *  
 * Output = 6
 * 
 * Goal = 10
 * machines = {1,3,4}
 * 
 * In 7 days => m[0] = 7
 * In 7 days => m[1] = 2
 * In 7 days => m[4] = 1
 * 
 * Output = 10
 * 
 * Algorithm:
 * 1 - while count < goal
 * 2 - i++
 *     if (m[i] % i) = 0 ==> count++
 * 
 * All Green (Time Out)
 * 30 minutes
 */
public class MinimumTimeRequired {
	
	static long minTime(long[] machines, long goal) {
		long minTime = 0;
		long production = 0;
		
		while (production < goal) {
			minTime = minTime + 1;
			
			for (int i = 0; i < machines.length; i++) {				
				if (minTime % machines[i] == 0) {					
					production = production + 1;
				}				
			}
			
		}
		return minTime;
    }

}
