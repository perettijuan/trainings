package com.jpp.effective.generics;

import java.util.ArrayList;
import java.util.List;

public class RawTypeList {


    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        addUnsafe(strings, new Integer(42));
        String s = strings.get(0); // Compiler-generated cast
        System.out.println(s);
    }

    /**
     * Lesson: if you use a raw type, you lose type safety. Here, the parameter
     * list can accept any object in it's add method. So, if you insert a type A
     * into the list and after that, you obtain that reference into a type B
     * object, you will get a class cast exception.
     * 
     * Possible solution: use List<Object> in order to add type safety. This
     * will make the program no longer compiles.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static void addUnsafe(List list, Object o) {
        list.add(o);
    }

}