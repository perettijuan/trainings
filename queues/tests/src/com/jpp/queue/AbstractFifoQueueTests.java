package com.jpp.queue;

import static junit.framework.Assert.*;

import org.junit.Before;
import org.junit.Test;

public abstract class AbstractFifoQueueTests {


    private static final String VALUE_A = "A";
    private static final String VALUE_B = "B";
    private static final String VALUE_C = "C";

    private Queue<String> mQueue;

    @Before
    public void setUp() {
        mQueue = createQueue();
    }

    protected abstract Queue<String> createQueue();

    @Test
    public void accessAnEmptyQueue() {
        assertEquals(0, mQueue.size());
        assertTrue(mQueue.isEmpty());

        try {
            mQueue.dequeue();
            fail();
        } catch (EmptyQueueException e) {
            // expected
        }
    }

    @Test
    public void enqueueDequeue() {
        mQueue.clear();

        mQueue.enqueue(VALUE_B);
        mQueue.enqueue(VALUE_A);
        mQueue.enqueue(VALUE_C);

        assertEquals(3, mQueue.size());
        assertFalse(mQueue.isEmpty());

        assertSame(VALUE_B, mQueue.dequeue());
        assertEquals(2, mQueue.size());
        assertFalse(mQueue.isEmpty());

        assertSame(VALUE_A, mQueue.dequeue());
        assertEquals(1, mQueue.size());
        assertFalse(mQueue.isEmpty());

        assertSame(VALUE_C, mQueue.dequeue());
        assertEquals(0, mQueue.size());
        assertTrue(mQueue.isEmpty());

        try {
            mQueue.dequeue();
            fail();
        } catch (EmptyQueueException e) {
            // expected
        }
    }

    @Test
    public void clearQueue() {
        mQueue.enqueue(VALUE_B);
        mQueue.enqueue(VALUE_A);
        mQueue.enqueue(VALUE_C);

        assertFalse(mQueue.isEmpty());

        mQueue.clear();

        assertEquals(0, mQueue.size());
        assertTrue(mQueue.isEmpty());

        try {
            mQueue.dequeue();
            fail();
        } catch (EmptyQueueException e) {
            // expected
        }
    }

}
