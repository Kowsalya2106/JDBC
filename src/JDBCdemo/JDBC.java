package JDBCdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {

	public static void main(String[] args) {
	
	try 
	{
	  ReadRecords();
	  InsertUsingPST();
	  UpdateRecords();
	  DeleteRecords();
	  }
    catch(Exception e)
    {
    	e.printStackTrace();
    	System.out.println("something happended");
    }
       }
	    public static void ReadRecords() throws Exception {
	        String url = "jdbc:mysql://localhost:3306/demodatabase";
	        String username = "root";
	        String password = "root";
	        String query = "SELECT * FROM Register";

	        // Establish connection
	        Connection con = DriverManager.getConnection(url, username, password);

	        // Create a statement
	        Statement st = con.createStatement();

	        // Execute query and store the result
	        ResultSet rs = st.executeQuery(query);

	        // Process the result set
	        while (rs.next()) 
	        {
	            System.out.println("Name: " + rs.getString(1));
	            System.out.println("Password: " + rs.getString(2));
	            System.out.println("Address: " + rs.getString(3));
	            System.out.println("Email : " + rs.getString(4));
	            System.out.println("--------------------------");
	        }
	    }
	        //inserUsingPST
	         public static void InsertUsingPST() throws Exception {
	            String url = "jdbc:mysql://localhost:3306/demodatabase";
	            String username = "root";
	            String password = "root";

	            Connection conn = DriverManager.getConnection(url, username, password);
	            String query = "INSERT INTO Student (id, name, age) VALUES (?, ?, ?)";

	            PreparedStatement pst = conn.prepareStatement(query);
	            pst.setInt(1, 4);
	            pst.setString(2, "Jaanu");
	            pst.setInt(3, 21);

	            int rows = pst.executeUpdate();
	            System.out.println("Inserted rows: " + rows);

	            pst.close();
	            conn.close();
	        }
	    
	        //Update
             public static void UpdateRecords() throws Exception
            {
            	String url="jdbc:mysql://localhost:3306/demodatabase";
            	String username="root";
            	String password="root";
            	
            	Connection conn=DriverManager.getConnection(url,username,password);
            	String query = "Update Student set age=23 where id =1";
            	Statement st=conn.createStatement();
            	int rows=st.executeUpdate(query);
            	
            	System.out.println("value inserted successfully");
            	
            }
             //Delete 
             public static void DeleteRecords() throws Exception
             {
                String url="jdbc:mysql://localhost:3306/demodatabase";
                String username="root";
                String password="root";
                
                Connection conn=DriverManager.getConnection(url,username,password);
                			
                	int id=4;

                	String query = "delete from Student where id="+id;

                			
                	Connection con = DriverManager.getConnection(url,username,password);
                	Statement st = con.createStatement();
                	int rows = st.executeUpdate(query);
                			
                	System.out.println("Number of rows affected: " + rows);		
                	
               }  		
             }
             

