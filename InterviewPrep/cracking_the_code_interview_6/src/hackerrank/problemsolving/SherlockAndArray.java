package hackerrank.problemsolving;

import java.util.List;

/*
 * Find an element of the array such that the sum of ALL elements to
 * the left is equals to the sum of ALL elements to the right.
 * 
 * Example:
 *   given {5,6,8,11}
 *        5+6 = 11   8 is in the middle.
 *   Print YES.
 * 
 * 
 *  Input:
 *    {1}
 *    Output YES (left and right sum is 0).
 *    
 *  Input
 *  	2,3
 *  	Output NO
 *  
 *  Input 
 *      0,2
 *      Output = YES
 *  Input
 *  	2,0
 *  	Output = YES
 *  
 *  Input 
 *  	{0,0,0}
 *  	Output = YES
 *  
 *  Input
 *  	{1,2,3,4,3,2,1}
 *  	Output = YES
 *  
 *  Input
 *  	{1,2,3,3}
 *  	Output = YES
 *  
 *  
 * 
 * Algorithm:
 *  1 - Start with index = 1, do index + 1
 *  2 - On each loop, sum values from 
 *        - 0 to index - 1
 *        - index + 1 to size
 *     Compare both, if equals, cut the loop and return YES
 *     
 *  Special cases:
 *  	- size = 1 ==> print YES
 *  	- size = 2 ==> print YES if index[0] = 0 or index[1] = 0
 *  
 *  Careful
 *  	- check index - 1 is within the bounds of the array (it is >= 0)
 *  	- check index + 1 is within the bounds of the array (it is < size)
 * 
 * 
 */
public class SherlockAndArray {

	
	 static String balancedSums(List<Integer> arr) { //  1 2 3 3
		 String output = "NO";

		 for (int i = 0; i < arr.size(); i++) { // i = 0
			 if (checkLeftAndRightOf(i, arr)) { 
				 output = "YES";
				 break;
			 }
		 }
		 
		 return output;
	 }
	 
	 static boolean checkLeftAndRightOf(int index, List<Integer> arr) {	// index = 0, arr = 0,2
		 int leftSum = 0;
		 int rigthSum = 0;
		 

		 if (index - 1 >= 0) { // index - 1 = 0; true
			 for (int i = 0; i < index; i++) { // i = 0; arr.get(i) = 0  
				 leftSum = leftSum + arr.get(i); // leftSum = 0
			 }
		 }
		 
		 
		 if (index + 1 < arr.size()) { // index + 1 = 2; false
			 for (int i = index + 1; i < arr.size(); i++) { // i = ; arr.get(i) = 
				 rigthSum = rigthSum + arr.get(i); // rigthSum = 
			 }
		 }
		
		 return leftSum == rigthSum; // true
	 }
	
}
