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

import POJO.Emp99_pojo;
import utils.DbUtils;

public class ConnectToDatabase {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement =null;

		try {
			connection = DbUtils.getConnection();
			System.out.println("connected to database");

			
			statement = connection.createStatement();
			String sql="SELECT * FROM emp99";
			
			ResultSet rs =  statement.executeQuery(sql);
			
			//option-1 using default constructor.
			/*while (rs.next()) {
				
				Emp99_pojo emp99 = new Emp99_pojo(); 
				String empno = rs.getString(1);
				emp99.setEmpno(empno);
				String ename = rs.getString(2);
				emp99.setEname(ename);
				float sal = rs.getFloat(3);
				emp99.setSal(sal);
				int deptno = rs.getInt(4);
				emp99.setDeptno(deptno);
				String job = rs.getString(5);
				emp99.setJob(job);
				String mgr = rs.getString(6);
				emp99.setMgr(mgr);
				
				System.out.println(emp99.toString());
				//System.out.printf("%-4s\t%-10s\t%-10.2f\t%-2d\t%-2s\t%-4s\n", empno, ename, sal, deptno, job, mgr);
			}
			*/
			
			//option 2 - using parameterized constructor (first create parameterized ctor in POJO class)
			while(rs.next()) {
				Emp99_pojo emp99 = new Emp99_pojo(rs.getString(1),rs.getString(2),rs.getInt(3), rs.getInt(4),rs.getString(5),rs.getString(6));
				System.out.println(emp99.toString());
			}
			
		} catch (Exception e) {
			System.out.println("error!");
			e.printStackTrace();
		}
	}

}
