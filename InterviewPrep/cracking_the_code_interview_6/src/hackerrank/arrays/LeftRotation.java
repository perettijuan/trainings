package hackerrank.arrays;

/*
 * Rotate 1 unit to the left
 *  input = [1, 2, 3, 4, 5]
 *  output = [2, 3, 4, 5, 1]
 *  
 * Rotate 4 units to the left:
 *   input = [1, 2, 3, 4, 5]
 *   output = [5, 1, 2, 3, 4]
 * 
 * Rotate 3 units to the left:
 *   input = [1, 2, 3, 4, 5, 6, 7, 9, 8]
 *   output = [4, 5, 6, 7, 9, 8, 1, 2, 3]
 *   
 * Rotate 3 units to the left:
 *   input = [1, 2, 3]
 *   output = [3, 2, 1]  
 * 
 * Rotate 3 units to the left:
 *   input = [1, 2]
 *   output = fail  
 *   
 * Idea: 
 * 1 - create an array of d elements (where d is the number of rotations)
 * 2 - unload the original array in 1, until d
 * 3 - the rest of the numbers in 2, store them in the output array (from zero)
 * 4 - store the elements in 1 in 3  
 * 
 *  
 * SOLVED
 * NO TIME
 */
public class LeftRotation {

	static int[] rotLeft(int[] a, int d) { // a = [1, 2, 3, 4, 5], d = 4
		int[] result = new int[a.length];

		int[] temp = new int[d];

		for (int i = 0; i < d; i++) {// i = 4
			temp[i] = a[i]; // temp [1, 2, 3, 4]
		}

		int index = 0;
		for (int i = d; i < a.length; i++) { // i = 5
			result[index] = a[i]; // result [5]
			index = index + 1; // index = 1
		}

		for (int i = 0; i < temp.length; i++) { // i = 4, temp.length = 4
			result[index] = temp[i]; // result [5, 1, 2, 3, 4]
			index = index + 1; //index = 5
		}

		return result;
	}

}
