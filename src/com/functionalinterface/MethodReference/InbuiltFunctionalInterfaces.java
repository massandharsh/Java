package com.functionalinterface.MethodReference;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InbuiltFunctionalInterfaces {
    public static void main(String[] args) {
        /**
         * Consumer-->Helps to do some processing
         * Supplier-->Supplies us with some value
         * Functions-->Used while mapping inside the stream
         * */
        Consumer<Integer> consumer = System.out::println;
        consumer.accept(10); // We are printing some value using consumer interface

        Supplier<Double> supplier = Math::random;
        System.out.println(supplier.get());

        List<Movie> movies = MovieDao.movieList;
        System.out.println(movies.stream().map((a)->a.title).collect(Collectors.toList()));//We are using functional interface inside map
        /**
         * streams--> sequence of objects that supports variable methods which can be pipelined to
         * produce the desired output
         *  --not a DS instead it takes data from arrays,lists and performs some pipeline operations
         * */


    }
}
