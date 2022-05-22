package com.inheritance.polymorphism.runtime;

import java.util.List;

public class UserInfo {
    boolean isActive;
    boolean isAdmin;
    protected List<String> userRoles;
    public UserInfo(){

    }
    @Override
    public String toString() {
        return "Employee{" +
                "isActive=" + isActive +
                ", isAdmin=" + isAdmin +
                ", userRoles=" + userRoles +
                '}';
    }
    public UserInfo(boolean isActive, boolean isAdmin, List<String> roles) {
        this.isActive = isActive;
        this.isAdmin = isAdmin;
        userRoles = roles;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<String> getRoles() {
        return userRoles;
    }

    public void setRoles(List<String> roles) {
        userRoles = roles;
    }
}
