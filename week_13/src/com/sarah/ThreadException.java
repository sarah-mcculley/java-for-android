package com.sarah;

public class ThreadException {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int quotient = 1/0;
            }
        };

        Thread.setDefaultUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println("Caught throwable " + e +
                                " for thread " + t );
                    }
                }
        );



        Thread thread = new Thread(runnable);
        System.out.println("Starting thread");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End of Main.main()");

    }
}