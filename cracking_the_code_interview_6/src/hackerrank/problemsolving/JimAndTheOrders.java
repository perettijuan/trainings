package hackerrank.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
 * - Each customer is numbered from 1 to n.
 * - For each customer, we have order number and prep. time.
 * - Delivery time = order number + prep. time
 * - If two orders have the same delivery time, tie breaker is the customer number.
 * 
 * 
 * Example:  
 * Customer      1  2  3  4  5  
 * Order         8  5  6  2  4
 * Prep. Time    3  6  2  3  3
 * Delivery time 11 11 8  5  7
 * 
 * Output = 4, 5, 3, 1, 2
 * 
 * Customer      1  2  3  4  5  
 * Order         8  5  6  2  4
 * Prep. Time    3  6  5  9  7
 * Delivery time 11 11 11  11  11
 * 
 * Output = 1, 2, 3, 4, 5
 * 
 * 
 * Algorithm:
 *  - Calculate the delivery time (to compare them).
 *  - Create a customer class (id, delivery time).
 *  - I can create a collection (list) with the customers and sort it.
 * 
 */
public class JimAndTheOrders {

	
	static int[] jimOrders(int[][] orders) {
		ArrayList<Customer> customers = new  ArrayList<JimAndTheOrders.Customer>();
		int[] ret = new int[orders.length];
		
		for (int row = 0; row < orders.length; row++) {
			int order = orders[row][0];
			int prepTime = orders[row][1];
			int deliveryTime = order + prepTime;
			customers.add(new Customer(row + 1, deliveryTime));
		}
		
		Collections.sort(customers, new CustomerComparator());
		
		for (int i = 0; i < ret.length; i++) {
			ret[i] = customers.get(i).mId;
		}

		return ret;
    }
	
	
	static class Customer {
		int mId;
		int mDeliveryTime;
		
		Customer(int id, int deliveryTime) {
			mId = id;
			mDeliveryTime = deliveryTime;
		}
	}
	
	static class CustomerComparator implements Comparator<Customer> {

		@Override
		public int compare(Customer o1, Customer o2) {
			if (o1.mDeliveryTime == o2.mDeliveryTime) {
				if (o1.mId < o2.mId) {
					return -1;
				} else {
					return 1;
				}
			}
			
			
			if (o1.mDeliveryTime < o2.mDeliveryTime) {
				return -1;
			} else {
				return 1;
			}
		}
		
	}
}
