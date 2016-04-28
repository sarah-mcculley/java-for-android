package com.sarah;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class QueueExample {
    public static void main(String[] args) {
        final BlockingQueue<Character> queue = new ArrayBlockingQueue<Character>(5);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (char ch='A'; ch <= 'Z'; ch++) {
                    try {
                        queue.put(ch);
                        System.out.println(ch + " produced by producer");
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                char ch = '\0';
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                do {
                    try {
                        ch = queue.take();
                        System.out.println(ch + " consumed by consumer");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }  while (ch != 'Z');
                executorService.shutdown();
            }

        });
    }
}