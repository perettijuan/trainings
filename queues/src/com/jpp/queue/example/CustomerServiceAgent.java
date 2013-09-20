package com.jpp.queue.example;

import com.jpp.queue.Queue;

/**
 * Responsible for pulling calls off a queue and answering them.
 * 
 * @author Juan Peretti
 * 
 */
public class CustomerServiceAgent implements Runnable {


    public static final Call GO_HOME = new Call(-1, 0);

    private final int mId;
    private final Queue<Call> mCalls;

    public CustomerServiceAgent(int id, Queue<Call> calls) {
        mId = id;
        mCalls = calls;
    }

    public String toString() {
        return "Agent " + mId;
    }

    @Override
    public void run() {
        System.out.println(this + " clocked on");

        while (true) {
            System.out.println(this + " waiting");

            Call call = mCalls.dequeue();
            System.out.println(this + " answering " + call);

            if (call == GO_HOME) {
                break;
            }

            call.answer();
        }
    }

}
