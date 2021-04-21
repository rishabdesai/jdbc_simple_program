// Simple program the check the connectivity of java program with MySQL database.

package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDatabase {

	public static void main(String[] args) {
		Connection connection=null;
		
		//String dbURL = "jdbc:oracle:thin:@localhost:1521:Xe";
		String dbURL = "jdbc:mysql://localhost:3306/sh7";
		String username = "root"; // change as per your username
		String password = "rootroot"; // change as per your password

		try {
			connection = DriverManager.getConnection(dbURL, username, password);
			System.out.println("connected to database");
		} catch (SQLException e) {
			System.out.println("error!");
			e.printStackTrace();
		}
	}

}
