package com.multithreading.parallel;

import com.multithreading.ComputeHeavy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;
/**
 * Executor service provides us with the fixed size thread pool we can use threads from certain
 * thread pool
 * Executor pool threads are non deamon in nature
 * */
public class ParallelExecutorService {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()-1);
        /**
         * -1 for the main thread
         */
        LocalDateTime startTime = LocalDateTime.now();
        List<Future<List<Long>>> futures = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        ComputeHeavy heavy = new ComputeHeavy();
        IntStream.range(0,100).map(a-> 37).forEach(l::add);
        List<List<Long>> output = new ArrayList<>();
        l.forEach((input)-> {
            futures.add(executorService.submit(()->{
                System.out.println("Current thread is: " + Thread.currentThread() + " isDeamon : " + Thread.currentThread().isDaemon());
                return heavy.firstNFibNumbers(input);
            }));
        });
        /**
         * futures.get is a blocking call and waits till the result is returned
         * Main thread waits for a blocking call get call
         * */
        futures.parallelStream().forEach((a)-> {
            try {
                output.add(a.get()); //It is a blocking statement
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        LocalDateTime endTime = LocalDateTime.now();
/**
 *
 * We can use executorService.await termination such as join call in multithreading
 * For await we need to think of a particular time which can be problematic
 * We can notify when the work is done
 * */

        System.out.println(output);
/**
 * We need shutdown to shutdown the thread and make the executor threads to zombie and kill them
 * MONITOR will indicate the status of the threads
 * */
        executorService.shutdown();
        System.out.println("Main Program");
        System.out.println(Duration.between(startTime,endTime).toNanos());
    }

}
