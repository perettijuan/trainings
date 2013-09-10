package com.jpp.effective.generics;

import java.util.Arrays;

public class GenericStack<E> {


    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private E[] elements;
    private int size = 0;

    /*
     * The elements array will contain only E instances from push(E). This is
     * sufficient to ensure type safety, but the runtime type of the array won't
     * be E[]; it will always be Object[]!
     */
    @SuppressWarnings("unchecked")
    public GenericStack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        E result = elements[size--];
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