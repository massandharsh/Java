package com.functionalinterface.MethodReference;

import com.functionalinterface.example.CompareByName;
import com.functionalinterface.example.UserInfo;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /**
         *
         *  query a database to find an object of a type or else throw a runtime exception
         *  APPLICATION-->DB(DATA)
         *         -CRUD->Create a movie,update a movie,read a memory,delete a db
         *          Constructor type reference
         */
        List<UserInfo> userInfos = Arrays.asList(
                new UserInfo("Harsh"),
                new UserInfo("John Cena"),
                new UserInfo("Undertaker"),
                new UserInfo("Rey")
        );


        /**
         * Method reference is ---
         * a lambda expression making a call to existing method
         * UserInfo::getName
         * Shorthand syntax
         * 4 types
         * Static Method Reference: MethodName::staticMethod
         * (args)->class.staticMethod(args) ---> class::staticMethod
         * (args)->object.method(args)---->object::method
         * (obj,args)->object.instanceMethod(args)
         * constructor type exception
         * */
        userInfos.sort(UserInfo::compareName);//Method reference static
        CompareByName byName = new CompareByName();
        userInfos.sort(byName::compareByName);//Method reference object
//        userInfos.sort(String::compare);
        MovieDao movieDao = new MovieDao();
        Movie movie = movieDao.findByName("Avengers").stream().findFirst().orElseThrow(()->new RuntimeException("Movie Not Found"));
        Movie movie2 = movieDao.findByName("BatWoman").stream().findFirst().orElseThrow(()->new RuntimeException("Movie Not Found"));

        System.out.println(movie);
    }
}
