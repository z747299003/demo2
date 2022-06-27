package org.example.concurrent;

public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads=new Thread[10000];
        for (int i = 0; i < threads.length; i++) {
            int finalI = i;
            threads[i]=new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"    "+ finalI);
            });
        }
        for (Thread thread : threads) {
            thread.start();
            thread.join();
        }
       /* for (Thread thread : threads) {
            thread.join();
        }*/

    }
}
