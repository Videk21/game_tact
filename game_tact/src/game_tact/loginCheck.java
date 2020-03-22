package game_tact;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class loginCheck {
	public static void main(String args[]) {
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
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM \"public\".\"uporabniki\"" );
	         while ( rs.next() ) {
	            int id = rs.getInt("id");
	            String  usr = rs.getString("username");
	            String gmail  = rs.getString("gmail");
	            String  geslo = rs.getString("geslo");
	            System.out.println( "USERNAME = " + id );
	            System.out.println( "NAME = " + gmail );
	            System.out.println( "AGE = " + geslo );
	            System.out.println();
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
	
}
