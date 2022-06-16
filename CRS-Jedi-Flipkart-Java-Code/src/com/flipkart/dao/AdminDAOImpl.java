package com.flipkart.dao;

import java.sql.*;

public class AdminDAOImpl {
    // Step 1
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test?characterEncoding=latin1&useConfigs=maxPerformance";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "janhavi544";

    public static void addProfessor()
    {

    }
    public static void addStudent() {
    }
    public static void addCourse() {
    }
    public static void getProfessorDetails() {
    }
    public static void getStudentDetails() {
    }
    public static void getCourseDetails() {
    }
    public static void approveCourse() {
    }

    public static void main(String[] args) {

        // Step 2
        // Declare the Coneection or prepaidstatement variable here


        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            // Step 3 Regiater Driver here and create connection

            Class.forName("com.mysql.jdbc.Driver");

            // Step 4 make/open  a connection

            // System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            //System.out.println("Creating statement...");


            //stmt.executeUpdate();




            // Let us update age of the record with ID = 102;
            // int rows = stmt.executeUpdate();
            // System.out.println("Rows impacted : " + rows );

            // Let us select all the records and display them.

            String sql = "SELECT * FROM student";
            stmt = conn.prepareStatement(sql);
            // stmt.executeUpdate();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(sql);
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String eid  = rs.getString("studentID");
                String name1 = rs.getString("name");
                String address1 = rs.getString("email");
                //String location1 = rs.getString("location");

                //Display values
                System.out.print("ID: " + eid);
                System.out.print(", Age: " + name1);
                System.out.print(", First: " + address1);
                // System.out.println(", Last: " + location1);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }
}