package org.example.concurrent;

public class ValidVolatile implements Runnable {
    private volatile static int count = 100000;
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100000; i++) {
            ValidVolatile validVolatile = new ValidVolatile();
            new Thread(validVolatile).start();
        }
        Thread.sleep(15000L);
        System.out.println(count);
    }

    @Override
    public void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " " + count);
    }
}
