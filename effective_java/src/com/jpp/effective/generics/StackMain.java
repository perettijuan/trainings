package com.jpp.effective.generics;

public class StackMain {


    public static void main(String[] args) {
        Integer el0 = new Integer(8);
        Integer el1 = new Integer(7);
        Integer el2 = new Integer(6);
        Integer el3 = new Integer(5);
        Integer el4 = new Integer(4);
        Integer el5 = new Integer(3);
        String corrupted = "Fails at runtime!!!";
        Stack stack = new Stack();
        stack.push(el0);
        stack.push(el1);
        stack.push(el2);
        stack.push(corrupted);
        stack.push(el3);
        stack.push(el4);
        stack.push(el5);

        GenericStack<Integer> genStack = new GenericStack<Integer>();
        genStack.push(el0);
        genStack.push(el1);
        genStack.push(el2);
        genStack.push(el3);
        genStack.push(el4);
        genStack.push(el5);
        // doesn't compile
        // genStack.push(corrupted);
        
        
        
        while(!genStack.isEmpty()) {
            // no cast needed
            Integer current = genStack.pop();
            System.out.println(current);
        }
        
        while (!stack.isEmpty()) {
            Integer current = (Integer) stack.pop();
            System.out.println(current);
        }

    }

}