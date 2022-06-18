package com.dropwizard.dao;
import com.dropwizard.bean.Professor;
import com.dropwizard.bean.Student;
import com.dropwizard.constants.SQLQueryConstants;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import static com.dropwizard.constants.SQLQueryConstants.*;

public class ProfessorDAOImpl implements ProfessorDAO{

    public List<Professor> viewProfessorDetails(String professorID)
    {
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            System.out.println("Arrived~");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "SELECT * FROM professor"+" WHERE professorId= '"+professorID+"'";
            //System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            //stmt.setString(1,professorID);
            ResultSet rs = stmt.executeQuery(sql);
//            System.out.println(sql);
            List<Professor> prof = new ArrayList<Professor>();
            while(rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                String department = rs.getString("department");
                String password = rs.getString("password");
//                System.out.println("Professor name: " + name);
//                System.out.println("Professor email: " + email);
//                System.out.println("Professor department: " + department);
                // System.out.println(", Last: " + location1);
                prof.add(new Professor(name, professorRole,professorID, password, email, department));
            }

            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return prof;
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
//        return null;
    }
    public boolean submitGrades(String studentId,int gpa,String courseId)
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
//            System.out.println("Gpa updated!");

            stmt.close();
            conn.close();
            return true;
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
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
    public List<Student> viewStudentsList(String courseId, int sem)
    {
        //after enrolled students
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "SELECT * FROM student"+" WHERE courseId= '"+courseId
                    +"'AND sem='"+sem+"'";
            //System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            //stmt.setString(1,professorID);
            ResultSet rs = stmt.executeQuery(sql);
            //System.out.println(sql);
            List<Student> students = new ArrayList<Student>();
            while(rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                String id = rs.getString("studentId");
                System.out.println("Student name: " + name);
                System.out.println("Student email: " + id);
                // System.out.println(", Last: " + location1);
                students.add(new Student(name, id, studentRole, "...", email, rs.getInt("semester"), rs.getString("section"), rs.getString("department"), rs.getFloat("cg"), rs.getString("gender") ));
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return students;
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
}
