package exercises.chapter2;

/**
 * 
 * Partition: Write code to partition a linked list around a value x, such that
 * all nodes less than x come before all nodes greater than or equal to x. If x
 * is contained within the list, the values of x only need to be after the
 * elements less than x (see below). // there is no need to sort the right side
 * partition. The partition element x can appear anywhere in the "right
 * partition"; it does not need to appear between the left and right partitions.
 * // no need to sort.
 * 
 * EXAMPLE Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1[partition=5] 
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 * 
 * Input: 6 -> 18 -> 7 -> 3 -> 5 -> 11 -> 21 -> 10 [partition = 11] 
 * Output: 6 -> 7 -> 3 -> 5 -> 10 -> 18 -> 11 -> 21
 * 
 * Input: 3 -> 7 -> 1 -> 5 -> 8 -> 9 [partition = 6] 
 * Output: 3 -> 1 -> 5 -> 7 -> 8 -> 9
 * 
 * 
 * Approach: create two lists left partition right partition Iterate the list
 * and determinate to which partition belongs the node. Add it to that partition
 * (at the beginning or the end since no sorting is needed). Merge the two
 * partitions.
 * 
 * The complex part might be how to add a new node to the partition: just put it
 * at the beginning by doing current.next = start; start = current.
 */
public class LinkedLists4 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Node<Integer> createPartitions(Node<Integer> head, Integer partition) { 
		Node<Integer> headLeft = null;
		Node<Integer> tailLeft = null;
		Node<Integer> headRight = null;
		Node<Integer> current = head;

		while (current != null) { // 1		
			if (current.getValue() < partition) {			
				if (tailLeft == null) {
					tailLeft = new Node(current.getValue());
					headLeft = tailLeft;
				} else {
					tailLeft.setNext(new Node(current.getValue()));
					tailLeft = tailLeft.getNext();
				}
			} else {
				if (headRight == null) {					
					headRight = new Node(current.getValue());
				} else {				
					appendToEnd(headRight, new Node(current.getValue()));
				}
			}
			current = current.getNext(); 
		}

		// merge the two lists
		tailLeft.setNext(headRight);

		return headLeft;
	}

	private static <T extends Comparable<T>> void appendToEnd(Node<T> head, Node<T> toAppend) { // 5 -> 8 -> 5, 10
		Node<T> currentLast = head; // currentLast = 5
		while (currentLast.getNext() != null) { // currentLast.getNext() = null -> true		
			currentLast = currentLast.getNext(); // currentLast = 5
		}
		currentLast.setNext(toAppend); // 5 -> 8 -> 5 -> 10
	}

}
