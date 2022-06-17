package com.flipkart.dao;

import com.flipkart.constants.SQLQueryConstants;

import java.sql.*;

import static com.flipkart.constants.SQLQueryConstants.*;
import java.util.List;

public class AdminDAOImpl implements AdminDAO{

    public String getDepartmentCourse(String courseId)
    {
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //System.out.println(sql);
            String sql="select department from course where courseId='"+courseId+"'";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            String dept=null;
            while(rs.next())
                dept=rs.getString("department");
            //System.out.println(sql);
            stmt.close();
            conn.close();
            return dept;
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
            }catch(SQLException se) {
                se.printStackTrace();
            }
        }
        return null;
    }
    public int professorSize()
    {
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //System.out.println(sql);
            String sql="SELECT COUNT(*) AS size FROM professor";
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

    public  void addProfessor(String professorId,String name,String password,String mail,String department)
    {
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = SQLQueryConstants.addProfessor;
            //System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,professorId);
            stmt.setString(2,name);
            stmt.setString(3,password);
            stmt.setString(4,mail);
            stmt.setString(5,department);
            stmt.setInt(6, professorRole);
            stmt.executeUpdate();
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
    public  void addStudent() {
    }
    public  void addCourse(String courseId,String courseName,String professorId,int vacancy) {
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //System.out.println(sql);
            String sql="insert into course values('"+courseId+"','"+courseName+"','"+professorId+"','"+vacancy+"')";


            stmt.executeUpdate(sql);

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
            }catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }
    public  void getStudentDetails(String studentId) {
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "SELECT * FROM student"+" WHERE studentId= '"+studentId+"'";
            //System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            //stmt.setString(1,professorID);
            ResultSet rs = stmt.executeQuery(sql);
            //System.out.println(sql);
            while(rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                String department = rs.getString("department");
                int sem = rs.getInt("semester");
                int section = rs.getInt("section");
                //String department = rs.getString("department");
                System.out.println("Student name: " + name);
                System.out.println("Student email: " + email);
                System.out.println("Student department: " + department);
                System.out.println("Student semester: " + sem);
                System.out.println("Student section: " + section);
                //System.out.println("Student department: " + department);
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
    public  void getCourseDetails(String courseId) {
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "SELECT * FROM course"+" WHERE courseId= '"+courseId+"'";
            //System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            //stmt.setString(1,professorID);
            ResultSet rs = stmt.executeQuery(sql);
            //System.out.println(sql);
            while(rs.next()){
                String name = rs.getString("courseName");
                String professorId = rs.getString("professorId");
                String department = rs.getString("department");
                System.out.println("Student name: " + name);
                System.out.println("Student email: " + professorId);
                System.out.println("Student department: " + department);
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
    public void approveCourses()
    {
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "SELECT * FROM student";
            //System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            //stmt.setString(1,professorID);
            ResultSet rs = stmt.executeQuery(sql);
            //System.out.println(sql);
            while(rs.next()){
                String studentId=rs.getString("studentId");
                String studentName=rs.getString("name");
                 sql="select courseId from registration where studentId= '"+studentId+"'";
                stmt = conn.prepareStatement(sql);
                ResultSet rs1 = stmt.executeQuery(sql);
                int count=0;
                while(rs1.next()&&count<4)
                {
                    String courseId=rs1.getString("courseId");
                    sql="Select vacancy from course where courseId= '"+courseId+"'";
                    String s="Select professorID from course where courseId= '"+courseId+"'";
                    stmt = conn.prepareStatement(sql);
                    int vacancy=0;
                    ResultSet rs2 = stmt.executeQuery(sql);
                    while(rs2.next())
                        vacancy=rs2.getInt("vacancy");
                    stmt = conn.prepareStatement(s);
                    String professorId=null;
                    ResultSet rs3 = stmt.executeQuery(s);
                    while(rs3.next())
                        professorId=rs3.getString("professorID");
                    if(vacancy>0&&count<4)
                    {
                        vacancy--;
                        count++;
                        String approve="insert into approved values ('"+studentId+"','"+courseId+"','"+studentName+"','0.0','"+professorId+"')";
                        stmt = conn.prepareStatement(approve);
                        stmt.executeUpdate(approve);
                        approve="insert into grade values ('"+courseId+"','"+studentId+"','0.0')";
                        stmt = conn.prepareStatement(approve);
                        stmt.executeUpdate(approve);
                        approve="update course set vacancy= '"+vacancy+"' WHERE courseId= '"+courseId+ "'";
                        stmt = conn.prepareStatement(approve);
                        stmt.executeUpdate(approve);
                        System.out.println("Student: "+studentName+" approved!");
                    }

                    rs2.close();
                }
                System.out.println(" All Students approved!");
                rs1.close();
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
    public void approveStudent(String studentId) {
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "SELECT * FROM optedcourse"+" WHERE studentId= '"+studentId+"'";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                String department = rs.getString("department");
                int sem = rs.getInt("semester");
                int section = rs.getInt("section");
                //String department = rs.getString("department");
                System.out.println("Student name: " + name);
                System.out.println("Student email: " + email);
                System.out.println("Student department: " + department);
                System.out.println("Student semester: " + sem);
                System.out.println("Student section: " + section);
                //System.out.println("Student department: " + department);
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