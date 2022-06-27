package org.example.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.CheckedOutputStream;

public class AtomicIntegerTest implements Runnable{
    static AtomicInteger atomicInteger=new AtomicInteger(0);
    @Override
    public void run(){
        atomicInteger.incrementAndGet();//++运算
    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            new Thread(new AtomicIntegerTest()).start();
        }
        Thread.sleep(5000L);
        System.out.println(atomicInteger);
    }

}
