package org.example.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestThreadPoolExecutor {
    static Object LOCK=new Object();
    public static void main(String[] args) throws InterruptedException {
/*        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(2);
        AtomicInteger atomicInteger = new AtomicInteger();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 1000L, TimeUnit.MILLISECONDS, arrayBlockingQueue,
                 r -> new Thread(r, "myThread" + atomicInteger.getAndIncrement()), new ThreadPoolExecutor.AbortPolicy());
        MyTask myTask1=new MyTask(6000L);
        threadPoolExecutor.submit(myTask1);
        showState(threadPoolExecutor);
        MyTask myTask2=new MyTask(6000L);
        threadPoolExecutor.submit(myTask2);
        showState(threadPoolExecutor);*/
        /*synchronized (LOCK){
            LOCK.wait();
        }*/
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (LOCK) {
                    try {
                        Thread.sleep(5000L);

                    } catch (InterruptedException e) {
                        System.out.println("中断异常");
                    }
                }
            }
        }, "线程1");
        thread.start();
        thread.interrupt();

    }
    static class MyTask implements Runnable{

        private Long time;

        MyTask(Long time){
            this.time=time;
        }
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void showState(ThreadPoolExecutor threadPoolExecutor){
        System.out.println(threadPoolExecutor.getTaskCount());
    }
}
