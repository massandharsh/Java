package com.b_object;
/**
 * Every class we create inherits from Object class
 * native methods depends on the os
 * */

public class UserInfo implements SampleInterface {
    boolean isActive;

    @Override
    public double returnSum(double a, double b) {
        return a + b;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "isActive=" + isActive +
                '}';
    }
    /**
     * -----------------------------------------------------
     *  hascode->refers to the memory location
     * -----------------------------------------------------
     * */
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        System.out.println(userInfo);
    }
    /**
     * Memory Mapping
     *  Heap Memory and Stack Memory
     *  Memory that is being initialized when JVM starts
     *  Objects->heap memory
     *          ------------>Garbage Collection && Young and Old Generations
     *  Stack Memory
     *          ------------> temporary memory where variable are stored and when their methods are invoked
     *          ------------> reference of the objects
     *  Java is pass by value and memory block is created as it is pass by reference we cannot swap directly by passing
     *  two references
     * */

    public static class Memory{
        //JRE would create a stack memory
        public static void main(String[] args) {
            int temp = 1;                   //Stored in stack memory
            Object object = new Object();  //object is in stack and mapping is in heap
            Memory memory = new Memory(); // memory is in stack and memory will be allocated in head
            memory.printObject(object);  //reference through stack to heap
            memory.printObject(memory);
        }                                 //end of main
        private void printObject(Object input){ // a new reference is created-- non primitive type
            String print = input.toString(); // a new string in string pool(the heap space) and reference in stack
            System.out.println(print);       // After this garbage collection will be held
        }

        public static class Balloon{
            String color;

            @Override
            public String toString() {
                return "Balloon{" +
                        "color='" + color + '\'' +
                        '}';
            }

            public void setColor(String color) {
                this.color = color;
            }

            public static void main(String[] args) {//HEAP      STACK
                Balloon red = new Balloon();        //()   ------
                red.setColor("RED");                //(RED)------>"RED"
                Balloon blue = new Balloon();       //()--------->
                blue.setColor("BLUE");              //(BLUE)----->blue
                System.out.println(red+" "+blue);
            }
        }
    }
}



