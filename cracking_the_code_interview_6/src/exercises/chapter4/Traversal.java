package exercises.chapter4;

import java.util.List;

public class Traversal {

	public static <T> void inOrderTraversal(JTreeNode<T> node, List<T> toPrint) {
		if (node != null) {
			inOrderTraversal(node.getLeftChild(), toPrint);
			toPrint.add(node.getValue());
			inOrderTraversal(node.getRightChild(), toPrint);
		}
	}

	public static <T> void preOrderTraversal(JTreeNode<T> node, List<T> toPrint) {
		if (node != null) {
			toPrint.add(node.getValue());
			preOrderTraversal(node.getLeftChild(), toPrint);
			preOrderTraversal(node.getRightChild(), toPrint);
		}
	}
	
	public static <T> void postOrderTraversal(JTreeNode<T> node, List<T> toPrint) {
		if (node != null) {
			postOrderTraversal(node.getLeftChild(), toPrint);
			postOrderTraversal(node.getRightChild(), toPrint);
			toPrint.add(node.getValue());
		}
	}

}
