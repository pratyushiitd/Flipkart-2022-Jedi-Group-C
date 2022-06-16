package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl {
    // Step 1
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    static List<String> studentID=new ArrayList<>();
    static List<String> studentName=new ArrayList<>();
    static List<String> studentPswd=new ArrayList<>();
    static List<String> studentEmail=new ArrayList<>();
    static List<Integer> studentSemester=new ArrayList<>();
    static List<String> studentDept=new ArrayList<>();
    static List<Float> studentCg=new ArrayList<>();
    static List<String> studentGender=new ArrayList<>();
    static List<String> studentPaymentID=new ArrayList<>();
    public static void addStudent(String id,String name,String pswd,String role,String email, int sem,
                                  int section,String dept,float cg,String gender,String paymentID,PreparedStatement stmt,
                                  Connection conn)
    {
        try{
        String sql="insert into student values(?,?,?,?,?,?,?,?,?,?,?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, id);
        stmt.setString(2,name);
        stmt.setString(3, pswd);
        stmt.setString(4, role);
        stmt.setString(5,email);
        stmt.setInt(6,sem );
        stmt.setInt(7,section );
        stmt.setString(8,dept);
        stmt.setFloat(9, cg);
        stmt.setString(10,gender);
        stmt.setString(11, paymentID);
        stmt.executeUpdate();
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
    public static void addStudent(String id,String name,String pswd,String email, int sem,
                                  String dept,float cg,String gender,String paymentID)
    {
        studentID.add(id);
        studentName.add(name);
        studentPswd.add(pswd);
        studentEmail.add(email);
        studentSemester.add(sem);
        studentDept.add(dept);
        studentCg.add(cg);
        studentGender.add(gender);
        studentPaymentID.add(paymentID);
    }
    public static void main(String[] args) {

        // Step 2
        // Declare the Coneection or prepaidstatement variable here


        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            // Step 3 Regiater Driver here and create connection

            Class.forName("com.mysql.jdbc.Driver");

            // Step 4 make/open  a connection

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            addStudent("s1","ankit","jedi_ankit","ankit@fk.com",1,"cse",0.0f,"M","");
            addStudent("s2","pramod","jedi_pramod","pramod@fk.com",1,"cse",0.0f,"M","");
            addStudent("s3","shreya","jedi_shreya","shreya@fk.com",1,"cse",0.0f,"F","");
            addStudent("s4","rahul","jedi_rahul","rahul@fk.com",1,"cse",0.0f,"M","");
            addStudent("s5","rohit","jedi_rohit","rohit@fk.com",1,"cse",0.0f,"M","");
            addStudent("s6","ansh","jedi_ansh","ansh@fk.com",1,"cse",0.0f,"F","");
            addStudent("s7","shruti","jedi_shruti","shruti@fk.com",1,"cse",0.0f,"M","");
            addStudent("s8","kavya","jedi_kavya","kavya@fk.com",1,"cse",0.0f,"M","");
            addStudent("s9","sarita","jedi_sarita","sarita@fk.com",1,"cse",0.0f,"F","");
            for(int i=0;i<9;i++)
            {
                addStudent(studentID.get(i),studentName.get(i),studentPswd.get(i),"student",studentEmail.get(i),studentSemester.get(i),1,
                        studentDept.get(i),studentCg.get(i),studentGender.get(i),studentPaymentID.get(i),stmt,conn);
            }

            //stmt.executeUpdate();


			   /*

			   // Let us update age of the record with ID = 102;
			      int rows = stmt.executeUpdate();
			      System.out.println("Rows impacted : " + rows );

			      // Let us select all the records and display them.
			      sql = "SELECT id, name ,address, location FROM employeefc";
			      ResultSet rs = stmt.executeQuery(sql);

			      //STEP 5: Extract data from result set
			      while(rs.next()){
			         //Retrieve by column name
			         int eid  = rs.getInt("id");
			         String name1 = rs.getString("name");
			         String address1 = rs.getString("address");
			         String location1 = rs.getString("location");

			         //Display values
			         System.out.print("ID: " + eid);
			         System.out.print(", Age: " + name1);
			         System.out.print(", First: " + address1);
			         System.out.println(", Last: " + location1);
			      }*/
            //STEP 6: Clean-up environment
            // rs.close();
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
        System.out.println("Goodbye!");
    }
}
