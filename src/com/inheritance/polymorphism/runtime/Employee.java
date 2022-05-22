package com.inheritance.polymorphism.runtime;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * UserInfo user = new UserInfo();
 * Employee emp = new Employee();
 * UserInfo u  = new Employee();
 * Employee e = (Employee)new UserInfo();
 * */
public class Employee extends UserInfo{
    LocalDateTime dateOfJoining;
    public boolean isActive(){
        System.out.println("Active for: " + this.toString());
        return true;
    }
//    com.inheritance.polymorphism.runtime.UserInfo@5f184fc6 ----> hashcode


    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.userRoles = Arrays.asList("STUDENT","ADMIN");
        userInfo.isAdmin = true;
        System.out.println(userInfo);
        Employee employee = new Employee();
        employee.userRoles = Arrays.asList("EMPLOYEE");
        employee.setActive(true);
        System.out.println(employee);
        /**
         * -- limiting the scope or restricting the usage
         * extra functionality being performed by child we use derived otherwise we always use base class
         * */
        UserInfo user = new Employee();
        user.userRoles = Arrays.asList("EMPLOYEE");
        user.isActive();
        Map<String,Integer> stringIntegerMap = new HashMap<>();
    }
}
