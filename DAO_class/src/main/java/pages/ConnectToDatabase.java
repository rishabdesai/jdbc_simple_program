/*  Using POJO class (Emp99_pojo.class)
 *  in Database -> row, column, table, primary key
 *  in java 	-> instance, field, class, ID field
 *  to map database entities with java entities , we use POJO class
 *  This mapping is called as Object Relational mapping (ORM)
 */

package pages;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import DAO.Emp99_DAO;
import POJO.Emp99_pojo;
import utils.DbUtils;

public class ConnectToDatabase {
	
	
	public static void print(List<Emp99_pojo> empList) {
		if (empList != null) {
			for (Emp99_pojo emp1 : empList) {
				System.out.println(emp1.toString());
			}
		}
	}

	public static void main(String[] args) {
		try (Emp99_DAO dao = new Emp99_DAO()) {
			List<Emp99_pojo> e1 = dao.selectEmpList99();
			ConnectToDatabase.print(e1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	}