package DAO;

import java.io.Closeable;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import POJO.Emp99_pojo;
import utils.DbUtils;

public class Emp99_DAO implements Closeable {
	// put all CRUD operations here.

	private Connection connection;
	private Statement statement;

	public Emp99_DAO() throws Exception {
		this.connection = DbUtils.getConnection();
		this.statement = connection.createStatement();
	}
	
	//SELECT statement using stored procedure
	public int add_SP_emp99(Emp99_pojo e)throws Exception{
		int count = -1;
		String sql ="{CALL SP_ADD_EMP99(?,?,?,?,?,?)}";
		try(CallableStatement stmt = connection.prepareCall(sql)){
			stmt.setString(1, e.getEmpno());
			stmt.setString(2, e.getEname());
			stmt.setFloat(3, e.getSal());
			stmt.setInt(4, e.getDeptno());
			stmt.setString(5, e.getJob());
			stmt.setString(6, e.getMgr());
			boolean isResultSet = stmt.execute();
			if(!isResultSet)
				count=stmt.getUpdateCount();
		}
		return count;
	}


//	// for SELECT statement : to Display all the rows
//	public List<Emp99_pojo> selectEmpList99() throws Exception {
//		String sql = "SELECT * FROM EMP99";
//		List<Emp99_pojo> empList = new ArrayList<>();
//		try (ResultSet rs = statement.executeQuery(sql)) {
//			while (rs.next()) {
//				Emp99_pojo empp = new Emp99_pojo(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
//						rs.getString(5), rs.getString(6));
//				empList.add(empp);
//			}
//		}
//		return empList;
//	}
//
//	// for SELECT statement : to Display row of with specific empno
//	public List<Emp99_pojo> selectEmpList99(String eno) throws Exception {
//		String sql = "SELECT * FROM EMP99 where empno=?";
//		List<Emp99_pojo> empList = new ArrayList<>();
//		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//			stmt.setString(1, eno);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				Emp99_pojo empp = new Emp99_pojo(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
//						rs.getString(5), rs.getString(6));
//				empList.add(empp);
//			}
//
//		}
//		return empList;
//	}
//
//	// for SELECT statement : to Display row of with specific deptno
//	public List<Emp99_pojo> selectEmpList99(int deptno) throws Exception {
//		String sql = "SELECT * FROM EMP99 where deptno=?";
//		List<Emp99_pojo> empList = new ArrayList<>();
//		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//			stmt.setInt(1, deptno);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				Emp99_pojo empp = new Emp99_pojo(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
//						rs.getString(5), rs.getString(6));
//				empList.add(empp);
//			}
//
//		}
//		return empList;
//	}
//
//	// for SELECT statement : to Display row of with specific deptno
//	public List<Emp99_pojo> selectEmpList99(int deptno, String mgr) throws Exception {
//		String sql = "SELECT * FROM EMP99 where deptno=? and mgr=?";
//		List<Emp99_pojo> empList = new ArrayList<>();
//		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//			stmt.setInt(1, deptno);
//			stmt.setString(2, mgr);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				Emp99_pojo empp = new Emp99_pojo(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
//						rs.getString(5), rs.getString(6));
//				empList.add(empp);
//			}
//
//		}
//		return empList;
//	}
//	
//
//	

//	// INSERT statement- insert new record in database
//	public int addEmp99(Emp99_pojo e) throws Exception {
//		int count = -1;
//		String sql = "insert into emp99 values(?,?,?,?,?,?)";
//		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//			stmt.setString(1, e.getEmpno());
//			stmt.setString(2, e.getEname());
//			stmt.setFloat(3, e.getSal());
//			stmt.setInt(4, e.getDeptno());
//			stmt.setString(5, e.getJob());
//			stmt.setString(6, e.getMgr());
//			count = stmt.executeUpdate();
//
//		}
//		return count;
//
//	}
//	
//	//UPDATE - update the salary
//	public int updateSalary(String empno,float sal) throws Exception{
//		int count=-1;
//		String sql="update Emp99 set sal=? where empno=?";
//		try(PreparedStatement stmt = connection.prepareStatement(sql)){
//			stmt.setFloat(1, sal);
//			stmt.setString(2, empno);
//			count =stmt.executeUpdate();
//		}
//		return count;
//		
//	}
//	
//	//DELETE - delete employee based on empno
//	public int deleteEmp99(String empno) throws Exception{
//		int count =-1;
//		String sql="delete from emp99 where empno=?";
//		try(PreparedStatement stmt = connection.prepareStatement(sql)){
//			stmt.setString(1, empno);
//			count=stmt.executeUpdate();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return count;
//	}
//	
//
	@Override
	public void close() throws IOException {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new IOException(e); // Exception chaining (Exceptions are handled by throwing new type of exception)
		}
	}
}
