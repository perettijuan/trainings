package hackerrank.sorting;

/*
 * d = Trailing days
 * expenditures = list of expenses in the n last days.
 * 
 * Output: the number of notifications that will be sent
 * during the n days.
 * 
 * Notifications are sent when: expenditure for current
 * day is higher or equal than 2 times the median for
 * the trailing numbers.
 * 
 * Example:
 * d = 3
 * expenditures = {10, 20, 30, 40, 50}
 *   10 => do nothing // d = 1
 *   20 => do nothing // d = 2
 *   30 => do nothing // d = 3
 *   40 => Median on trailing days = (10 + 20 + 30) / 3 = 20
 *   	   40 >= 2x20 (two times median) ---> notify
 *   50 => Median on trailing days = (20 + 30 + 40) / 3 = 30
 *         50 < 2x30 -----------------------> NOT notify
 *         
 * Number of notifications = 1
 * 
 * d = 5
 * expenditures = {2, 3, 4, 2, 3, 6, 8, 4, 5}
 * 		6 => median = (2+3+4+2+3) / 5 = 2.8 => 3
 *           6 >= 2x3 = YES -> NOTIFY
 *      8 => median (3+4+2+3+6) / 6 = 3.6 => 4               
 * 			 8 >= 2x4 = YES -> Notify
 * 		4 => median (4+2+3+6+8)/5 = 5
 * 			 4 >= 2x5 = NO  -> DO NOT NOTIFY
 * 		5 => median (2+3+6+8+3+4)/5 = 4.6 => 5
 * 			 5 => 2x5 = NO -> DO NOT NOTIFY
 * Number of notifications = 2
 * 
 * 1 - Iterate the expenditures from i = d
 * 2 - Median = sum from (j = d - i to d - 1), then divide by d ==> ROUND UP!
 * 3 - If expenditures[i] >= 2xMedian ===> COUNT 
 * 
 * 
 * TOOK ME 37 MINUTES, 
 * CODE DID NOT EXECUTE WITHIN THE TIME LIMITS
 */
public class HackerLandNationalBank {
	
	static int activityNotifications(int[] expenditure, int d) { // {10, 20, 30, 40, 50}, d = 3
			if (d >= expenditure.length) {// verify if equals is a problem
				return 0;
			}
		
			int notifications = 0;
			
			
			for (int i = d; i < expenditure.length; i++) {  // i = 4
				float median = 0;
				float sum = 0;
							
				for (int j = i - d; j < i; j++) { // j = 1; d-1 = 3				
					sum = sum + expenditure[j]; 				
				}
				
				median = sum / d;
				float median2 = 2 * median;
				
				if (expenditure[i] >= median2) {				
					notifications++;
				}
				
			}
			
			
			return notifications;
    }
	

}
