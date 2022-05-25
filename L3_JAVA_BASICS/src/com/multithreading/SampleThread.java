package com.multithreading;
/**
 * Native methods are provided by the operating systems.JVM has access to OS library, and it gives us the
 * value
 * Default priority is 5
 * We can create Threads by
 * Extending Thread class or Runnable interface
 * Two Threads
 *  T1 -> priority of 8
 *  T2 -> priority of 5
 *  Multicore processor might run them parallel but T1 will be prioritized more if cores are
 *  not available
 * */
public class SampleThread {
    public static void main(String[] args) {
        Thread thread = new DemoThread();
        thread.start();
        /**
         * We cannot start same thread again as it will give us illegal state exception
         * */
        System.out.println(Thread.currentThread());
    }
    /**
     * Output will be unpredictable
     * but if we add thread.sleep in our
     * case output becomes predictable
     * */
    static class DemoThread extends Thread{
        @Override
        public void run(){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Inside the Demo Thread: " + Thread.currentThread());
        }
    }
}
