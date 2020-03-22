package game_tact;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
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
	         System.out.println(email);
	         System.out.println(usr);
	         System.out.println(pass);

	         
	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT register('"+usr+"','"+email+"','"+pass+"')");
	         System.out.println();
	         rs.close();
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");
	   }
	public static void login(String usr, String email, String pass) {
		Connection c = null;
	      Statement stmt = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://kandula.db.elephantsql.com:5432/pjthwgkl",
	            "pjthwgkl", "sK9ZBSjmWuziwv4QEqlwYTrHnrh_XD-4");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");
	         System.out.println(pass);

	         
	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT login('+email+','+pass+')");
	         System.out.println(rs.getInt(0));
	         rs.close();
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");
	   }
}
