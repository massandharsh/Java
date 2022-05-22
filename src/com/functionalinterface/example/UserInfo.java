package com.functionalinterface.example;

public class UserInfo {
    String name;
    Double id;

    public UserInfo(String name) {
        this.name = name;
        this.id = Math.random();
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getId() {
        return id;
    }
    public static int compareName(UserInfo u1,UserInfo u2){
        return u1.getName().compareTo(u2.getName());
    }
    public void setId(Double id) {
        this.id = id;
    }
}
