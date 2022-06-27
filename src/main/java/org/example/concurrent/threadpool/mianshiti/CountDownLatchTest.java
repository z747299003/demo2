package org.example.concurrent.threadpool.mianshiti;

import sun.text.resources.no.CollationData_no;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) {
        LockSupportTest.MyContainer myContainer = new LockSupportTest.MyContainer();
        CountDownLatch countDownLatch = new CountDownLatch(5);
        new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("监控线程运行结束");
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myContainer.add(Integer.valueOf(i));
                countDownLatch.countDown();
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
