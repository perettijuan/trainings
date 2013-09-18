package com.jpp.structures.trees;

import org.junit.Test;



public class BinarySearchTreeTest {

    private static final int[] TEST_VALUES = {3,4,5,1,2,9,7,8,6};
    
    
    
    
    @Test
    public void insertionOrderTest() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        for(int i = 0; i < TEST_VALUES.length; i++) {
            bst.insert(TEST_VALUES[i]);
        }
        System.out.println(bst.preorderTraversal());
        bst.balance();
        System.out.println(bst.preorderTraversal());
    }
    
    
}
