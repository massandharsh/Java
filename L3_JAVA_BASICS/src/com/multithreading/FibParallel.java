package com.multithreading;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FibParallel {
    public static void main(String[] args) throws InterruptedException {
        LocalDateTime sequentialStartTime = LocalDateTime.now();
        List<Integer> l = new ArrayList<>();
        IntStream.range(0,100).map(a-> 37).forEach(l::add);
        DemoThreadClass [] threads = new DemoThreadClass[l.size()];
        for(int i = 0 ; i < l.size();++i){
            threads[i] = new DemoThreadClass(l.get(i));
        }
        /**
         * main thread is running one of them
         * and we can use the threads to perform
         * some calculations
         *
         * (single thread) = T(s)
         * multi Thread
         * T(m) = max(T(0)......T(i)) is all are running parallel simultaneously is i<= no cores
         * T(m) = sum(i/cores + i % cores---max(t(1),t(2)....T(cores) + time for context switch)
         * This is using Thread Class which was given in JDK
         *
         * */
        IntStream.range(0,l.size())
                .forEach((a)->{
                    threads[a].start();
                });
        IntStream.range(0,l.size()).forEach((a)->{
            try {
                threads[a].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        /**
         *
         * join method -->
         *    Thread.join is a blocking method and the program will not move ahead
         *    until current thread completes it's execution on which join method is
         *    called.
         * */

        List<List<Long> > output = Arrays.stream(threads).map(DemoThreadClass::getL)
                                    .collect(Collectors.toList());
        System.out.println(output);
        LocalDateTime sequentialEndTime = LocalDateTime.now();
        Duration between = Duration.between(sequentialStartTime,sequentialEndTime);
        System.out.println(between.getSeconds());
    }

    public static class DemoThreadClass extends Thread{
        List<Long> l;
        int input;
        public DemoThreadClass(int input){
            l = new ArrayList<>();
            this.input = input;
        }
        public List<Long> getL(){
            return l;
        }
        @Override
        public void run(){
           ComputeHeavy computeHeavy = new ComputeHeavy();
           l = computeHeavy.firstNFibNumbers(input);
//            System.out.println(Thread.currentThread());
        }
    }


}
