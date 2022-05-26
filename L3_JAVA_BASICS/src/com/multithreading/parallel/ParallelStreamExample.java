package com.multithreading.parallel;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ParallelStreamExample {
    public static void main(String[] args) {
/**
 *
 * If the output lies end of it then parallel would outperform but here the output will always be 1
 * */
        List<Integer> l = Arrays.asList(1,2,3,4,10,5,6,7,8,9);
        Optional<Integer> o = l.parallelStream().filter((a)->(a&1)==0)
                .findFirst();
        System.out.println(o.isEmpty()?"":o.get());
/**
 * In this case parallel will outperform sequential
 * 7 workers and 1 main thread in fork join pool
 * workers(9,13,15,3,7,11)
 * 1 main
 * */
        Integer n = l.parallelStream().filter((x)-> {
                    System.out.println(Thread.currentThread() + " [" + x + " ]" );
            if (x % 2 == 0 && x % 5 == 0){
                        return true;
                    }
                    return false;
                })
                .findFirst().get();
        System.out.println(n);


    }
}
