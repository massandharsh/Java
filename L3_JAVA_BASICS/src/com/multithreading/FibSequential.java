package com.multithreading;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FibSequential {
    public static void main(String[] args) {
        LocalDateTime sequentialStartTime = LocalDateTime.now();
        List<Integer> l = new ArrayList<>();
        IntStream.range(0,100).map(a-> 37).forEach(l::add);
        ComputeHeavy computeHeavy = new ComputeHeavy();
        List<List<Long> > fib = l.stream().map(computeHeavy::firstNFibNumbers).collect(Collectors.toList());
        LocalDateTime sequentialEndTime = LocalDateTime.now();
        System.out.println(fib);
//        System.out.println(sequentialEndTime);
        Duration between = Duration.between(sequentialStartTime,sequentialEndTime);
        System.out.println(between.getSeconds());
    }
}
