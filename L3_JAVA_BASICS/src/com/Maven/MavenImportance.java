package com.Maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MavenImportance {
    /**
     * <p>
     *     MySql - DB
     *     -- relational DB
     *     need for maven
     *          ---> try creating a sample table using JAVA
     *          JDBC---> Java Database Connectivity ---Protocol
     *          ----->browser==http:
     *          ------> transfer files == ftp(file transfer protocol)
     *          ------>Mail === SMTP
     *          JDBC is a protocol to talk with databases
     * </p>
     * */

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /**
         * UserInfo{
         * int id primary key,
         * varchar(50) user_roles,
         * varchar(50) name
         * */
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_info","root","");
        Statement statement = connection.createStatement();
        statement.execute("create table user_info(id int(10) primary key,"+
                               "user_roles varchar(50) DEFAULT NULL , " +
                                "name VARCHAR(50) default NULL)");
        /**
         *
         * String --varchar vs text
         * List or map -- JSON serialize or deserialize
         * Integer --int
         * Boolean -- bool tiny int(1)
         *
         * Adding a jar manually is a hactic process
         * and more error prone
         *  -> kakfa --- zookeper
         *  -- dependency -> other dependency required
         */
    }
}
