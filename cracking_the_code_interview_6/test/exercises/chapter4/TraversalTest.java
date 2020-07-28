package exercises.chapter4;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TraversalTest {
	
	
	@Test
	public void testInOrderTraversal() {
		JTreeNode<Integer> tree = prepareTree();
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(4);
		expected.add(5);
		expected.add(6);
		expected.add(7);
		expected.add(8);
		expected.add(9);
		expected.add(10);
		
		List<Integer> actual = new ArrayList<Integer>();
		
		Traversal.inOrderTraversal(tree, actual);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPreOrderTraversal() {
		JTreeNode<Integer> tree = prepareTree();
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(5);
		expected.add(3);
		expected.add(2);
		expected.add(1);
		expected.add(4);
		expected.add(8);
		expected.add(7);
		expected.add(6);
		expected.add(9);
		expected.add(10);
		
		List<Integer> actual = new ArrayList<Integer>();
		
		Traversal.preOrderTraversal(tree, actual);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPostOrderTraversal() {
		JTreeNode<Integer> tree = prepareTree();
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(1);
		expected.add(2);
		expected.add(4);
		expected.add(3);
		expected.add(6);
		expected.add(7);
		expected.add(10);
		expected.add(9);
		expected.add(8);
		expected.add(5);
		
		List<Integer> actual = new ArrayList<Integer>();
		
		Traversal.postOrderTraversal(tree, actual);
		
		assertEquals(expected, actual);
	}
	
	
	
	private JTreeNode<Integer> prepareTree() {
		JTreeNode<Integer> one = createNode(1);
		JTreeNode<Integer> two = createNode(2);
		JTreeNode<Integer> three = createNode(3);
		JTreeNode<Integer> four = createNode(4);
		JTreeNode<Integer> five = createNode(5);
		JTreeNode<Integer> six = createNode(6);
		JTreeNode<Integer> seven = createNode(7);
		JTreeNode<Integer> eight = createNode(8);
		JTreeNode<Integer> nine = createNode(9);
		JTreeNode<Integer> ten = createNode(10);
		
		five.setLeftChild(three);
		five.setRightChild(eight);
		
		three.setLeftChild(two);
		three.setRightChild(four);
		
		two.setLeftChild(one);
		
		eight.setLeftChild(seven);
		eight.setRightChild(nine);
		
		seven.setLeftChild(six);
		
		nine.setRightChild(ten);
		
		return five;
	}
	
	private JTreeNode<Integer> createNode(int value) {
		return new JTreeNode<Integer>(value);
	}

}
