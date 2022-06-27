package org.example.concurrent.threadpool.interview2;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题：写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 * <p>
 * 使用wait和notify/notifyAll来实现
 *
 * @author mashibing
 */
public class SyncWait {

    List<Object> list = new ArrayList<>();
    int maxCount = 10;
    int count = 0;

    public void put(Object o) throws InterruptedException {
        synchronized (this) {
            //此处要使用while 为什么
            while (list.size() >= maxCount) {
                this.wait();
            }
            count++;
            list.add(o);
            this.notifyAll();
        }
    }

    public Object get() throws InterruptedException {
        synchronized (this) {
            while (count == 0) {
                this.wait();
            }
            count--;
            Object remove = list.remove(0);
            this.notifyAll();
            return remove;
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        SyncWait syncWait = new SyncWait();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    try {
                        syncWait.put(j);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        Object o = syncWait.get();
                        System.out.println(o);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }).start();
        }

    }
}
