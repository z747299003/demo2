package org.example.concurrent.abc;

public class sync_wait_notify {
    public static void main(String[] args) {
        char[] numbers = "123456".toCharArray();
        char[] uppers = "ABCDEF".toCharArray();
        Object o=new Object();

        new Thread(()->{
            for (int i = 0; i < numbers.length; i++) {
                synchronized (o){
                    System.out.println(numbers[i]);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    o.notify();

                }
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < uppers.length; i++) {
                synchronized (o){
                    System.out.println(uppers[i]);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    o.notify();

                }

            }
        }).start();
    }
}
