package com.multithreading;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 *
 * Mechanism where we are generating first n fib numbers
 * */
public class ComputeHeavy {
    public List<Long> firstNFibNumbers(int input){
        List<Long> output = new ArrayList<>();
        IntStream.range(1,input+1)
                .mapToLong(ComputeHeavy::fib)
                .forEach(output::add);
        return output;
    }
    public static long fib(int input){
        //Base Case
        if(input<=2) return 1L;
        return fib(input-1)+fib(input-2);
    }
}

