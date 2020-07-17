package exercises.chapter2;

/**
 * 
 * Sum Lists: You have two numbers represented by a linked list, where each node
 * contains a single digit. The digits are stored in reverse order, such that
 * the 1 's digit is at the head of the list. Write a function that adds the two
 * numbers and returns the sum as a linked list.
 * 
 * EXAMPLE Input:(7 -> 1 -> 6) + (5 -> 9 -> 2). That is,617 + 295. Output:2 -> 1
 * -> 9. That is, 912.
 * 
 * Input: (5 -> 2 -> 8) + (2 -> 3 -> 4). Is 825 + 432 Output:(7 -> 5 -> 2 -> 1)
 * is -> 1257
 * 
 * Input: (5 -> 2 -> 8) + (7 -> 9 -> 4). Is 825 + 497 Output:(2 -> 2 -> 3 -> 1)
 * is -> 1322
 * 
 * Questions: 1 - is it a singled linked list? ==> YES 2 - do I get two inputs?
 * ==> YES 3 - Does the numbers (or the lists) has the same length? ==> YES
 * 
 * 
 * Algorithm: 1 - Iterate both lists. 2 - Sum each node with the corresponding
 * one and the rest (calculate the rest on each sum by doing result - 10 // only
 * if it is a positive value).
 *
 */
public class LinkedLists5 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Node<Integer> sumNumbers(Node<Integer> num1, Node<Integer> num2) {

		  int carry = 0;
		  Node<Integer> current1 = num1;
		  Node<Integer> current2 = num2;
		  Node<Integer> result = null;

		  while (current1 != null && current2 != null) { 
		     int sum = current1.getValue() + current2.getValue();

		     if (carry > 0) {
		        sum = sum + carry;
		     }

		     if (sum > 9) {
		        carry = 1;
		        sum = sum - 10;
		     } else {
		        carry = 0;
		     }

		     if (result == null) {
		        result = new Node(sum);
		     } else {
		        appendToEnd(result, new Node(sum));
		     }

		     if (current1.getNext() == null && current2.getNext() == null && carry > 0) {
		        appendToEnd(result, new Node(carry));
		     }

		     current1 = current1.getNext();
		     current2 = current2.getNext();
		  }

		  return result;
		}

	private static void appendToEnd(Node<Integer> head, Node<Integer> newEnd) {
		Node<Integer> current = head;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(newEnd);
	}

}
