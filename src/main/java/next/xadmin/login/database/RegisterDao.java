package next.xadmin.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import next.xadmin.login.bean.RegisterBean;

public class RegisterDao {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/userdb";
	private String dbUname = "root";
	private String dbPassword = "";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return con;
	}
	
	public boolean validate(RegisterBean registerBean)
	{
		boolean status = false;
		
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		String sql = "insert into user(username,password,email) values(?, ?, ?)";
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, registerBean.getUsername());
		ps.setString(2, registerBean.getPassword());
		ps.setString(3, registerBean.getEmail());
		int rs = ps.executeUpdate();
		if(rs != 0)
			status = true;
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return status;
	}

}
