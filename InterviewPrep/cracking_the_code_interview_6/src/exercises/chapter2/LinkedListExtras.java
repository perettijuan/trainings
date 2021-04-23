package exercises.chapter2;

import java.util.ArrayList;
import java.util.List;

public class LinkedListExtras {

	public static Node<Integer> produceLinkedListFrom(int[] list) {
		Node<Integer> head = new Node<Integer>(list[0]);
		Node<Integer> current = head;
		for (int i = 1; i < list.length; i++) {
			if (current == null) {
				break;
			}
			current.setNext(new Node<Integer>(list[i]));
			current = current.getNext();
		}

		return head;
	}

	public static List<Integer> produceListFromLinkedList(Node<Integer> head) {
		ArrayList<Integer> result = new ArrayList<>();

		Node<Integer> current = head;
		while (current != null) {
			result.add(current.getValue());
			current = current.getNext();
		}

		return result;
	}

}
