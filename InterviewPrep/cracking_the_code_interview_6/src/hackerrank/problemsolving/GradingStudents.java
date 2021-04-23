package hackerrank.problemsolving;

import java.util.ArrayList;
import java.util.List;

/*
 * Grading policy:
 * 1 - Every student receives a grade ==> 0 =< grade =< 100
 * 2 - Any grade < 40 ==> fails
 * 
 * Rules to round the grades:
 *  - If the difference between the grade and the next multiple of 5 is less than 3,
 *    round to the next multiple of 5.
 *  - If the grade is < 38, no rounding -> failing.
 *  
 * Example:
 *  grade = 84 , rounded to 85
 *  grade = 83 , rounded to 85
 *  grade = 82 , no rounding
 *  grade = 97 , no rounding
 *  grade = 98 , rounded to 100
 *  grade = 95 , no rounding
 *  
 *  grade = 37 , no rounding
 *  grade = 38 , round to 40
 *  grade = 39 , round to 40
 *  grade = 40 , no rounding (approved)
 * 
 * 
 * Algorithm:
 *  1 - if grade is < 38, no rounding
 *  2 - if grade is >= 40, round
 *  		if grade is a multiple of 5, no rounding
 *  		find next multiple of 5 from grade
 *  		 multiple - grade = value
 *  		if value < 3, no rounding
 *  		else grade = multiple
 * 
 * 
 */
public class GradingStudents {
	
	public static List<Integer> gradingStudents(List<Integer> grades) {
		ArrayList<Integer> roundedGrades = new ArrayList<Integer>();
		
		for (Integer grade : grades) {
			roundedGrades.add(getRoundedGrade(grade));
		}

		return roundedGrades;
	}
	
	static int getRoundedGrade(int grade) {
		int rounded = grade;
		
		if (grade < 38) {
			return rounded;
		}
		
		if (grade % 5 == 0) {
			return rounded;
		}
		
		int nextMultiple = round(grade);
		int difference = nextMultiple - grade;
		
		if (difference < 3) {
			rounded = nextMultiple;
		}
		
		
		return rounded;
	}
	
	
	static int round(int toRound) {
		return (toRound + 4) / 5 * 5;
	}

}
