package org.example.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();

       /* new Thread(reentrantLockTest::getLock1).start();
        new Thread(reentrantLockTest::getLock2).start();*/
        new Thread(reentrantLockTest::m2).start();
        new Thread(reentrantLockTest::m1).start();

    }

    public void getLock1() {
        try {
            reentrantLock.lock();
            System.out.println("1获取锁成功");
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
            System.out.println("获取锁失败");
        } finally {
            reentrantLock.unlock();
            System.out.println("1释放锁");

        }
    }

    public void getLock2() {
        try {
            reentrantLock.lock();
            System.out.println("2获取锁成功");
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
            System.out.println("获取锁失败");
        } finally {
            reentrantLock.unlock();
        }
    }

    void m1() {
        boolean locked = false;
        try {
            locked = reentrantLock.tryLock(5000L, TimeUnit.MILLISECONDS);
            if (locked) {
                System.out.println("m1拿到了锁");

            } else {
                System.out.println("m1获取锁超时");

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (locked) {
                reentrantLock.unlock();
            }
            System.out.println("m1运行结束");
        }
    }

    void m2() {
        boolean locked = false;
        try {
            locked = reentrantLock.tryLock();
            System.out.println("m2拿到了锁");
            Thread.sleep(10000L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (locked) {
                reentrantLock.unlock();
            }
            System.out.println("m2运行结束");

        }
    }
    void c1() {
        try {
            reentrantLock.lockInterruptibly();
            System.out.println("m2拿到了锁");
            Thread.sleep(10000L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

            System.out.println("m2运行结束");

        }
    }
}
