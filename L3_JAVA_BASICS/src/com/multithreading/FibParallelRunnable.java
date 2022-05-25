package com.multithreading;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FibParallelRunnable {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        LocalDateTime startTime = LocalDateTime.now();
        IntStream.range(0,100).map((a)->37).forEach(l::add);
        Thread [] demoRunnables = new Thread[l.size()];
        DemoRunnable [] demoRunnables1 = new DemoRunnable[l.size()];
        IntStream.range(0,l.size()).forEach((a)->{
                demoRunnables1[a] = new DemoRunnable(l.get(a));
                demoRunnables[a] = new Thread(demoRunnables1[a]);
        });
        IntStream.range(0,l.size()).forEach((a)->demoRunnables[a].start());
        IntStream.range(0,l.size()).forEach((a)-> {
            try {
                demoRunnables[a].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(Thread.currentThread());
        List<List<Long>> output = Arrays.stream(demoRunnables1).map(DemoRunnable::getOutputList).collect(Collectors.toList());
        LocalDateTime endTime = LocalDateTime.now();
        Duration duration = Duration.between(startTime,endTime);
        System.out.println(output);
        System.out.println(duration.toSeconds());
    }
    /**
     * Runnable is a functional interface
     * */
    static class DemoRunnable implements Runnable{
        List<Long> output;
        int input;
        public DemoRunnable(int input){
            this.input = input;
            output = new ArrayList<>();
        }
        public List<Long> getOutputList(){
            return output;
        }
        @Override
        public void run() {
            ComputeHeavy heavy = new ComputeHeavy();
            output = heavy.firstNFibNumbers(input);
        }
    }
}
