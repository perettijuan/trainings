package com.jpp.queue.example;

import java.util.ArrayList;
import java.util.List;

import com.jpp.queue.Queue;
import com.jpp.queue.implementation.BloquingQueue;
import com.jpp.queue.implementation.ListFifoQueue;

/**
 * Responsible for managing the agents and for placing calls on to a queue for
 * the agents to process.
 * 
 * @author Juan Peretti
 * 
 */
public class CallCenter {


    private final Queue<Call> mCalls = new BloquingQueue<Call>(new ListFifoQueue<Call>());

    private final List<Thread> mThreads;
    private final int mNumberOfAgents;

    public CallCenter(int numberOfAgents) {
        mNumberOfAgents = numberOfAgents;
        mThreads = new ArrayList<Thread>();
    }

    public void open() {
        System.out.println("Call center opening");

        for (int i = 0; i < mNumberOfAgents; i++) {
            Thread thread = new Thread(new CustomerServiceAgent(i, mCalls));
            thread.start();
            mThreads.add(thread);
        }

        System.out.println("Call center open");
    }

    public void accept(Call call) {
        mCalls.enqueue(call);
        System.out.println(call + " enqueued");
    }

    public void close() {
        System.out.println("Call center closing");

        for (int i = 0; i < mNumberOfAgents; i++) {
            accept(CustomerServiceAgent.GO_HOME);
        }

        for (Thread t : mThreads) {
            waitForTermination(t);
        }

        mThreads.clear();

        System.out.println("Call center closed");
    }

    private void waitForTermination(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            // ignore
        }
    }
}
