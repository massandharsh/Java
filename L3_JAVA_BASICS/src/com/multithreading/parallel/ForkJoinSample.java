package com.multithreading.parallel;

import com.multithreading.ComputeHeavy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.stream.IntStream;
/**
 * Fork Join Pool Threads are Deamon in nature
 * executorService.shutDown() is not required
 * Deamon run is background thread as the main thread will exit
 * and all the threads will be terminated
 * Main Thread cannot be a Deamon
 * A thread cannot be set Deamon after the starting
 * */

public class ForkJoinSample {
    public static void main(String[] args) {
        ExecutorService executorService = new ForkJoinPool();
        ComputeHeavy heavy = new ComputeHeavy();
        List<Integer> l = new ArrayList<>();
        LocalDateTime startTime = LocalDateTime.now();
        IntStream.range(0,100).map((a)->37).forEach(l::add);
        List<Future<List<Long>>> futures = new ArrayList<>();
        List<List<Long>> output = new ArrayList<>();
        l.stream().forEach((a)->{
            futures.add(executorService.submit(()->{
                System.out.println("Current running thread is : "+Thread.currentThread()+" isDeamon: " + Thread.currentThread().isDaemon());
                return heavy.firstNFibNumbers(a);
            }));
        });
        futures.stream().forEach((a)->{
            try {
                output.add(a.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
//        executorService.shutdown(); Threads by the forkjoinpool are deamon so not required
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println(Duration.between(startTime,endTime).getSeconds());
        System.out.println(output);

    }
}
