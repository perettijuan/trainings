package hackerrank.problemsolving;

/*
 * L = length of the text (WITHOUT SPACES)
 * 
 * 1 step => remove all spaces in the text.
 * 2 step => characters written into a grid. Rows and columns have the constraint:
 * 			 floor(squareRoot(L)) <= row count <= column count <= ceil(squareRoot(L))
 * 
 * s = ifmanwas meant to stay on the ground god would have given roots
 *  L = 54
 *  squareRoot(54) = 7.34
 *  floor(7.34) = 7
 *  ceil(7.34) = 8 
 *  
 *  rows count = 7
 *  columns count = 8
 *  
 *  ifmanwas  
 *  meanttos          
 *  tayonthe  
 *	groundgo  
 *	dwouldha  
 * 	vegivenu  
 *	sroots
 *
 * - ensure that rows * columns >= L
 * - if multiple grids satisfy the above condition, choose the one with the minimum area, i.e rows * columns
 * 
 * The encoded message is obtained by displaying the characters in a column, 
 * inserting a space, 
 * and then displaying the next column 
 * and inserting a space,
 * and so on. 
 * 
 * For example, the encoded message for the above rectangle is: imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau
 * 
 * 
 * 
 * 
 * Example: ou
 *  L = 2
 *  squareRoot(2) = 1.4
 *  floor = 1
 *  ceil = 2
 *  
 *  rows = 1
 *  cols = 2
 *  
 *  encrypted = ou
 *  
 * 
 * 
 * 
 * Algorithm: 
 * 1 - calculate row x column.
 * 2 - create the encrypted text.
 * 3 - print to sb.
 * 
 * One Hour and I got stuck.
 */
public class Encryption {
	
	static String encryption(String s) {
		StringBuffer sb = new StringBuffer();
		
		// calculate row * column
		
		s = s.replaceAll("\\s+","");// remove all spaces (?)
		
		double L = s.length();
		double sqL = Math.sqrt(L);
		int rows = (int) Math.floor(sqL);
		int columns = (int) Math.ceil(sqL);
		
		char[][] arr = new char[rows][columns];
		
		int charIndex = 0;
		System.out.println("L " + L);
		
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < columns; col++) {							
				arr[row][col] = s.charAt(charIndex);
				charIndex = charIndex + 1;
				if (charIndex >= L) {
					break;
				}				
			}				
		}
		
		
		
		for (int col = 0; col < columns; col++) {			
			for (int row = 0; row < rows; row++) {
				sb.append(arr[row][col]);
			}	
			sb.append(" ");
		}
		
		return sb.toString();
    }

}
