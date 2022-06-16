package com.flipkart.dao;
import com.flipkart.constants.SQLQueryConstants;

import java.sql.*;

import java.util.List;
import java.util.ArrayList;

import static com.flipkart.constants.SQLQueryConstants.*;

public class UserDAOImpl implements UserDAO{

    public void login(String userId, String password)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER, PASS);

            String sql = "SELECT password FROM user"+" WHERE userId= '"+userId+"'";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            String pwd  ="";
            while(rs.next())
                pwd = rs.getString("password");

            if(password.equals(pwd))
                System.out.println("Login Successful");
            else
                System.out.println("Invalid Credentials");
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
    public void reset_password(String userId,String old_password,String new_password)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "SELECT password FROM user"+" WHERE userId= '"+userId+"'";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            String old_pwd  ="";
            while(rs.next())
                old_pwd = rs.getString("password");

            if(old_password.equals(old_pwd)) {
                String sql2 = "UPDATE user " + "SET password = '"+ new_password +"' WHERE userId = '"+userId +"'";
                stmt = conn.prepareStatement(sql2);
                stmt.executeUpdate(sql2);
                sql2="SELECT role FROM user WHERE userId = '"+userId +"'";

                rs = stmt.executeQuery(sql2);
                int role=-1;
                while(rs.next())
                role=rs.getInt("role");
                //System.out.println(role);
                if(role== adminRole)
                {
                    sql2 = "UPDATE admin " + "SET password = '"+ new_password +"' WHERE adminId = '"+userId +"'";
                    stmt = conn.prepareStatement(sql2);
                    stmt.executeUpdate(sql2);
                }
                else if(role==professorRole)
                {
                    sql2 = "UPDATE professor " + "SET password = '"+ new_password +"' WHERE professorId = '"+userId +"'";
                    stmt = conn.prepareStatement(sql2);
                    stmt.executeUpdate(sql2);
                }
                else if(role==studentRole)
                {
                    sql2 = "UPDATE student " + "SET password = '"+ new_password +"' WHERE studentID = '"+userId +"'";
                    stmt = conn.prepareStatement(sql2);
                    stmt.executeUpdate(sql2);
                }
                //System.out.println("The new password is updated successfully");
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
    public void register_student(String userID, String name, String password, int role, String email_id, int semester, String section, String department, String gender)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "insert into student values ('"+ userID+"','" + name+ "','"+ password + "','" + role + "','" + email_id + "'," + semester + ",'" + section + "','" + department + "'," + 0 + ",'" + gender+"'," + null + ")" ;
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate(sql);
            System.out.println("Student successfully registered");
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }

    }
}
