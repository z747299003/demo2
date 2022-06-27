/**
 * 曾经的面试题：（淘宝？）
 * 实现一个容器，提供两个方法，add，size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 * <p>
 * 分析下面这个程序，能完成这个功能吗？
 *
 * @author mashibing
 */
package org.example.concurrent.threadpool.mianshiti;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    static Thread t1, t2 = null;

    public static void main(String[] args) throws InterruptedException {
        MyContainer myContainer = new MyContainer();
     /*   new Thread(()->{
            for (int i = 0; i < 10; i++) {
                myContainer.add(Integer.valueOf(i));
            }
        },"t1").start();

        new Thread(()->{
            while(true){
                if(myContainer.size()==5){
                    System.out.println(" t2结束");
                    break;
                }
            }

        },"t1").start();*/
        t2 = new Thread(() -> {
            if (myContainer.size() != 5) {
                LockSupport.park();
                System.out.println(" t2结束");
                LockSupport.unpark(t1);
            }
        }, "t2");

        t1 =new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myContainer.add(Integer.valueOf(i));
                if (myContainer.size() == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
        }, "t1");
        t2.start();
        Thread.sleep(1000L);
        t1.start();
    }

    static class MyContainer {
        volatile List<Integer> list = new ArrayList<>();

        public void add(Integer integer) {
            list.add(integer);
            System.out.println("add " + integer);
        }

        public int size() {
            return list.size();
        }
    }
}

