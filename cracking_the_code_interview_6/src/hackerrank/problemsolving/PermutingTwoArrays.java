package hackerrank.problemsolving;

import java.util.Arrays;

/*
 * Given A an array of n Integers.
 * 		 B an array of n Integers.
 * 		 k an integer.
 * 
 * I want to permute A and B to A' and B' such that
 * 	A'[i] + B'[i] >= k
 * 
 * Example:
 *  A = {0, 1}
 *  B = {0, 2}
 *  
 *    If I do 
 *    	0 + 0 = 0 < k
 *    	0 + 2 = 2 > k
 *    I could have A' = {0, 1} and B' = {2, 0}
 *    
 *    
 * A = {2, 1, 3}
 * B = {7, 8, 9}
 * k = 10
 * 
 *   2 + 7 = 9 < k
 *   2 + 8 = 10 = k  ===> A' = 2 , B' = 8
 *   1 + 7 = 8 < k
 *   1 + 9 = 10 = k  ===> A' = 2, 1 B' = 8, 9
 *   3 + 7 = 10 = k  ===> A' = 2, 1, 3 B' = 8, 9, 7
 *   
 * PRINT YES
 * 
 * A = 1, 2, 2, 1
 * B = 3, 3, 3, 4
 * k = 5
 * 
 *  1 + 3 = 4 < k
 *  1 + 3 = 4 < k
 *  1 + 3 = 4 < k
 *  1 + 4 = 5 = k ==> A' = {1} B' = {4}
 *  2 + 3 = 5 = k ==> A' = {1, 2} B' = {4, 3}
 *  2 + 3 = 5 = k ==> A' = {1, 2, 2} B' = {4, 3, 3}
 *  1 + 3 = 4 < k 
 *  
 *  PRINT NO
 *  
 * A = 1, 2, 2, 1
 * B = 3, 3, 3, 4
 * k = 6
 * 
 *  Will never k = 5, print NO
 *  
 * A = 1, 2, 2, 1
 * B = 3, 3, 3, 4
 * k = 2
 * 
 * All will pass
 * 
 * Algorithm:
 *  1 - Iterate with index i on A.
 *  2 - Iterate with index j on B, for each i.
 *  3 - Verify of B[j] != -1, then Verify if A[i]+B[j] => k
 *  		true -> put a -1 in B[j]
 *  		false -> move on
 *  		if all false, we're done, print NO
 *    	
 * 
 * 
 * 
 */
public class PermutingTwoArrays {
	
	private static int PROCESSED = -1;
	
	//A = {2, 3, 1, 1, 1}
	//B = {1, 3, 4, 3, 3}
	//k = 5
	static String twoArrays(int k, int[] A, int[] B) {
		String result = "YES";
		
		Arrays.sort(A); // A = {1,1,1,2,3}
		Arrays.sort(B); // B = {1,3,3,3,4}
		
		for (int i = 0; i < A.length; i++) { // i = 2, A[0] = 3
			boolean found = false;
			for (int j = 0; j < B.length; j++) { // j = 0
				if (B[j] != PROCESSED) {
					if (A[i] + B[j] >= k) {
						found = true;
						B[j] = PROCESSED;
						break;
					}
				}
			}
			
			if (!found) {
				result = "NO";
				break;
			}
		}
		
		return result;
    }

}
