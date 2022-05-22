package com.c_exceptions;
/**
 *
 *  -------------------------------->   Throwable
 *                                            <---------- Error></---------->
 *  Exceptions --
 *  2 types Run Time and Compile Time
 *  or
 *  Unchecked -> RunTime                        Checked
 *  Checked   -> Compile Time                   --> IO Exception
 *  Null pointer -> run time                    --> File not found
 *  Array index out of found                    --> Database exceptions
 *  divide by zero arithmatic
 *  class not found exceptions
 *  class cast exceptions
 *
 *
 * */
public class Exceptions{
    //runtime Memory Leaks or Stack Overflow
    public static class SampleRunTimeExceptions extends RuntimeException{

    }
    //compile time (For Business logic) like minimum wallet balance
    public static class SampleCompileTimeExceptions extends Exception{

    }

}
