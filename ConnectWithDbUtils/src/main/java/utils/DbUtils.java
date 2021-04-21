package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtils {
	//public static final String URL = "jdbc:oracle:thin:@localhost:1521:Xe";
	public static final String URL = "jdbc:mysql://localhost:3306/sh7";
	public static final String USER = "root";
	public static final String PASSWORD = "rootroot";
	
	public static Connection getConnection( ) throws Exception {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

}
