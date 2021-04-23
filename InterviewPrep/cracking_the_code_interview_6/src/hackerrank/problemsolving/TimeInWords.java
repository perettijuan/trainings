package hackerrank.problemsolving;
/*
 * Input
 * h = hour of the day
 * m = minutes after h
 * 
 * if h = 0 ==> h + o' clock
 * if q <= minutes <= 30 -> use past
 * 			if minutes = 15 => use quarter
 * 			if minutes = 30 => use half
 * 			otherwise => minute past five
 * if minutes > 30 -> use to
 * 			 	if minutes = 15 => use quarter
 * 				if minutes = 30 => use half
 * 				otherwise => 60 - minutes = x, x to h+1
 *
 * ALL GREEN
 * 40 minutes
 * b/c i'm an idiot that doesn't read all.
 * 
 */
public class TimeInWords {
	
	static String nums[] = { "zero", "one", "two", "three", "four", 
            "five", "six", "seven", "eight", "nine", 
            "ten", "eleven", "twelve", "thirteen", 
            "fourteen", "fifteen", "sixteen", "seventeen", 
            "eighteen", "nineteen", "twenty", "twenty one", 
            "twenty two", "twenty three", "twenty four", 
            "twenty five", "twenty six", "twenty seven", 
            "twenty eight", "twenty nine", 
        }; 
	
	static String timeInWords(int h, int m) {
		if (m == 0) {
			StringBuilder sb = new StringBuilder();
			sb.append(getHour(h) + " o' clock");
			return sb.toString();
		} else if (m >= 1 && m <= 30) {
			return getPastHour(h, m);
		} else {
			System.out.println("0");
			return getToHour(h, m);
		}		
    }
	
	
	static String getPastHour(int h, int m) {
		StringBuilder sb = new StringBuilder();
		switch (m) {
		case 15:
			sb.append("quarter past " + getHour(h));
			break;
		case 30:
			sb.append("half past " + getHour(h));
			break;
		case 1:
			sb.append(nums[m] + " minute past " + getHour(h));
			break;
		default:
			sb.append(nums[m] + " minutes past " + getHour(h));
			break;
		}		
		return sb.toString();
	}
	
	static String getToHour(int h, int m) {
		StringBuilder sb = new StringBuilder();
		if (m == 15) {			
			String hour = getExtraHour(h);
			sb.append("quarter to " + hour);
			return sb.toString();
		} else {
			System.out.println("t");
			int minutes = 60 - m;
			String min = nums[minutes];
			String hour = getExtraHour(h);
			sb.append(min + " minutes to " + hour);
			return sb.toString();
		}
	}

	private static String getExtraHour(int h) {		
		if (h == 12) {
			return getHour(1);
		} else {
			return getHour(h + 1);
		}
	}
	
	
	private static String getHour(int h) {		
		switch (h) {
		case 1:
			return "one";
		case 2: 
			return "two";
		case 3: 
			return "three";
		case 4: 
			return "four";
		case 5: 
			return "five";
		case 6: 
			return "six";
		case 7: 
			return "seven";
		case 8: 
			return "eigth";
		case 9: 
			return "nine";
		case 10: 
			return "ten";
		case 11: 
			return "eleven";
		case 12: 
			return "twelve";
		default:
			throw new IllegalArgumentException("Unable to process h" + h);			
		}
	}
}
