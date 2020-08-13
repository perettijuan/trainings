package hackerrank.problemsolving;

import java.util.Arrays;
import java.util.Collections;

/*
 * Input = array of calories each cupcake has.
 * 
 *   After eating a cupcake with c calories, he must walk:
 *   		2^j * c miles
 *   
 * Determinate the minimum number of miles
 * 
 * c = {5,10,7}
 *   2^0*5 + 2^1*10 + 2^2*7 = 53
 *   
 * By sorting c = 10,7,5  
 *   2^0*10 + 2^1*7 + 2^2*5 = 44
 *      
 *      
 * c= {1,2,3,4}
 *  2^0*1 + 2^1*2 + 2^2*3 + 2^3*4 = 49
 *  
 *  2^0*4 + 2^1*3 + 2^2*2 + 2^3*1 = 26
 * 
 * 
 * algorithm:
 * 
 * 1 - sort c
 * 2 - calculate calories
 * 
 * All green, 19 minutes
 */
public class Cakewalk {
	
	 static long marcsCakewalk(int[] calorie) {
		 long calories = 0;
		 
		 Arrays.sort(calorie);
		 int pow = 0;
		 
		 for (int i = calorie.length -1; i >- 1; i--) {
			 long cal = calorie[i];
			 long calc =  (long) (Math.pow(2, pow)*cal);
			 
			 calories = calories + calc;
			 pow++;
		 }
		 
		 
		 return calories;
	 }

}
