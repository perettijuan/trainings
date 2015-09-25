package com.tree.main;

import java.util.List;

import com.tree.Node;
import com.tree.TreeUtils;

public class Main {

	public static void main(String[] args) {
		loockUp();
		preOrderTraversal();
		preOrderTraversalNoRecursion();
		inOrderTraversal();
		postOrderTraversal();
		breathFirstSearch();
		deepFirstSearch();
		height();
		lowestCommonAncestor();
		isBST();
	}

	private static void loockUp() {
		IntegerValue valueToLookup = new IntegerValue(7);
		Node<IntegerValue> root = generateBST();
		TreeUtils<IntegerValue> utils = new TreeUtils<IntegerValue>();
		System.out.println("--------LOOKUP START--------");
		utils.lookUp(root, valueToLookup, true);
		System.out.println("--------LOOKUP END--------");
	}

	private static void preOrderTraversal() {
		Node<IntegerValue> root = generateBST();
		TreeUtils<IntegerValue> utils = new TreeUtils<IntegerValue>();
		System.out.println("--------PRE ORDER TRAVERSAL START--------");
		List<IntegerValue> values = utils.preOrderTraversal(root);
		System.out.println(values);
		System.out.println("--------PRE ORDER TRAVERSAL END--------");
	}
	
	
	private static void preOrderTraversalNoRecursion() {
		Node<IntegerValue> root = generateBST();
		TreeUtils<IntegerValue> utils = new TreeUtils<IntegerValue>();
		System.out.println("--------PRE ORDER TRAVERSAL NO RECURSION START--------");
		List<IntegerValue> values = utils.preorderTraversalNoRecursion(root);
		System.out.println(values);
		System.out.println("--------PRE ORDER TRAVERSAL NO RECURSION END--------");
	}

	private static void inOrderTraversal() {
		Node<IntegerValue> root = generateBST();
		TreeUtils<IntegerValue> utils = new TreeUtils<IntegerValue>();
		System.out.println("--------IN ORDER TRAVERSAL START--------");
		List<IntegerValue> values = utils.inOrderTraversal(root);
		System.out.println(values);
		System.out.println("--------IN ORDER TRAVERSAL END--------");
	}

	private static void breathFirstSearch() {
		Node<IntegerValue> root = generateBST();
		TreeUtils<IntegerValue> utils = new TreeUtils<IntegerValue>();
		System.out.println("--------BREATH FIRST SEARCH START--------");
		List<IntegerValue> values = utils.breathFirstSearchPrintResult(root);
		System.out.println(values);
		System.out.println("--------BREATH FIRST SEARCH END--------");
	}

	private static void deepFirstSearch() {
		Node<IntegerValue> root = generateBST();
		TreeUtils<IntegerValue> utils = new TreeUtils<IntegerValue>();
		System.out.println("--------DEEP FIRST SEARCH START--------");
		List<IntegerValue> values = utils.deepFirstSearchPrintresult(root);
		System.out.println(values);
		System.out.println("--------DEEP FIRST SEARCH END--------");
	}

	private static void postOrderTraversal() {
		Node<IntegerValue> root = generateBST();
		TreeUtils<IntegerValue> utils = new TreeUtils<IntegerValue>();
		System.out.println("--------POST ORDER TRAVERSAL START--------");
		List<IntegerValue> values = utils.postOrderTraversal(root);
		System.out.println(values);
		System.out.println("--------POST ORDER TRAVERSAL END--------");
	}

	private static void height() {
		Node<IntegerValue> root = generateBST();
		TreeUtils<IntegerValue> utils = new TreeUtils<IntegerValue>();
		System.out.println("--------HEIGHT OF BST--------");
		int height = utils.height(root);
		System.out.println("HEIGHT --> " + height);
		System.out.println("--------HEIGHT OF BST--------");
	}

	private static void lowestCommonAncestor() {
		Node<IntegerValue> root = generateBSTForLowerCommonAncestor();
		TreeUtils<IntegerValue> utils = new TreeUtils<IntegerValue>();
		System.out.println("--------LOWEST COMMON ANCESTOR--------");
		Node<IntegerValue> n1 = new Node<IntegerValue>(new IntegerValue(8));
		Node<IntegerValue> n2 = new Node<IntegerValue>(new IntegerValue(12));
		Node<IntegerValue> lca = utils.lowestCommonAncestor(root, n1, n2);
		IntegerValue value = lca.getValue();
		System.out.println("LOWEST COMMON ANCESTOR => " + value.toString());
		System.out.println("--------LOWEST COMMON ANCESTOR--------");
	}
	
	
	private static void isBST() {
		Node<IntegerValue> root = generateBST();
		TreeUtils<IntegerValue> utils = new TreeUtils<IntegerValue>();
		System.out.println("--------IS BINARY SEARCH TREE--------");
		boolean isBST = utils.isBST(root);
		System.out.println("BST => " + isBST);
		System.out.println("--------IS BINARY SEARCH TREE--------");
	}

	private static Node<IntegerValue> generateBST() {
		IntegerValue rootValue = new IntegerValue(5);
		Node<IntegerValue> root = new Node<IntegerValue>(rootValue);

		Node<IntegerValue> left = new Node<IntegerValue>(new IntegerValue(3));
		Node<IntegerValue> right = new Node<IntegerValue>(new IntegerValue(10));
		root.setLeft(left);
		root.setRight(right);

		Node<IntegerValue> left1 = new Node<IntegerValue>(new IntegerValue(1));
		Node<IntegerValue> right1 = new Node<IntegerValue>(new IntegerValue(4));
		left.setLeft(left1);
		left.setRight(right1);

		Node<IntegerValue> left2 = new Node<IntegerValue>(new IntegerValue(7));
		Node<IntegerValue> right2 = new Node<IntegerValue>(new IntegerValue(12));
		right.setLeft(left2);
		right.setRight(right2);

		return root;
	}
	
	
	
	private static Node<IntegerValue> generateBSTForLowerCommonAncestor() {
		IntegerValue rootValue = new IntegerValue(5);
		Node<IntegerValue> root = new Node<IntegerValue>(rootValue);

		Node<IntegerValue> left = new Node<IntegerValue>(new IntegerValue(3));
		Node<IntegerValue> right = new Node<IntegerValue>(new IntegerValue(10));
		root.setLeft(left);
		root.setRight(right);

		Node<IntegerValue> left1 = new Node<IntegerValue>(new IntegerValue(1));
		Node<IntegerValue> right1 = new Node<IntegerValue>(new IntegerValue(4));
		left.setLeft(left1);
		left.setRight(right1);

		Node<IntegerValue> left2 = new Node<IntegerValue>(new IntegerValue(7));
		Node<IntegerValue> right2 = new Node<IntegerValue>(new IntegerValue(12));
		right.setLeft(left2);
		right.setRight(right2);
		
		
		Node<IntegerValue> right3 = new Node<IntegerValue>(new IntegerValue(8));		
		left2.setRight(right3);

		return root;
	}
}
