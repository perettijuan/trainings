package hackerrank.problemsolving;

import java.math.BigInteger;

/**
 * 
 * n! is a factorial
 * Can be calculated as:
 *  n! = (n - 0) x (n - 1) x (n - 2) ... 3 x 2 x 1
 *  
 *  Recursive algorithm
 *  
 *
 * ALL GREEN
 * 18 minutes
 *
 */
public class ExtraLongFactorials {
	
	 static void extraLongFactorials(int n) {
		 BigInteger factorial = factorialOf(
				 BigInteger.valueOf(n), 
				 BigInteger.ONE, 
				 BigInteger.ZERO);
		 System.out.println("" + factorial);
	 }
	 
	 
	 private static BigInteger factorialOf(
			 BigInteger n, 
			 BigInteger current, 
			 BigInteger nextOrder) 
	 {
		  
		  BigInteger nextCalc = n.subtract(nextOrder);
		  
		  BigInteger mult = current.multiply(nextCalc);
		 
		  if (nextCalc.intValue() == 1) {
			  return mult;
		  }
		 
		  return factorialOf(n, mult, nextOrder.add(BigInteger.ONE));	 
	 }

}
