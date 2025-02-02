package com.piyushSingh.myTodoList.MultiThreadingPractise;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Pooling {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService= Executors.newFixedThreadPool(3);

        for (int i=0;i<10;i++){
            int g = i;
            executorService.submit(
                    ()->{
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Ruunniinngg"+g);
                    }
            );

        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.currentTimeMillis()-startTime);

    }
}
