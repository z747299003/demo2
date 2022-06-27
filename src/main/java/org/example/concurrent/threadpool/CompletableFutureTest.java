package org.example.concurrent.threadpool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletableFuture<Long> c1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 1L;
        }, executorService);
        CompletableFuture<Long> c2 = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 2L;
        }, executorService);
        CompletableFuture<Long> c3 = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 3L;
        }, executorService);
        long l = System.currentTimeMillis();
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(c1, c2, c3);

        voidCompletableFuture.get();
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l);
        System.out.println(c1.get());
        System.out.println(c2.get());
        System.out.println(c3.get());
        executorService.shutdown();
    }
}
