package org.example.concurrent.abc;

public class sync_wait_notify2 {
    public static void main(String[] args) {
        char[] numbers = "123456".toCharArray();
        char[] uppers = "ABCDEF".toCharArray();
        Object o = new Object();

        new Thread(() -> {
            synchronized (o) {
                for (int i = 0; i < numbers.length; i++) {
                    System.out.println(numbers[i]);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                o.notify();
            }
        }).start();

        new Thread(() -> {
            synchronized (o) {
                for (int i = 0; i < uppers.length; i++) {
                    System.out.println(uppers[i]);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                o.notify();
            }
        }).start();
    }
}
