package org.example.concurrent.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool=new ForkJoinPool();
        ForkJoinTask<Long> submit = pool.submit(new MyTask(0, 50000));
        Long aLong = submit.get();
        System.out.println(aLong);
        int sum = 0;
        for (int i = 0; i <= 50000; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    static class MyTask extends RecursiveTask<Long> {

        private int start;
        private int end;

        MyTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start >= 50000) {
                int middle = start + (end - start) / 2;
                MyTask myTask1 = new MyTask(start, middle);
                MyTask myTask2 = new MyTask(middle + 1, end);
                myTask1.fork();
                myTask2.fork();
                return myTask1.join() + myTask2.join();
            } else {
                int sum = 0;
                for (int i = start; i <= end; i++) {
                    sum += i;
                }
                return Integer.valueOf(sum).longValue();
            }
        }
    }
}
