package com.jpp.queue.example;

/**
 * Represents a call within the system.
 * 
 * @author Juan Peretti
 * 
 */
public class Call {


    private final int mId;
    private final int mduration;
    private final long mStartTime;

    public Call(int id, int duration) {
        mId = id;
        mduration = duration;
        mStartTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Call " + mId;
    }

    public void answer() {
        System.out.println(this + " answered; waited " + (System.currentTimeMillis() - mStartTime) + " millisencods");

        try {
            Thread.sleep(mduration);
        } catch (InterruptedException e) {
            // ignore
        }
    }

}
