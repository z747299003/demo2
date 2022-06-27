package org.example.concurrent;

import java.util.concurrent.ConcurrentHashMap;

public class AddAndSub {
    public static volatile int i = 5;

    public static void add() {
        i += 5;
    }

    public static void sub() {
        i -= 5;
    }

    public static void main(String[] args) {

        ConcurrentHashMap<Long,String> concurrentHashMap=new ConcurrentHashMap();

        concurrentHashMap.put(1L,"456");
        concurrentHashMap.put(16L,"456");
        concurrentHashMap.put(17L,"456");
        String s = concurrentHashMap.get(17L);
    }
}
