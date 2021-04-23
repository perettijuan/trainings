package hackerrank.warmup;

/*
 *  SOLVED
 */
public class RepeatedString {
	/**
	 * s = abcac and n = 10 ==> substring is abcacabcac
	 * a appears 4 times in the substring
	 * 
	 * s.length = 5; n/s.length = 2; number of a's in s = 2 ; 2x2 = 4
	 * 
	 * 
	 * s = aba and n = 10 ==> substring is abaabaabaa
	 * a appears 7 times
	 * 
	 * s.length = 3; n/s.length = 3.3; number of a's in s = 2 ; 2x2 = 4
	 * 
	 * s = a and n = 1000000000000
	 * out = 1000000000000
	 * 
	 * s.length = 1; n/s.length = 1000000000000; number of a's in s = 1 ; 1x1000000000000 = 1000000000000
	 * 
	 * 
	 * Agorithm:
	 *  1 - Get the number of a's in s.
	 *  2 - How many times s fits in n (n/s.lenght)
	 *      Important here: store the modulo of that.
	 *  3 - Number of a's = 1x2    
	 *  4 - If modulo is > 0; count the a's in s until modulo And sum to 3
	 */
	
	
	static long repeatedString(String s, long n) { //s = aba; n = 10
		long repeatedString = 0;
		
		if (s.length() == 1 && s.charAt(0) == 'a') {
			return n;
		}
		
		
		long numberInString = 0;
		for (int i = 0; i < s.length(); i++) { // i = 2
			if (s.charAt(i) == 'a') { // 
				numberInString = numberInString + 1; // numberInString = 2
			}
		}
		
		long fit =  n/s.length(); // fit = 3
		long modulo = n % s.length(); // modulo = 1
		
		repeatedString = numberInString * fit; // repeatedString = 6
		
		if (modulo > 0) {
			for (int i = 0; i < modulo; i++) {
				if (s.charAt(i) == 'a') {
					repeatedString = repeatedString + 1; // repeatedString = 7
				}
			}
		}
		
		return repeatedString;
    }

}
