package org.example.concurrent.abc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTwoTest {
    public static void main(String[] args) {
        char[] numbers = "123456".toCharArray();
        char[] uppers = "ABCDEF".toCharArray();

        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition1 = reentrantLock.newCondition();
        Condition condition2 = reentrantLock.newCondition();

        new Thread(() -> {
            try {
                reentrantLock.lock();
                for (int i = 0; i < numbers.length; i++) {
                    System.out.println(numbers[i]);
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                reentrantLock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                reentrantLock.lock();
                for (int i = 0; i < uppers.length; i++) {
                    System.out.println(uppers[i]);
                    condition1.signal();
                    condition2.await();
                }
                condition1.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                reentrantLock.unlock();
            }
        }, "t1").start();
    }
}
