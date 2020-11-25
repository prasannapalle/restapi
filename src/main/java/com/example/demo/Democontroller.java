package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.web.bind.annotation.GetMapping;

public class Democontroller {

	 public String DB_URL = "jdbc:mysql://lab2-275.cvkuzzrejj5b.us-west-1.rds.amazonaws.com/demo";
	public Democontroller() {
		// TODO Auto-generated constructor stub
	}
	@GetMapping("/getstudent")
	public String Records() throws SQLException, ClassNotFoundException
	 {
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      Class.forName("com.mysql.cj.jdbc.Driver");


		      conn = DriverManager.getConnection(DB_URL,"admin","admindatabase");

	
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT * FROM Student";
		      ResultSet rs = stmt.executeQuery(sql);

		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("SID");
		         String first = rs.getString("subjectname");
		         String last = rs.getString("course");
		         String email= rs.getString("email");
		         String city= rs.getString("address");
		         
		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", Subject Name: " + first);
		         System.out.print(", : Course" + last);
		         System.out.print(", Email: " + email);
		         System.out.println(", Address: " + city);
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
		   System.out.println("Done!");
		return "done";
		}
}
