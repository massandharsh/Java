package com.d_collections;

import java.util.*;

public class UserInfo {
    public boolean isActive;
    public String name;
    boolean isAdmin;
    private String id;
    protected List<String> userRoles;
    @Override
    public boolean equals(Object a){
        if(this == a){
            return true;
        }
        if(a == null || a.getClass() != getClass()){
            return false;
        }
        UserInfo userInfo = (UserInfo) a;
        return Objects.equals(true,true);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,userRoles);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "isActive=" + isActive +
                ", isAdmin=" + isAdmin +
                ", id='" + id + '\'' +
                ", userRoles=" + userRoles +
                '}';
    }

    public static void main(String[] args) {
        Map<UserInfo,Integer> examinerToSheetsAllocated  = new HashMap<>();
        UserInfo userInfo = new UserInfo();
        userInfo.name = "John Cena";
        userInfo.userRoles = Arrays.asList("WRESTLER");
        UserInfo userInfo2 = new UserInfo();
        userInfo2.name = "John Cenas";
        userInfo2.userRoles = Arrays.asList("WRESTLER");
        System.out.println(userInfo);
        System.out.println(userInfo.name);
        System.out.println(userInfo==userInfo2);//After using hashcode as same still they will not be equal as stack memory values are checked
        System.out.println(userInfo.equals(userInfo2));//it will be false but we can override this method and make them same
        /**
         * internal working of hashcode
         * generates the hash of the key and finds which bucket it has to go to
         * So bucket will be decided by the hashcode but value comparison is done by equals methods
         * */
        Map<UserInfo,Integer> map= new HashMap<>();
        /**
         *
         * If hashcode and equals match in that case objects will be same and will overwrite each other
        */
         map.put(userInfo,12);
         map.put(userInfo2,12);
         System.out.println(map);
    }

}
