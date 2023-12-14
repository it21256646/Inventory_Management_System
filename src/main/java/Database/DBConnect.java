package Database;

import java.sql.*;

public class DBConnect {
	
	private static Connection connection;

	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {

		if (connection == null || connection.isClosed()) {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock?characterEncoding=latin1", "root", "Kasun#07");
		}
		
		return connection;
	}

}
