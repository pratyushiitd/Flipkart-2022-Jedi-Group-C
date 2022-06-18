package com.dropwizard.dao;

import java.sql.*;

import static com.dropwizard.constants.SQLQueryConstants.*;

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
            {
                System.out.println("Login Successful");
            }
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
    public boolean reset_password(String userId,String old_password,String new_password)
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

               // System.out.println("The new password is updated successfully");
                return true;
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
        return false;
    }

    //add user to user table
    public void addUser(String userID, String name, String password, int role, String email_id)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.prepareStatement(addUser);
            stmt.setString(1,userID);
            stmt.setString(2,name);
            stmt.setString(3,password);
            stmt.setInt(4,role);
            stmt.setString(5,email_id);
            stmt.executeUpdate();

            //System.out.println("Student successfully registered");
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

    @Override
    public int getRole(String userId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql="Select role from user where userId= '"+userId+"'";
            stmt = conn.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery(sql);
            int role=-1;
            while(rs.next())
                role= rs.getInt("role");
            //System.out.println("Student successfully registered");
            stmt.close();
            conn.close();
            return role;
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
        return -1;
    }


}
