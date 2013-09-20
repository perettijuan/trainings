package com.jpp.queue.implementation;

import com.jpp.queue.EmptyQueueException;
import com.jpp.queue.Queue;

/**
 * {@link Queue} implementation of a blocking queue to use under multi-threading
 * environments
 * 
 * @author Juan Peretti
 * 
 * @param <T>
 *            - the generic type to be held by this queue.
 */
public class BloquingQueue<T> implements Queue<T> {


    private final Object mMutex = new Object();
    private final Queue<T> mQueue;
    private final int mMaxSize;

    public BloquingQueue(Queue<T> queue, int maxSize) {
        if (queue == null) {
            throw new IllegalArgumentException("queue can not be null");
        }

        if (maxSize < 0) {
            throw new IllegalArgumentException("size can not be negative");
        }

        mQueue = queue;
        mMaxSize = maxSize;
    }

    public BloquingQueue(Queue<T> queue) {
        this(queue, Integer.MAX_VALUE);
    }

    @Override
    public void enqueue(T value) {
        synchronized (mMutex) {
            while (size() == mMaxSize) {
                waitForNotification();
            }
            mQueue.enqueue(value);
            mMutex.notifyAll();
        }
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        synchronized (mMutex) {
            while (isEmpty()) {
                waitForNotification();
            }
            T value = mQueue.dequeue();
            mMutex.notifyAll();
            return value;
        }
    }

    @Override
    public void clear() {
        synchronized (mMutex) {
            mQueue.clear();
            mMutex.notifyAll();
        }
    }

    @Override
    public int size() {
        synchronized (mMutex) {
            return mQueue.size();
        }
    }

    @Override
    public boolean isEmpty() {
        synchronized (mMutex) {
            return mQueue.isEmpty();
        }
    }

    private void waitForNotification() {
        try {
            mMutex.wait();
        } catch (InterruptedException e) {
            // Ignore
        }
    }

}
