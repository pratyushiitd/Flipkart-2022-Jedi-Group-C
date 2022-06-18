package com.flipkart.dao;

import java.sql.*;

import static com.flipkart.constants.SQLQueryConstants.*;

public class CourseDAOImpl implements CourseDAO{
    public void viewCourseStudent(String studentId)
    {
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "Select department from student where studentID='"+studentId+"'";
            //System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            String dept=null;
            //System.out.println(sql);
            while(rs.next()){
                dept=rs.getString("department");
            }
            showCourses(dept);
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
    public void viewCourseDetails(String courseId) {
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "Select * from course where courseId='"+courseId+"'";
            //System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            //System.out.println(sql);
            while(rs.next()){
                String id = rs.getString("courseId");
                String name = rs.getString("courseName");
                String pid = rs.getString("professorID");
                String department = rs.getString("department");
                System.out.println("Course name: " + name);
                System.out.println("Course id: " + id);
                System.out.println("Professor id: "+pid);
                System.out.println("Department: "+department);
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
    public boolean showCoursesNoProfessor(String dept)
    {

        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "Select * from course where department='"+dept+"' AND professorID is NULL";
            //System.out.println(sql);
            stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery(sql);
            int x=1;
            //System.out.println(sql);
            while(rs.next()){
                if(x==1)
                {
                    System.out.println("Courses in this department:");
                    x++;
                }
                String id = rs.getString("courseId");
                String name = rs.getString("courseName");
                System.out.println("Course name: " + name);
                System.out.println("Course id: " + id);
                // System.out.println(", Last: " + location1);
            }
            if(x==1) {
                System.out.println("No courses without professor,first add a course");
            }
            else return true;
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
        return false;
    }
public int viewSize()
{
    PreparedStatement stmt=null;
    Connection conn=null;
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        //System.out.println(sql);
        String sql="SELECT distinct COUNT(*) AS size FROM course";
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
//add professor to course table
    @Override
    public void addCourseProfessor(String professorId, String courseId, String courseName, int vacancy, String department) {

        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "Insert into course (courseId,courseName,vacancy,department) values('"+courseId+"','"+courseName+"','"+vacancy+"','"+department+"')";
            //System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate(sql);
                // System.out.println(", Last: " + location1);
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
    public void updateCourseProfessor(String professorId, String courseId) {
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "Update course set professorId='"+professorId+"' where courseId='"+courseId+"'";
            //System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate(sql);
            System.out.println("Professor added successfully!");
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
