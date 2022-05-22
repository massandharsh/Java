package com.inheritance.b_interface;

public interface SampleInterface {
    default String returnMethodArgs(String a){
        return a;
    }

    static double returnArea(double a,double b){
        return a*b;
    }

    double returnSum(double a, double b);
}
