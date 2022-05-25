package com.multithreading;

import java.util.ArrayList;
import java.util.List;

public class DeamonThreads {
    /**
     *
     * Deamon threads:
     *  Once the main thread has been exited the thread will not work
     *
     * */
    public static void main(String[] args) {
        /**
         * Main Thread cannot be set as Deamon Thread
         * Here main thread will already active so it cannot be set as active
         * Deamon thread is a Garbage Collector
         * */
        Thread thread = new Thread(()->{
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread());
            System.out.println("Inside the thread: is Demon : " + Thread.currentThread().isDaemon());
        });
        thread.setDaemon(true);
        thread.start();
        System.out.println(Thread.currentThread());
    }
}
