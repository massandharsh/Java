package com.functionalinterface;

import com.functionalinterface.lambda.IDemoInterface;
import com.functionalinterface.lambda.ILogger;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /**
         * Anonymous class or by implementing the interface
         * */
        IDemoInterface demoInterface = new IDemoInterface() {
            @Override
            public List<String> getUserRoles() {
                return Arrays.asList("STUDENT");
            }
        };

        /**
         * lambda expression
         * - it is used to provide the implementation of the interface which has the functional interface
         * */

        IDemoInterface demoInterface1 = ()->Arrays.asList("STUDENT","ADMIN");
        System.out.println(demoInterface1.getUserRoles());

        /**
         * what basically is lambda
         * (argument list)->{body associated}
         * */

         ILogger logger = ()-> System.out.println("Hello World");
         logger.print();

         /**
          *
          * Creating a thread
          * extending thread class
          * implementing runnable interface
          * */

         Runnable r1 = ()->{
             System.out.println("Inside Lambda");
         };
         Thread myThread = new Thread(r1);
         myThread.start();

         Runnable r2 = new Runnable() {
             @Override
             public void run() {
                 System.out.println("Inside Anonymous");
             }
         };
         Thread thread2 = new Thread(r2);
         thread2.start();
         /**
          * add two numbers
          *
          */
         Sum sum = new Sum();
        Comparator<Integer> comp = sum::addition; //Using method reference
        System.out.println(comp.compare(5,6));

    }
    public static class Sum{
        public static int sum(int a,int b){
            return a+b;
        }
        public int addition(int a,int b){
            return a+b;
        }
    }
}
