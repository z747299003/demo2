package org.example.concurrent.threadpool;

import java.util.concurrent.*;

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Executors.newCachedThreadPool();
        MyCall myCall=new MyCall();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> submit = executorService.submit(myCall);
        System.out.println(submit.get());
    }
    static class MyCall implements Callable<String>{

        @Override
        public String call() throws Exception {
            Thread.sleep(3000L);
            System.out.println("延迟三秒");
            return "hello word";
        }
    }
}
