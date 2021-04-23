package hackerrank.problemsolving;

/*
 * 
 * All green
 * 1.30 minutes
 * 
 * DOES NOT COUNT!
 *
 */
public class SimpleArraySum {

	static int simpleArraySum(int[] ar) {
        int sum = 0;
        
        for (int i = 0; i < ar.length; i++) {
        	sum = sum + ar[i];
        }
        
        
        return sum;
    }
}
