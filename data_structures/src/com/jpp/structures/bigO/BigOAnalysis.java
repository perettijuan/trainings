package com.jpp.structures.bigO;

public class BigOAnalysis {


    /**
     * Returns the largest value in an array of non-negative integers. Order:
     */
    private static int compareToMax(int array[], int n) {
        int curMax, i;
        
        // Set to one for the first comparing
        int order = 1;

        if (n <= 0) {
            return -1;
        }

        curMax = array[0];

        for (i = 1; i < n; i++) {
            order++;
            if (array[i] > curMax) {
                curMax = array[i];
            }
        }
        System.out.println("compareToMax => n: " + n + " O(" + order + ")");
        return curMax;
    }

    /**
     * Returns the largest value in an array of non-negative integers. Order:
     */
    private static int compareToAll(int[] array, int n) {
        int i, j;
        boolean isMax;

        // Set to one for the first comparing
        int order = 1;

        if (n <= 0) {
            return -1;
        }

        for (i = n - 1; i > 0; i--) {
            isMax = true;
            for (j = 0; j < n; j++) {
                order++;
                if (array[j] > array[i]) {
                    isMax = false;
                    break;
                }
            }
            if (isMax)
                break;
        }
        
        System.out.println("compareToAll => n: " + n + " O(" + order + ")");
        
        return array[i];
    }

    private static final int[] VALUES_1 = { 1, 4, 6, 7, 8, 9, 5 };
    private static final int[] VALUES_2 = { 11, 46, 67, 78, 84, 93, 52, 90, 67, 43, 91, 32 };
    private static final int[] VALUES_3 = { 1, 4, 6, 7, 8, 9, 5, 54, 12, 14 };

    public static void main(String[] args) {
        System.out.println("-------- 1 ---------");
        System.out.println(compareToMax(VALUES_1, VALUES_1.length));
        System.out.println(compareToAll(VALUES_1, VALUES_1.length));
        System.out.println("-------- 2 ---------");
        System.out.println(compareToMax(VALUES_2, VALUES_2.length));
        System.out.println(compareToAll(VALUES_2, VALUES_2.length));
        System.out.println("-------- 3 ---------");
        System.out.println(compareToMax(VALUES_3, VALUES_3.length));
        System.out.println(compareToAll(VALUES_3, VALUES_3.length));
    }
}
