package com.jpp.queue.example;

public class CallGenerator {


    private final CallCenter mCallCenter;
    private final int mNumberOfCalls;
    private final int mMaxCallDuration;
    private final int mMaxCallInterval;

    public CallGenerator(CallCenter callCenter, int numberOfCalls, int maxCallDuration, int maxCallInterval) {
        mCallCenter = callCenter;
        mNumberOfCalls = numberOfCalls;
        mMaxCallDuration = maxCallDuration;
        mMaxCallInterval = maxCallInterval;
    }

    public void generateCalls() {
        for (int i = 0; i < mNumberOfCalls; i++) {
            sleep();
            mCallCenter.accept(new Call(i, (int) (Math.random() * mMaxCallDuration)));
        }
    }

    private void sleep() {
        try {
            Thread.sleep((int) (Math.random() * mMaxCallInterval));
        } catch (InterruptedException e) {
            // Ignore
        }
    }

}
