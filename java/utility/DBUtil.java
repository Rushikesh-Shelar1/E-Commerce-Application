package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*this class will define a static method which will establish connection
 * with database and return an object an object of Connection
 * 
 * 
 * 
 */
public class DBUtil {
	public static Connection getConnectionWithDb() throws ClassNotFoundException, SQLException {
		Connection con =null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CSJ36EWebProject1","root","tiger");
		System.out.println("connection established");
		return con;
		
	}

}
