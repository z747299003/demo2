package org.example.concurrent.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            System.out.println("11111");
            return "hello";
        });
        new Thread(futureTask).start();
        String s = futureTask.get();
        System.out.println(s);
    }


}
