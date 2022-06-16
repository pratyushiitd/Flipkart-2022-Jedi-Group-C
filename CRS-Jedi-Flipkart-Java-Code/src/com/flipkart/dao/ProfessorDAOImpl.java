package com.flipkart.dao;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfessorDAOImpl {
    // Step 1
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    static List<String> professorID = new ArrayList<String>();
    static List<String> professorName = new ArrayList<String>();
    static List<String> professorPswd = new ArrayList<String>();
    static List<String> professorEmail = new ArrayList<String>();
    static List<String> professorDept = new ArrayList<String>();

    public static void addProfessor(String id, String name, String pswd, String email, String dept) {
        professorID.add(id);
        professorName.add(name);
        professorPswd.add(pswd);
        professorEmail.add(email);
        professorDept.add(dept);
        }
    public static void addProfessor(String id, String name, String pswd, String email, String dept, PreparedStatement stmt, Connection conn) {

        try {
            String sql = "insert into professor values(?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.setString(3, pswd);
            stmt.setString(4, email);
            stmt.setString(5, dept);
            stmt.executeUpdate();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

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
            addProfessor("p1", "Naveen", "jedi_naveen", "naveen@fk.com", "CSE");
            addProfessor("p2", "Sachin", "jedi_sachin", "sachin@fk.com", "CSE");
            addProfessor("p3", "Vijay", "jedi_vijay", "vijay@fk.com", "CSE");
            addProfessor("p4", "Ramesh", "jedi_ramesh", "ramesh@fk.com", "CSE");
            addProfessor("p5", "Suresh", "jedi_suresh", "suresh@fk.com", "CSE");
            addProfessor("p6", "Sachin", "jedi_sachin", "sachin@fk.com", "CSE");
            for(int i=0;i<6;i++) {
                addProfessor(professorID.get(i), professorName.get(i), professorPswd.get(i), professorEmail.get(i), professorDept.get(i), stmt, conn);
            }
            //String sql="insert into employeefc values(?,?,?,?)";
            //String sql = "UPDATE Employees set age=? WHERE id=?";
            // String sql1="delete from employee where id=?";
            // stmt.setInt(1, 101);
            //stmt = conn.prepareStatement(sql);

            // Hard coded data

            /*int id=627;
            String name="Vabhav";
            String address="Delhi";
            String location="india";
            //Bind values into the parameters.
            stmt.setInt(1, id);  // This would set age
            stmt.setString(2,name);
            stmt.setString(3, address);
            stmt.setString(4, location);
            */stmt.executeUpdate();


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
