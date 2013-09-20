package com.jpp.queue.example;

public class CallCenterSimulator {


    private static final int NUMBER_OF_AGENTS_ARG = 10;
    private static final int NUMBER_OF_CALLS_ARG = 150;
    private static final int MAX_CALL_DURATION_ARG = 2;
    private static final int MAX_CALL_INTERVAL_ARG = 3;

    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter(NUMBER_OF_AGENTS_ARG);
        CallGenerator generator = new CallGenerator(callCenter, NUMBER_OF_CALLS_ARG, MAX_CALL_DURATION_ARG, MAX_CALL_INTERVAL_ARG);
        callCenter.open();
        try {
            generator.generateCalls();
        } finally {
            callCenter.close();
        }
    }

}
