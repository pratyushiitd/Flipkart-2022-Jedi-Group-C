package com.dropwizard.dao;
import com.dropwizard.bean.GradeCard;
import com.dropwizard.bean.Payment;
import com.dropwizard.bean.Student;
import com.dropwizard.constants.SQLQueryConstants;
import com.dropwizard.exception.GradeCardNotGeneratedException;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import static com.dropwizard.constants.SQLQueryConstants.*;

public class StudentDAOImpl implements StudentDAO{
    //student table
    public void addStudent(String name,int role,String userId,String password,String emailId ,
                           int semester,int section,String department,float cg,String gender,String paymentId){
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //System.out.println(sql);
            stmt = conn.prepareStatement(addStudent);
            //stmt.setString(1,studentID);
            stmt.setString(1,userId);
            stmt.setString(2,name);
            stmt.setString(3,password);
            stmt.setString(4,emailId);
            stmt.setInt(5,semester);
            stmt.setInt(6,section);
            stmt.setString(7,department);
            stmt.setFloat(8,cg);
            stmt.setString(9,gender);
            stmt.setString(10,paymentId);
            stmt.setInt(11, studentRole);
            stmt.executeUpdate();
            //ResultSet rs = stmt.executeQuery(sql);
            //System.out.println(sql);
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
//add to registration table
    @Override
    public void addStudentRegistration(String courseId,String studentId,String student_name) {
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //System.out.println(sql);
            stmt = conn.prepareStatement(addStudentRegistration);
            //stmt.setString(1,studentID);
            stmt.setString(1,courseId);
            stmt.setString(2,studentId);
            stmt.setString(3,student_name);
            stmt.executeUpdate();
            System.out.println("Student registered with the system!");
            //ResultSet rs = stmt.executeQuery(sql);
            //System.out.println(sql);
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

    @Override
    public int studentSize() {
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //System.out.println(sql);
            String sql="SELECT COUNT(*) AS size FROM student";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            int size=100;
            while(rs.next())
                size=rs.getInt("size");
            //System.out.println(sql);
            stmt.close();
            conn.close();
            return size;
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
        return 100;
    }

    public Student viewStudentDetails(String studentID)
    {
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            System.out.println("student request!!!");

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "SELECT * FROM student"+" WHERE studentID= '"+studentID+"'";
            //System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            //stmt.setString(1,studentID);
            ResultSet rs = stmt.executeQuery(sql);
            //System.out.println(sql);
            Student student = null;
            while(rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                String department = rs.getString("department");
                System.out.println("student name: " + name);
                System.out.println("student email: " + email);
                System.out.println("student department: " + department);
                // System.out.println(", Last: " + location1);
                student = new Student(
                        name,
                        studentID,
                        studentRole,
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getInt("semester"),
                        rs.getString("section"),
                        rs.getString("department"),
                        rs.getFloat("cg"),
                        rs.getString("gender")
                );
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return student;
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return null;
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return null;
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
            //stmt.setString(1,studentID);
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
