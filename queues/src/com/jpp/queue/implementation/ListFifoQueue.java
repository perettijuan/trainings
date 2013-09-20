package com.jpp.queue.implementation;

import java.util.LinkedList;
import java.util.List;

import com.jpp.queue.EmptyQueueException;
import com.jpp.queue.Queue;

public class ListFifoQueue<T> implements Queue<T> {


    private List<T> mList;

    public ListFifoQueue(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("list parameter can not be null");
        }
        mList = new LinkedList<T>(list);
    }

    public ListFifoQueue() {
        this(new LinkedList<T>());
    }

    @Override
    public void enqueue(T value) {
        mList.add(value);
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return mList.remove(0);
    }

    @Override
    public void clear() {
        mList.clear();
    }

    @Override
    public int size() {
        return mList.size();
    }

    @Override
    public boolean isEmpty() {
        return mList.isEmpty();
    }

}
