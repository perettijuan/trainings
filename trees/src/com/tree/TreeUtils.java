package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Utility methods used with the {@link Node} implementation
 * 
 * @author Juan P. Peretti (peretti.juan@gmail.com)
 * 
 * @param <T>
 */
public class TreeUtils<T extends Comparable<T>> {

	private boolean shouldLogStep = false;
	private int mStep = 0;

	/**
	 * Performs a lookup of the value in the given tree.
	 * 
	 * @param root
	 *            - the {@link Node} that represents the root of the tree.
	 * @param value
	 *            - the value to lookup for.
	 * @param logStep
	 *            - flag to indicate if each step of the process needs to be
	 *            printed in console.
	 * @return - true if the value is found, false any other case.
	 */
	public boolean lookUp(Node<T> root, T value, boolean logStep) {
		boolean found = false;
		shouldLogStep = logStep;
		if (root == null) {
			logStep("The tree root is null");
			return false;
		}

		if (value == null) {
			logStep("The value to lookup is null");
			return false;
		}

		T rootValue = root.getValue();

		logStep("root value " + rootValue);
		logStep("value to lookup" + value);

		int compare = value.compareTo(rootValue);

		logStep("COMPARISSION => " + compare);

		if (compare == 0) {
			found = true;
			logStep("Found in step: " + mStep);
		} else if (compare > 0) {
			mStep++;
			logStep("go right");
			lookUp(root.getRight(), value, logStep);
		} else {
			logStep("go left");
			mStep++;
			lookUp(root.getLeft(), value, logStep);
		}

		return found;
	}

	/**
	 * Performs an pre-order traversal of the given BST.
	 * 
	 * @param root
	 *            - the root of the BST.
	 * @return - an ordered list with the elements in the BST printed in
	 *         pre-order.
	 */
	public List<T> preOrderTraversal(Node<T> root) {
		assert root != null : "The root of the BST cannot be null";

		List<T> list = new ArrayList<T>();

		return preOrderTraversal(root, list);
	}

	/**
	 * Performs the actual traversal
	 */
	private List<T> preOrderTraversal(Node<T> root, List<T> list) {
		if (root != null) {
			T value = root.getValue();
			list.add(value);
			preOrderTraversal(root.getLeft(), list);
			preOrderTraversal(root.getRight(), list);
		}
		return list;
	}

	/**
	 * Performs a pre-order traversal in the given BST
	 * 
	 * @param root
	 *            - the root element of the BST.
	 * @return
	 */
	public List<T> preorderTraversalNoRecursion(Node<T> root) {
		assert root != null : "The root of the BST cannot be null";

		List<T> list = new ArrayList<T>();
		Stack<Node<T>> stack = new Stack<Node<T>>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node<T> current = stack.pop();
			T value = current.getValue();
			list.add(value);

			Node<T> right = current.getRight();
			if (right != null) {
				stack.add(right);
			}

			Node<T> left = current.getLeft();
			if (left != null) {
				stack.add(left);
			}

		}

		return list;
	}

	/**
	 * Performs an in-order traversal of the given BST.
	 * 
	 * @param root
	 *            - the root of the BST.
	 * @return - an ordered list with the elements in the BST printed in order.
	 */
	public List<T> inOrderTraversal(Node<T> root) {
		assert root != null : "The root of the BST cannot be null";

		List<T> list = new ArrayList<T>();

		return inOrderTraversal(root, list);
	}

	/**
	 * Performs the actual traversal
	 */
	private List<T> inOrderTraversal(Node<T> root, List<T> list) {
		if (root != null) {
			T value = root.getValue();
			inOrderTraversal(root.getLeft(), list);
			list.add(value);
			inOrderTraversal(root.getRight(), list);
		}
		return list;
	}

	/**
	 * Performs an post-order traversal of the given BST.
	 * 
	 * @param root
	 *            - the root of the BST.
	 * @return - an ordered list with the elements in the BST printed in
	 *         post-order.
	 */
	public List<T> postOrderTraversal(Node<T> root) {
		assert root != null : "The root of the BST cannot be null";

		List<T> list = new ArrayList<T>();

		return postOrderTraversal(root, list);
	}

	/**
	 * Performs the actual traversal
	 */
	private List<T> postOrderTraversal(Node<T> root, List<T> list) {
		if (root != null) {
			T value = root.getValue();
			postOrderTraversal(root.getLeft(), list);
			postOrderTraversal(root.getRight(), list);
			list.add(value);
		}
		return list;
	}

	/**
	 * Performs a breath first search printing all levels into a {@link List}
	 * 
	 * @param root
	 *            - the root element of the BST.
	 * @return - the {@link List} with the elements in it.
	 */
	public List<T> breathFirstSearchPrintResult(Node<T> root) {
		assert root != null : "The root of the BST cannot be null";

		List<T> list = new ArrayList<T>();

		Queue<Node<T>> q = new LinkedList<Node<T>>();
		q.add(root);

		while (!q.isEmpty()) {
			Node<T> current = q.remove();
			list.add(current.getValue());

			Node<T> left = current.getLeft();

			if (left != null) {
				q.add(left);
			}

			Node<T> right = current.getRight();
			if (right != null) {
				q.add(right);
			}
		}

		return list;
	}

	/**
	 * Perform a Deep First Search on the given BST.
	 * 
	 * @param root
	 *            - the root element of the BTS.
	 * @return - the {@link List} with the elements in it.
	 */
	public List<T> deepFirstSearchPrintresult(Node<T> root) {
		assert root != null : "The root of the BST cannot be null";

		List<T> list = new ArrayList<T>();
		Stack<Node<T>> stack = new Stack<Node<T>>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node<T> current = stack.pop();
			list.add(current.getValue());

			Node<T> right = current.getRight();
			if (right != null) {
				stack.push(right);
			}

			Node<T> left = current.getLeft();
			if (left != null) {
				stack.push(left);
			}
		}

		return list;
	}

	/**
	 * Finds the lowest common ancestor between two nodes (if there is any)
	 * 
	 * @param root
	 *            - the root element for the BST.
	 * @param n1
	 *            - the lower limit to look for.
	 * @param n2
	 *            - the higher limit to look for.
	 * @return - the lowest common ancestor if any.
	 */
	public Node<T> lowestCommonAncestor(Node<T> root, Node<T> n1, Node<T> n2) {

		if (root == null) {
			return null;
		}

		T rootValue = root.getValue();
		T left = n1.getValue();
		T right = n2.getValue();

		Node<T> found = null;

		boolean isRootHigherThanLeft = rootValue.compareTo(left) >= 0;
		boolean isRootLowerThanRight = rootValue.compareTo(right) < 0;

		if (isRootHigherThanLeft && isRootLowerThanRight) {
			found = root;
		} else if (isRootHigherThanLeft) {
			Node<T> leftNode = root.getLeft();
			if (leftNode != null) {
				found = lowestCommonAncestor(leftNode, n1, n2);
			}
		} else if (isRootLowerThanRight) {
			Node<T> rightNode = root.getRight();
			if (rightNode != null) {
				found = lowestCommonAncestor(rightNode, n1, n2);
			}
		}
		return found;
	}

	/**
	 * Determinate if a tree is a BST
	 * 
	 * @param root
	 *            - the root node of the tree.
	 * @return - true if it is a BST, false any other case.
	 */
	public boolean isBST(Node<T> root) {

		if (root == null) {
			return true;
		}

		T current = root.getValue();

		Node<T> leftNode = root.getLeft();

		if ((leftNode != null) && current.compareTo(leftNode.getValue()) < 0) {
			return false;
		}

		Node<T> rightNode = root.getRight();

		if ((rightNode != null) && current.compareTo(rightNode.getValue()) > 0) {
			return false;
		}

		if (!isBST(leftNode) || !isBST(rightNode)) {
			return false;
		}

		return true;
	}

	/**
	 * Finds the height of the tree
	 * 
	 * @param n
	 * @return
	 */
	public int height(Node<T> n) {
		if (n == null) {
			return 0;
		}

		return 1 + Math.max(height(n.getLeft()), height(n.getRight()));
	}

	private void logStep(String step) {
		if (shouldLogStep) {
			System.out.println(step);
		}
	}

}
