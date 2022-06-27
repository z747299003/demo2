package org.example.concurrent;

import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderTest {
    public static long count1 = 0L;
    public static AtomicLong atomicLong = new AtomicLong(0L);
    public static LongAdder longAdder = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[1000];
        Object lock=new Object();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {

                for (int j = 0; j < 100000; j++) {
                    synchronized (lock) {
                        count1++;
                    }
                }
            });
        }
        long startTime = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        System.out.println(count1);

        // atomic
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    atomicLong.incrementAndGet();
                }
            });
        }
        long startTime2 = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println(endTime2 - startTime2);
        System.out.println(atomicLong.get());

        //longadder
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    longAdder.increment();
                }
            });
        }
        long startTime3 = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        long endTime3 = System.currentTimeMillis();
        System.out.println(endTime3 - startTime3);
        System.out.println(longAdder.longValue());
    }
}

