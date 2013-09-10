package com.jpp.effective.generics;

import java.util.Arrays;

public class Stack {


    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private Object[] elements;
    private int size = 0;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        Object result = elements[size--];
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}