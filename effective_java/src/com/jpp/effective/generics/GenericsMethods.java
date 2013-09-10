package com.jpp.effective.generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GenericsMethods {


    /*
     * Compiles, but with warnings.
     */
    private static Set unsafeMerge(Set set1, Set set2) {
        Set result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    /*
     * Compiles safety
     */
    private static <E> Set<E> merge(Set<E> set1, Set<E> set2) {
        Set<E> result = new HashSet<E>(set1);
        result.addAll(set2);
        return result;
    }
    
    
    public static void main(String[] args) {
        Set<String> guys = new HashSet<String>(Arrays.asList("Tom", "Dick", "Harry"));
        Set<String> stooges = new HashSet<String>(Arrays.asList("Larry", "Moe", "Currly"));
        Set<String> unsafeUnion = unsafeMerge(guys, stooges);
        System.out.println(unsafeUnion);
        Set<String> safeUnion = merge(guys, stooges);
        System.out.println(safeUnion);
    }
}