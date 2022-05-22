package com.b_object;

public interface SampleInterface {
    default double returnSum(double a,double b){
        return a+b;
    }
}
