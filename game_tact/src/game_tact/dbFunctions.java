package game_tact;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;




public class dbFunctions {

	public static int id;
	public static int sId;
	public static String gURL;
	public static String Nsv;
	public static String Ops;
	public static String username;
	public static String gmail;
	public static String pass;
    static ArrayList<Integer> stStat = new ArrayList<Integer>();
    static ArrayList<String> komentarji = new ArrayList<String>();
    public static int count=0;
	
    
	public static int register(String usr, String email, String pass) {
		Connection c = null;
	      Statement stmt = null;
	      int num = 1;
	      
	      try {
	    	 
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://kandula.db.elephantsql.com:5432/pjthwgkl",
	            "pjthwgkl", "sK9ZBSjmWuziwv4QEqlwYTrHnrh_XD-4"); 
	         System.out.println("Opened database successfully");
	         String sql="SELECT register('"+usr+"','"+email+"','"+pass+"')";
	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery(sql);
	         while ( rs.next() ) {
	            num = rs.getInt(1);
	            System.out.println(id);
	         }
	         if(num==0) {
		         sql=" INSERT INTO uporabniki (username, gmail, geslo) VALUES ('"+usr+"', '"+email+"', '"+pass+"');";
		         stmt = c.createStatement();
		         stmt.executeUpdate(sql);
		         }
	         System.out.println(sql.toString());
	         rs.close();
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      return num;
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
	      //Statement stmt = null;
	      try {
	    	  
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://kandula.db.elephantsql.com:5432/pjthwgkl",
	            "pjthwgkl", "sK9ZBSjmWuziwv4QEqlwYTrHnrh_XD-4");
	         
	         PreparedStatement ps=c.prepareStatement("SELECT posodobi(?,?,?,?)");
				ps.setInt(1,id);
				ps.setString(2,usr);
				ps.setString(3,email);
				ps.setString(4,geslo);
				ResultSet rs = ps.executeQuery();
				rs.next();
	         rs.close();
	         ps.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");

	}
	public static void dodajKomentar(String opis) {
		Connection c = null;
	      Statement stmt = null;
	      try {
	    	  
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://kandula.db.elephantsql.com:5432/pjthwgkl",
	            "pjthwgkl", "sK9ZBSjmWuziwv4QEqlwYTrHnrh_XD-4");

	         
	       
	         System.out.println("Opened database successfully");
	         String sql = "SELECT dodajKomentar("+id+",'"+opis+"',"+sId+")";
	         stmt = c.createStatement();
	         System.out.println(sql.toString());
	         ResultSet rs = stmt.executeQuery(sql);
	         rs.close();
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");
	}
	public static void dodajStrategijo(String opis, String naslov, String url) {
		Connection c = null;
	      Statement stmt = null;
	      try {
	    	  
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://kandula.db.elephantsql.com:5432/pjthwgkl",
	            "pjthwgkl", "sK9ZBSjmWuziwv4QEqlwYTrHnrh_XD-4");

	         
	       
	         System.out.println("Opened database successfully");
	         String sql = "SELECT dodajStrategijo("+id+",'"+opis+"','"+url+"','"+naslov+"')";
	         stmt = c.createStatement();
	         System.out.println(sql.toString());
	         ResultSet rs = stmt.executeQuery(sql);
	         rs.close();
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");

	}
	public static void posodobiStrategijo(String opis, String naslov, String url) {
		Connection c = null;
	      Statement stmt = null;
	      try {
	    	  
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://kandula.db.elephantsql.com:5432/pjthwgkl",
	            "pjthwgkl", "sK9ZBSjmWuziwv4QEqlwYTrHnrh_XD-4");

	         
	       
	         System.out.println("Opened database successfully");
	         String sql = "SELECT urediStrategijo("+id+",'"+opis+"','"+url+"','"+naslov+"',"+sId+")";
	         stmt = c.createStatement();
	         System.out.println(sql.toString());
	         ResultSet rs = stmt.executeQuery(sql);
	         rs.close();
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");
	      getInfo();

	}
	public static void izbrisiStrategijo() {
		Connection c = null;
	      Statement stmt = null;
	      try {
	    	  
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://kandula.db.elephantsql.com:5432/pjthwgkl",
	            "pjthwgkl", "sK9ZBSjmWuziwv4QEqlwYTrHnrh_XD-4");

	         
	       
	         System.out.println("Opened database successfully");
	         String sql = "SELECT izbrisiStrategijo("+sId+")";
	         stmt = c.createStatement();
	         System.out.println(sql.toString());
	         ResultSet rs = stmt.executeQuery(sql);
	         rs.close();
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");
	      getInfo();

	}
	public static void nextStrat() {
		
		if (count < stStat.size())
		{
			count++;
		}
		else
		{
			count=0;
		}
		getInfo();

	}
public static void backStrat() {
		
		if (count > 0)
		{
			count--;
		}
		else
		{
			count=0;
		}
		getInfo();

	}
	public static void getNum() {
		Connection c = null;
	      Statement stmt = null;
	      
	      
	      try {
	    	  
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://kandula.db.elephantsql.com:5432/pjthwgkl",
	            "pjthwgkl", "sK9ZBSjmWuziwv4QEqlwYTrHnrh_XD-4");

	         System.out.println("Opened database successfully");
	         
	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT id FROM \"public\".\"strategije\" order by id desc ");
	         while ( rs.next() ) {
		            stStat.add(rs.getInt(1));
		            System.out.println(1);
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
	public static void getInfo() {
		int id_ = stStat.get(count);
		Connection c = null;
	      Statement stmt = null;
	      
	      try {
	    	  
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://kandula.db.elephantsql.com:5432/pjthwgkl",
	            "pjthwgkl", "sK9ZBSjmWuziwv4QEqlwYTrHnrh_XD-4");

	         System.out.println("Opened database successfully");
	         
	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM \"public\".\"strategije\" where id="+id_+"");
	         while ( rs.next() ) {
	        	 sId = rs.getInt(1);
	        	 gURL = rs.getString(3);
	        	 Nsv = rs.getString(2);
	        	 Ops = rs.getString(4);
		         }
	         rs.close();
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println(gURL+","+Nsv+","+Ops+","+id_);
		
		
	}
	public static void getKomentarji() {
		Connection c = null;
	      Statement stmt = null;
	      
	      try {
	    	  
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://kandula.db.elephantsql.com:5432/pjthwgkl",
	            "pjthwgkl", "sK9ZBSjmWuziwv4QEqlwYTrHnrh_XD-4");

	         System.out.println("Opened database successfully");
	         
	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM \"public\".\"komentarji\" where strategija_id="+sId+"");
	         while ( rs.next() ) {
	        	 komentarji.add(rs.getString(4)+": "+rs.getString(2));
		         }
	         rs.close();
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
		
		
	}
}
