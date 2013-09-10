package com.jpp.structures.linkedlists;

public class ListElement<T> {


    private T mData;
    private ListElement<T> mNext;

    public ListElement(T value) {
        mData = value;
    }

    public ListElement<T> next() {
        return mNext;
    }

    public T value() {
        return mData;
    }

    public void setNext(ListElement<T> next) {
        mNext = next;
    }

    public void setValue(T value) {
        mData = value;
    }

}
