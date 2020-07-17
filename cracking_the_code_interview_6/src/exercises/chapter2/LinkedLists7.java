package exercises.chapter2;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Intersection: Given two (singly) linked lists, determine if the two lists
 * intersect. Return the inter­secting node.
 * 
 * Input: 
 *  	List1 => 1 -> 3 -> 6 -> 7 -> 20 -> 5 
 *  	List2 => 2 -> 4 -> 8 -> 5 -> 12 -> 13
 * Intersection Node = 5
 * 
 * 
 * Input: 
 * 		List1 => 1 -> 3 -> 6 -> 7 -> 20 -> 5 
 * 		List2 => 2 -> 1 -> 8 -> 5 -> 12 -> 13
 * Intersection Node = 1
 * 
 * Input: 
 * 		List1 => 1 -> 3 -> 6 -> 7 -> 20 -> 10 
 * 		List2 => 2 -> 4 -> 8 -> 5 -> 12 -> 13
 * Intersection Node = null
 * 
 * 
 * Initial approach: Iterate and compare both lists
 */

public class LinkedLists7 {
	
	public static <T extends Comparable<T>> Node<T> findIntersection(Node<T> input1, Node<T> input2) {
		Node<T> intersect = null;
		
		Node<T> current1 = input1;
		while (current1 != null) {
			Node<T> current2 = input2;
			while (current2 != null) {
				if (current1.getValue() == current2.getValue()) {
					intersect = current1;
					break;
				}
				current2 = current2.getNext();
			}

			if (intersect != null) {
				break;
			}

			current1 = current1.getNext();
		}
		return intersect;
	}
	
	
	public static <T extends Comparable<T>> Node<T> findIntersectionImproved(Node<T> input1, Node<T> input2) {
		Node<T> intersect = null;
		
		Node<T> current1 = input1;
		Set<Node<T>> set = new HashSet<>();
		while (current1 != null) {
			set.add(current1);
			current1 = current1.getNext();
		}
		
		Node<T> current2 = input2;
		while (current2 != null) {
			if (set.contains(current2)) {
				intersect = current2;
				break;
			}
			current2 = current2.getNext();
		}
		
		return intersect;
	}

}
