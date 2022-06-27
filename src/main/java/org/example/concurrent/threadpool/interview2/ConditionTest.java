package org.example.concurrent.threadpool.interview2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 面试题：写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 * <p>
 * 使用wait和notify/notifyAll来实现
 *
 * @author mashibing
 */
public class ConditionTest {

    List<Object> list = new ArrayList<>();
    int maxCount = 10;
    int count = 0;
    ReentrantLock lock = new ReentrantLock();

    Condition PUT = lock.newCondition();
    Condition GET = lock.newCondition();

    public void put(Object o) throws InterruptedException {

        try {
            lock.lock();
            //此处要使用while 为什么
            while (list.size() >= maxCount) {
                PUT.await();
            }
            count++;
            list.add(o);
            GET.signal();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }

    public Object get() throws InterruptedException {
        try {
            lock.lock();
            while (count == 0) {
                GET.await();
            }
            count--;
            Object remove = list.remove(0);
            PUT.signal();
            return remove;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionTest conditionTest = new ConditionTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        Object o = conditionTest.get();
                        System.out.println(Thread.currentThread().getName() + "   " + o);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }, "get-" + i).start();
        }
        Thread.sleep(3000L);

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    try {
                        conditionTest.put(Thread.currentThread().getName() + "   " + j);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }, "thread-" + i).start();
        }


    }
}
