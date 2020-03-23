package game_tact;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class dbFunctions {
	
	public static void register(String usr, String email, String pass) {
		Connection c = null;
	      Statement stmt = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://kandula.db.elephantsql.com:5432/pjthwgkl",
	            "pjthwgkl", "sK9ZBSjmWuziwv4QEqlwYTrHnrh_XD-4");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");
	         String sql="SELECT register('"+usr+"','"+email+"','"+pass+"')";
	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery(sql);
	         while ( rs.next() ) {
	            int id = rs.getInt(1);
	            System.out.println(id);
	         }
	         System.out.println(sql.toString());
	         rs.close();
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      
	   }
	public static Boolean login(String email, String pass) {
		Connection c = null;
	      Statement stmt = null;
	      Boolean id = false;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://kandula.db.elephantsql.com:5432/pjthwgkl",
	            "pjthwgkl", "sK9ZBSjmWuziwv4QEqlwYTrHnrh_XD-4");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");
	        
	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT login('"+email+"','"+pass+"')" );
	         while ( rs.next() ) {
	            id = rs.getBoolean(1);           
	            System.out.println(id);
	            
	         }
	         rs.close();
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");
		return id;
	      
	}
	public static Integer loginInfo(String email) {
		int id = 0;
		Connection c = null;
	      Statement stmt = null;
	      try {
	    	  
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://kandula.db.elephantsql.com:5432/pjthwgkl",
	            "pjthwgkl", "sK9ZBSjmWuziwv4QEqlwYTrHnrh_XD-4");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");
	         
	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT id FROM \"public\".\"uporabniki\"WHERE gmail='"+email+"'" );
	         while ( rs.next() ) {
	            id = rs.getInt("id");
	            System.out.println(id);

	         }
	         rs.close();
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");
		return id;
	}
}
