package com.multithreading.parallel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ParallelStream {
    /**
     * Input array [1,2,3,4,5,6,7,8,9,10]
     * find the even number
     * compute it's square
     *  and them to get the desired output
     *  Parallel Stream will pick data from the list in random ordering and assign
     *  one thread to data and that thread will perform the whole computation for
     *  that value
     *  * Fork Join pool has some worker threads but along with that
     *  * it has main thread inside the parallel stream
     *  In case of normal stream if we set reduce accumlator to 1 it will increase the
     *  total sum by 1
     *
     * */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        /**
         * Using serial stream the single element will be picked from the list
         * and it will be squared and added with initial accumlator
         *  1 -> is odd so it will not go further
         *  2 - > 4 -->reduce--->       5
         *  4--->map---->16-->reduce--->16 + 5 = 21
         *  6----------->36----------->36+21 = 57
         *  8---------->64------------>64+57 = 121
         *  10--------->100------------>100+121 = 221
         * */
        int sum = list.stream().filter((a)->(a&1)==0).map((a)->a*a).reduce(1,(x,y)->{
            System.out.println("Inside Reduce: " + "Current Thread is : " + Thread.currentThread() + " isDeamon : " + Thread.currentThread().isDaemon()
                    + " Value is: " + "{" + x +" "+y + "}");
            return Integer.sum(x,y);
           });
        System.out.println(sum);
        System.out.println("\n\n");
        System.out.println("Parallel Stream:\n");
        /**
         * Using parallel stream as any element can be picked and computed
         * Let's say 10 is picked {1,100}
         * where 1 will be the accumlator
         * Inside Reduce: Current Thread is : Thread[main,5,main] isDeamon : false Value is: {1 36}
         * Inside Reduce: Current Thread is : Thread[main,5,main] isDeamon : false Value is: {37 1}
         * So with every reduce function accumlator is picked and total Sum of even is
         * T1-{1,100}
         * T2--{1,16}
         * T3--{101,17}
         * T4--{118,1}
         * T5--{1,
         * */
        int sum2 = list.parallelStream().filter((a)->(a&1)==0).map((a)->a).reduce(1,(x,y)->{
            System.out.println("Inside Reduce: " + "Current Thread is : " + Thread.currentThread() + " isDeamon : " + Thread.currentThread().isDaemon()
                    + " Value is: " + "{" + x +" "+y + "}");
            return Integer.sum(x,y);
        });
        System.out.println(sum2);
        System.out.println("Main Thread");

        System.out.println("\n\n\n");
        System.out.println("Fork Join Threads");

        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        List<Future<Integer>>s= new ArrayList<>();
        s.add(forkJoinPool.submit(()->{
            return list.parallelStream().sequential().filter((a)->(a&1)==0).reduce(1,(x, y)->{
                System.out.println("Inside Reduce: " + "Current Thread is : " + Thread.currentThread() + " isDeamon : " + Thread.currentThread().isDaemon()
                        + " Value is: " + "{" + x +" "+y + "}");
                return Integer.sum(x,y);
            });
        }));

        System.out.println(s.get(0).get());
    }

}
