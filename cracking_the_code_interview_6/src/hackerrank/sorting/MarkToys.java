package hackerrank.sorting;

/*
 * Maximum number of toys he can buy.
 * 
 * input {1, 2, 3, 4}
 * k = 7
 *     1,2,3 = 6 
 *     3,4   = 7
 *	Winner is the first group = can buy 6
 *
 *
 * input {1, 12, 5, 111, 200, 1000, 10}
 * k = 50
 * 		1, 12, 5, 10
 * 
 * input {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
 * k = 8
 * 		1, 2, 3 = 6
 * 		4, 3, 1 = 8
 * 		5
 * 		6
 * 		7
 * input {3, 7, 2, 9, 4} = {2, 3, 4, 7, 9}
 * k = 15
 * 		2, 3, 4 = 9
 * 		3, 4, 7 = 14
 * 		 
 * 
 * Possible solution:
 *  1 - Sort the array.
 *  2 - Binary search (k).
 *  3 - Found the combinations:
 * 			The closest the number to k, less chances to be able to sum without > k
 * 			Iterate from 0 to k (i)
 * 				value = input[i]
 * 				Iterate from i to k (j)
 * 					value = input[j] + value 
 * 					if (value < k) {
 * 						maxAmount = maxAmount + 1
 * 					}	
 * 					
 * SOLVED (TIME OUT)
 */
public class MarkToys {
	
	
	// Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) { // {3, 7, 2, 9, 4}, k = 15
    	int maxToys = 0;
    	//Arrays.sort(prices);// {2, 3, 4, 7, 9}
    	quickSort(prices, 0, prices.length - 1);
    	
    	for (int i = 0; i < prices.length; i++) { // i = 2
    		 if (prices[i] >= k) {  // prices[i] = 4; k = 15
    			 break;
    		 }
    		     		
    		 long value = prices[i]; // value = 4
    		 int localMaxToys = 1; // localMaxToys = 1
    		     		
    		 for (int j = i + 1; j < prices.length; j++) { // j = 3
    			 value = value + prices[j]; // prices[j] = 7 => value = 23
    			 if (value < k) {
    				 localMaxToys = localMaxToys + 1; // localMaxToys = 3
    			 }
    		 }
    		 
    		 if (localMaxToys > maxToys) { // true
    			 maxToys = localMaxToys; // maxToys = 3
    		 }    	
    	}
        return maxToys;
    }
    
    
    private static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
     
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }
    
    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);
     
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
     
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
     
        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;
     
        return i+1;
    }

}
