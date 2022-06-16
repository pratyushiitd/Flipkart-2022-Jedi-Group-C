package com.flipkart.dao;

import java.sql.*;

import static com.flipkart.constants.SQLQueryConstants.*;

public class CourseDAOImpl implements CourseDAO{
    @Override
    public void showCourses(String dept) {
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "Select * from course where department='"+dept+"'";
            //System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            System.out.println("Courses in this department:");
            ResultSet rs = stmt.executeQuery(sql);
            //System.out.println(sql);
            while(rs.next()){
                String id = rs.getString("courseId");
                String name = rs.getString("courseName");
                System.out.println("Course name: " + name);
                System.out.println("Course id: " + id);
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
