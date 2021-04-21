package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDatabase {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/sh7";
		String username = "root"; // change as per your username
		String password = "rootroot"; // change as per your password
		try {
			// Establish Connection using username and password
			Connection connection = DriverManager.getConnection(dbURL, username, password);
			System.out.println("connected to database");

			// create statement/ preparementStatement/ CollableStatement to execute query
			Statement statement = connection.createStatement();

			String sql = "INSERT INTO EMP99 VALUES('6','JACK',5001,2,'C','2')";
			// String sql = "UPDATE EMP99 SET SAL = 9999 WHERE EMPNO = '1'";
			// String sql = "DELETE FROM EMP99 WHERE EMPNO = '1'";

			int count = statement.executeUpdate(sql);
			System.out.println(count + " row(s) affected");

			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("error!");
			e.printStackTrace();

		}

	}

}
