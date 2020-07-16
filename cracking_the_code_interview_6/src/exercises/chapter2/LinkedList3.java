package exercises.chapter2;

/**
 * 
 * Delete Middle Node: Implement an algorithm to delete a node in the middle
 * (i.e., any node but the first and last node, not necessarily the exact
 * middle) of a singly linked list, given only access to that node.
 * 
 * EXAMPLE Input:the node c from the linked list a -> b -> c -> d -> e -> f
 * Result: nothing is returned, but the new linked list looks like a -> b -> d -> e -> f
 * 
 * Input: b in a -> b -> c 
 * Result: a -> c
 * 
 * 
 * Idea: shift the node to the last position and then nullify. 
 * Question related to that idea: is Node an immutable object? ==> Answer: yes.
 *
 */
public class LinkedList3 {
	
	public static <T> void deleteNodeInMiddle(Node<T> node) {
		  if (node == null) {
		      throw new NullPointerException("node input can not be null");
		  }

		  if (node.getNext() == null) {
		      throw new IllegalArgumentException("Input node must be in the middle of the list");
		  }

		  Node<T> next = node.getNext();
		  node.setValue(next.getValue());
		  node.setNext(next.getNext());
		}
}
