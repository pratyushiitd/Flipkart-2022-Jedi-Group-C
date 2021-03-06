package com.dropwizard.dao;

import java.sql.*;

import static com.dropwizard.constants.SQLQueryConstants.*;

public class GradeDAOImp implements GradeDAO{
    public void generateGrade(String studentId)
    {
        //after enrolled students
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "SELECT name FROM student"+" WHERE studentId='"+studentId+"'";
            stmt = conn.prepareStatement(sql);
            String name=null;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
                name=rs.getString("name");
             sql = "SELECT * FROM grade"+" WHERE studentId='"+studentId+"'";
            //System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            //stmt.setString(1,studentID);
             rs = stmt.executeQuery(sql);
            //System.out.println(sql);
            while(rs.next()){
                String gpa = rs.getString("gpa");
                String courseId=rs.getString("courseId");
                System.out.println("Student name: " + name);
                System.out.println("Course id: " + courseId);
                System.out.println("Student gpa: " + gpa);
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
    public void submitGrade(String studentId,String courseId,String gpa)
    {
        //after enrolled students
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "update grade set gpa= '"+gpa+" WHERE courseId= '"+courseId
                    +"AND studentId='"+studentId+"'";
            //System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            //stmt.setString(1,studentID);
            stmt.executeUpdate(sql);
            //System.out.println(sql);
//            while(rs.next()){
//                System.out.println("Student name: " + studentId);
//                System.out.println("Course id: " + courseId);
//                System.out.println("Student gpa: " + gpa);
//                // System.out.println(", Last: " + location1);
//            }
//            //STEP 6: Clean-up environment
//            rs.close();
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
