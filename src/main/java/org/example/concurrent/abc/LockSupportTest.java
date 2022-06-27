package org.example.concurrent.abc;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
    static Thread numberThead = null;
    static Thread upperThread = null;
    public static void main(String[] args) {
        char[] numbers = "123456".toCharArray();
        char[] uppers = "ABCDEF".toCharArray();

        numberThead = new Thread(() -> {
            for (int i = 0; i < numbers.length; i++) {
                System.out.println(numbers[i]);
                LockSupport.unpark(upperThread);
                LockSupport.park();
            }
        }, "numbers");

        upperThread = new Thread(() -> {
            for (int i = 0; i < uppers.length; i++) {
                LockSupport.park();
                System.out.println(uppers[i]);
                LockSupport.unpark(numberThead);
            }
        }, "uppers");

        numberThead.start();
        upperThread.start();
    }
}
