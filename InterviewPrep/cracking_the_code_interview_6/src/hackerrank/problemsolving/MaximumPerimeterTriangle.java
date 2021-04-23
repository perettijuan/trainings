package hackerrank.problemsolving;

import java.util.Arrays;

/*
 * A degenerate triangle can be found when:
 *  given the sides of the triangle (a,b and c)
 *    if a + b <= c ===> DEGENERATE TRIANGLE
 *    
 * given the sticks = {1,2,3,4,5,10}
 * 
 *    find the triangle with the maximum possible perimeter.
 *    
 *  To have a triangle, I need 3 sides (sticks).   
 *    1st => 1,2,3 ==> 1+2 < 3 -> DEGENERATE
 *    2nd => 1,3,4 ==> 1+3 = 4 -> DEGENERATE
 *    3rd => 1,3,5 ==> 1+3 < 5 -> DEGENERATE
 *    and so on...
 *    
 *    Possibles:
 *    2,3,4 => 2 + 3 > 4 -> OK
 *    3,4,5 => 3 + 4 > 5 -> OK
 *    
 *    Longer perimeter ==> 3 + 4 + 5 = 12
 *    
 *    
 * If more than one has that maximum, choose from them the one with the longest minimum side.
 *   2,3,4 --> PRINT THIS ONE CAUZE IT HAS THE 4 (longest minimum side)
 *   1,3,3
 *    
 *    
 * Possible special cases
 *  -> ALL OF THEM ARE DEGENERATES ==> print -1
 * 		{1,2,3,5}
 * 
 * 
 * Algorithm
 * 
 * 1 - Iterate with two index, i = 0 and j = i+1
 * 2 - Verify if the triangle is degenerate or not
 * 3 - If triangle is NON-DEGENERATE, store perimeter and all three sides.
 * 4 - Every time I find a NON-DEGENRATE, verify if it has the max perimeter.
 *     If two perimeters are max => find the one with the longest minimum side.
 *
 *ALL GREEN 
 *38 minutes
 *
 */
public class MaximumPerimeterTriangle {

	
	static int[] maximumPerimeterTriangle(int[] sticks) {
		int[] sides = null;
		double maxPerimeter = 0;
		
		Arrays.sort(sticks);
		
		for (int i = 0; i < sticks.length; i++) {
			int a = sticks[i];
			for (int j = i+1; j < sticks.length - 1; j++) { // verify that goes to the last position
				int b = sticks[j];
				int c = sticks[j+1];
				
				// verify non-degenerate
				if (a + b > c) {
					
					double perimeter = a + b + c;
					
					if (sides == null) {
						sides = new int[3];
					}
					
					double max = Math.max(perimeter, maxPerimeter);
					System.out.println("max " + max);
					if (max >= maxPerimeter) {
						System.out.println("1");
						maxPerimeter = perimeter;
						sides[0] = a;
						sides[1] = b;
						sides[2] = c;											
					} else if(max == 0.0) {		
						System.out.println("2");
						if (c > sides[2]) {
							maxPerimeter = perimeter;
							sides[0] = a;
							sides[1] = b;
							sides[2] = c;
						}					
					}					
				}				
			}
		}

		
		if (sides == null) {
			sides =new int[]{-1};
		}
		
		
		return sides;
    }
}
