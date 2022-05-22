package com.e_streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /**
         * Stream will only work when we have a terminate operation
         * Stream will only have one termination operation like collect forEach
         * */
        /**
         * Given an array of integers filter out even nums
         * */
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> l = list.stream().filter((a)->(a&1)==0)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(l);
        /**
         *
         * Given an array of integers lets filter the even numbers abd convert only first two to
         * cube and return the result
         * Here data is passed as a single pipline based on data
         *
         * Output of below code will be
         * Inside filter
         * Inside filter
         * Inside Map
         * Inside filter
         * Inside filter
         * Inside Map
         * [8, 64]
         * Stream operates like a kind of pipeline or a factory
         * (raw)-->middle output-->processing
         * */
        List<Integer> cubes = list.stream().filter((a)->{
                    System.out.println("Inside filter " + a);
                    return (a&1)==0;
                })
                .map((a)->{
//                    count.getAndIncrement();
                    System.out.println("Cubing it " + a);
                    return a*a*a;
                })
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(cubes);
    }
}
