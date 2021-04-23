package exercises.chapter2;

public class LinkedLists1 {

	public static <T extends Comparable<T>> Node<T> removeDuplicates(Node<T> head) {
		if (head.getNext() == null) {
			return head;
		}

		Node<T> current = head;
		while (current != null) {
			Node<T> trailing = current;
			Node<T> next = current.getNext();
			while (next != null) {
				if (current.getValue() == next.getValue()) {
					// remove next
					trailing.setNext(next.getNext());
				} else {
					trailing = next;
				}
				next = next.getNext();
			}
			current = current.getNext();
		}

		return head;
	}

}
