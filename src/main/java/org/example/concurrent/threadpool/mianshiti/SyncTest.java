package org.example.concurrent.threadpool.mianshiti;

public class SyncTest {
    public static void main(String[] args) throws InterruptedException {
        LockSupportTest.MyContainer myContainer=new LockSupportTest.MyContainer();
        Object o=new Object();
        new Thread(()->{
            synchronized (o){
                if(myContainer.size()!=5){
                    try {
                        o.wait();
                        System.out.println("监控线程运行结束");
                        o.notify();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
        Thread.sleep(1000L);
        new Thread(()->{
            synchronized (o){
                for (int i = 0; i < 10; i++) {
                    myContainer.add(Integer.valueOf(i));
                    if(myContainer.size()==5){
                        try {
                            o.notify();
                            o.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }).start();


    }
}
