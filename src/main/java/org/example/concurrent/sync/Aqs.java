package org.example.concurrent.sync;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Hello world!
 */
public class Aqs {
    public static void main(String[] args) {
        ReentrantLock reentrantLock=new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();
        System.out.println("Hello World!");
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.addAll(Arrays.asList("1", "2"));
        AbstractQueuedSynchronizer aqs = new AbstractQueuedSynchronizer() {
            @Override
            protected boolean tryAcquire(int arg) {
                return super.tryAcquire(arg);
            }
        };
    }
}
