package com.jpp.queue;

import com.jpp.queue.implementation.ListFifoQueue;



public class ListFifoQueueTest extends AbstractFifoQueueTests {

    @Override
    protected Queue<String> createQueue() {
        return new ListFifoQueue<String>();
    }

}
