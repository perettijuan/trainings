package com.jpp.structures.linkedlists;

/**
 * Represents an element in a linked list.
 * 
 * @author Juan Peretti
 * 
 * @param <T>
 */
public class ListElement<T> {


    private T mData;
    private ListElement<T> mNext;

    /**
     * Class constructor.
     * 
     * @param value
     *            - the value to hold as data.
     */
    public ListElement(T value) {
        if (value == null) {
            throw new NullPointerException("Value can not be null when creating a new list element");
        }
        mData = value;
    }

    /**
     * @return - returns the next element that this points.
     */
    public ListElement<T> next() {
        return mNext;
    }

    /**
     * @return - returns the data hold by this element.
     */
    public T value() {
        return mData;
    }

    /**
     * @param next
     *            - the next element in the list.
     */
    public void setNext(ListElement<T> next) {
        mNext = next;
    }    
    
}
