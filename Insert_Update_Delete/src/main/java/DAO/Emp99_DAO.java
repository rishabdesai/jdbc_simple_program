package DAO;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import POJO.Emp99_pojo;
import utils.DbUtils;

public class Emp99_DAO implements Closeable{
	// put all CRUD operations here.
	
	private Connection connection;
	private Statement statement;
	
	public Emp99_DAO() throws Exception{
		this.connection = DbUtils.getConnection();
		this.statement= connection.createStatement();
	}
		
	// for SELECT statement
	public List<Emp99_pojo> selectEmpList99() throws Exception{
		String sql=  "SELECT * FROM EMP99";
		List<Emp99_pojo> empList = new ArrayList<>();
		try(ResultSet rs = statement.executeQuery(sql)){
			while(rs.next()) {
				Emp99_pojo empp = new Emp99_pojo(rs.getString(1),rs.getString(2),rs.getInt(3), rs.getInt(4),rs.getString(5),rs.getString(6));
				empList.add(empp);
			}
		}	
		return empList;
	}

	
	
	@Override
	public void close() throws IOException {
	try {
		statement.close();
		connection.close();
	} catch (SQLException e) {
		throw new IOException(e); //Exception chaining (Exceptions are handled by throwing new type of exception)
		}		
	}
}
