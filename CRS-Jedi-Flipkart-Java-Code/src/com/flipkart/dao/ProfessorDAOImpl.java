package com.flipkart.dao;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ProfessorDAOImpl implements ProfessorDAO{
    // Step 1
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test?characterEncoding=latin1&useConfigs=maxPerformance";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "Blue_175981";

    public  void viewProfessorDetails(String professorID)
    {
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "SELECT * FROM professor"+" WHERE professorId= '"+professorID+"'";
            //System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            //stmt.setString(1,professorID);
            ResultSet rs = stmt.executeQuery(sql);
            //System.out.println(sql);
            while(rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                String department = rs.getString("department");
                System.out.println("Professor name: " + name);
                System.out.println("Professor email: " + email);
                System.out.println("Professor department: " + department);
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
    }
    public  void submitGrades(String studentId,int gpa,String courseId)
    {
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "UPDATE approved SET gpa='"+gpa+"' WHERE studentId='"+studentId+"AND courseId='"+courseId+"'";
            //System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            System.out.println("Gpa updated!");
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
    }
    public  void viewStudentsList(String courseId,int sem)
    {
        //after enrolled students
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "SELECT * FROM student"+" WHERE courseId= '"+courseId
                    +"AND sem='"+sem+"'";
            //System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            //stmt.setString(1,professorID);
            ResultSet rs = stmt.executeQuery(sql);
            //System.out.println(sql);
            while(rs.next()){
                String name = rs.getString("studentName");
                String id = rs.getString("studentId");
                System.out.println("Student name: " + name);
                System.out.println("Student email: " + id);
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
    }
}
