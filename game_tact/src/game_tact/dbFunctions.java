package game_tact;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class dbFunctions {

	public static int id;
	public static String username;
	public static String gmail;
	public static String pass;
	
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
	public static void loginInfo(String email) {
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
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM \"public\".\"uporabniki\"WHERE gmail='"+email+"'" );
	         while ( rs.next() ) {
	            id = rs.getInt("id");
	            username = rs.getString("username");
	            gmail = rs.getString("gmail");
	            pass = rs.getString("geslo");
	            System.out.println(id+","+username);

	         }
	         rs.close();
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");

	}
	public static void updateUser(String email, String geslo, String usr) {
		Connection c = null;
	      Statement stmt = null;
	      try {
	    	  
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://kandula.db.elephantsql.com:5432/pjthwgkl",
	            "pjthwgkl", "sK9ZBSjmWuziwv4QEqlwYTrHnrh_XD-4");
	         c.setAutoCommit(false);
	         
	         PreparedStatement ps=c.prepareStatement("SELECT posodobi(?,?,?,?)");
				ps.setInt(1,id);
				ps.setString(2,usr);
				ps.setString(3,email);
				ps.setString(4,geslo);
				ResultSet rs = ps.executeQuery();
				rs.next();
				/*
	         System.out.println("Opened database successfully");
	         String sql = "SELECT posodobi("+id+",'"+usr+"','"+email+"','"+pass+"')";
	         stmt = c.createStatement();
	         System.out.println(sql.toString());
	         ResultSet rs = stmt.executeQuery(sql);*/
	         rs.close();
	         ps.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");

	}
}
