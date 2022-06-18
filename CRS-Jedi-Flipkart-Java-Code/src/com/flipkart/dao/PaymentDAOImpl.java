package com.flipkart.dao;

import java.sql.*;

import static com.flipkart.constants.SQLQueryConstants.*;

public class PaymentDAOImpl implements PaymentDAO{

    public void makePayment(String studentId, String paymentId)
    {

        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql="Select name from student where studentID='"+studentId+"'";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            String name=null;
            while(rs.next())
                name=rs.getString("name");
            String sql2 = "Insert into payment values('"+studentId+"','"+paymentId+"','"+name+"')" ;
            //System.out.println(sql);
            stmt = conn.prepareStatement(sql2);
            //stmt.setString(1,studentID);
             stmt.executeUpdate(sql2);
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
    public void getDetails(String studentId) {
        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "SELECT * FROM payment"+" WHERE studentID= '"+studentId+"'";
            //System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            //stmt.setString(1,studentID);
            ResultSet rs = stmt.executeQuery(sql);
            //System.out.println(sql);
            while(rs.next()){
                String name = rs.getString("name");
                String id = rs.getString("paymentId");
                Notification ob = new Notification();
                ob.sendNotification(name, id);
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
    public int getSize(){

        PreparedStatement stmt=null;
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //System.out.println(sql);
            String sql="SELECT COUNT(*) AS size FROM payment";
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
}
