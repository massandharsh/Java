package com.multithreading;

public class Sample {
    /**
     * Can I eat and sing simultaneously(not possible) we can do context switch(Concurrent)
     * -Parallel
     *  => Multithreading in which we are doing things in parallel
     *  deterministic (Eating and listening)
     *  -Concurrent
     *  eating and singing a song can be concurrent
     *  => Async/Callbacks
     *      process is happening in background and the normal execution is not interrupted
     *
     * =>Processor and Thread
     *  - processor-- computing power
     *  One processor
     *  -T1 -T2 -T3 -T4 -T1
     *  Round Robin concurrent programming if it happens in order of milliseconds it appears to be parallel
     *
     *  Thread is a lightweight program and one thread can only run in a single program at a time
     *  One thread can run at one time in a core
     *  Task generally are IO expensive
     *      --I/O expensive
     *      -->webservice
     *      Post /user/ {userInfo{userName:,email:}}
     *      --->first checking if the user exists and authenticate and authorize
     *      ---->
     *
     *      Let intellij 4 processors
     *      we are processing in a single threaded environment 3idle,1running
     *      Program that generates in 5 second
     *      (4 such files will take around 20 seconds to get generated)
     *      If we use the idle processors as well
     *      4 threads will take around->5 seconds
     *      40 such files in single thread will take -> 5 * 40 -> 200seconds
     *      40 such files in parallel thread will take -> (40*5)/4->50seconds
     *      Benefits of parallel processing
     *          Active task processing is faster
     *          Monitor the progress
     *          T1   T2
     *          T2 is dependent on T1 in multithreading environment is not useful
     *
     *
     * */
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());//Number of cores


    }

}
