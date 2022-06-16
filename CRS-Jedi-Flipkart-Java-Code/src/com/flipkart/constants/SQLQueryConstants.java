package com.flipkart.constants;

public class SQLQueryConstants {
    public static String addStudent="insert into student values(?,?,?,?,?,?,?,?,?,?,?)";
    public static String addStudentRegistration="insert into student values(?,?,?)";
    public static String addProfessor="insert into professor values(?,?,?,?,?,?)";
    public static String addCourse="insert into admin values(?,?,?,?,?)";
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/test?characterEncoding=latin1&useConfigs=maxPerformance";

    //  Database credentials
    public static final String USER = "root";
    public static final String PASS = "Blue_175981";
    public static final int adminRole=1;
    public static final int studentRole=3;
    public static final int professorRole=2;
}
