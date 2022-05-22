package com.functionalinterface.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    /**
     * Some users
     * -and sort them on basis of there name
     * */
    public static void main(String[] args) {
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
         * */
        userInfos.sort(UserInfo::compareName);//Method reference static
        CompareByName byName = new CompareByName();
        userInfos.sort(byName::compareByName);//Method reference object

        List<Integer> ids = Arrays.asList(10,20,15,30);
        ids.sort(Integer::compareTo);

        System.out.println(userInfos);
        List<String> names = userInfos.stream()
                            .filter((a)->a.getName().toLowerCase().startsWith("h"))
                            .filter((a)->{
                                System.out.println(a);
                                return true;
                            })
                            .map(UserInfo::getName)
                            .sorted()
                            .collect(Collectors.toList());
        System.out.println(names);
    }
}
