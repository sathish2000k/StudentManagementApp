package schoolManagementApp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {
	static final String DB_URL = "jdbc:mysql://localhost:3306/studentmanagementdb";
	static final String USER = "root"; 
	static final String PASSWORD = "sathish";
	
	public static Connection sqlConnection() {
		Connection connection;
		try {	
			connection = DriverManager.getConnection(DB_URL, USER, PASSWORD); 
		}
		catch(Exception exception) {
			connection=null;
			System.err.println(exception);
		}
		return connection;
	}

}
