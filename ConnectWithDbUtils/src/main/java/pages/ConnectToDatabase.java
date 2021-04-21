// Simple program the check the connectivity of java program with MySQL database.

package pages;

import java.sql.Connection;

import utils.DbUtils;

public class ConnectToDatabase {

	public static void main(String[] args) {
		Connection connection = null;

		try {
			connection = DbUtils.getConnection();
			System.out.println("connected to database");

		} catch (Exception e) {
			System.out.println("error!");
			e.printStackTrace();
		}
	}

}
