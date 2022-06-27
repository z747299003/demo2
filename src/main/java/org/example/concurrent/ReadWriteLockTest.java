package org.example.concurrent;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    static ReentrantLock lock=new ReentrantLock();
    static ReentrantReadWriteLock reentrantReadWriteLock=new ReentrantReadWriteLock();
    static Lock readLock=reentrantReadWriteLock.readLock();
    static Lock writeLock=reentrantReadWriteLock.writeLock();

    public static void main(String[] args) {
        ReadWriteLockTest test=new ReadWriteLockTest();
        for (int i = 0; i < 18; i++) {
             new Thread(()->m1(lock)).start();
        }
        for (int i = 0; i < 2; i++) {
             new Thread(()->m2(lock)).start();
        }
    }
    static void m1(Lock lock){
        try {
            lock.lock();
            Thread.sleep(1000L);
            System.out.println("read over");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
    static void m2(Lock lock){
        try {
            lock.lock();
            Thread.sleep(1000L);
            System.out.println("write over");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
