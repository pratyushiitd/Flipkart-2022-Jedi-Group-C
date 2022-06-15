package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl {
    // Step 1
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    static List<String> studentID=new ArrayList<>();
    static List<String> studentName=new ArrayList<>();
    static List<String> studentPswd=new ArrayList<>();
    static List<Long> studentMobile=new ArrayList<>();
    static List<String> studentEmail=new ArrayList<>();
    static List<Integer> studentSemester=new ArrayList<>();
    static List<String> studentDept=new ArrayList<>();
    static List<Float> studentCg=new ArrayList<>();
    static List<String> studentGender=new ArrayList<>();
    static List<String> studentPaymentID=new ArrayList<>();
    public static void addStudent(String id,String name,String pswd,String role, long mobile,String email, int sem,
                                  String section,String dept,float cg,String gender,String paymentID,PreparedStatement stmt,
                                  Connection conn)
    {
        try{
        String sql="insert into student values(?,?,?,?,?,?,?,?,?,?,?,?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, id);
        stmt.setString(2,name);
        stmt.setString(3, pswd);
        stmt.setString(4, role);
        stmt.setLong(5, mobile);
        stmt.setString(6,email);
        stmt.setInt(7,sem );
        stmt.setString(8,section );
        stmt.setString(9,dept);
        stmt.setFloat(10, cg);
        stmt.setString(11,gender);
        stmt.setString(12, paymentID);
        stmt.executeUpdate();
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
    }
    public static void addStudent(String id,String name,String pswd,long mobile,String email, int sem,
                                  String dept,float cg,String gender,String paymentID)
    {
        studentID.add(id);
        studentName.add(name);
        studentPswd.add(pswd);
        studentMobile.add(mobile);
        studentEmail.add(email);
        studentSemester.add(sem);
        studentDept.add(dept);
        studentCg.add(cg);
        studentGender.add(gender);
        studentPaymentID.add(paymentID);
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

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");

            //stmt.executeUpdate();


			   /*

			   // Let us update age of the record with ID = 102;
			      int rows = stmt.executeUpdate();
			      System.out.println("Rows impacted : " + rows );

			      // Let us select all the records and display them.
			      sql = "SELECT id, name ,address, location FROM employeefc";
			      ResultSet rs = stmt.executeQuery(sql);

			      //STEP 5: Extract data from result set
			      while(rs.next()){
			         //Retrieve by column name
			         int eid  = rs.getInt("id");
			         String name1 = rs.getString("name");
			         String address1 = rs.getString("address");
			         String location1 = rs.getString("location");

			         //Display values
			         System.out.print("ID: " + eid);
			         System.out.print(", Age: " + name1);
			         System.out.print(", First: " + address1);
			         System.out.println(", Last: " + location1);
			      }*/
            //STEP 6: Clean-up environment
            // rs.close();
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
