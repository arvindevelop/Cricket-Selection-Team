package next.xadmin.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import next.xadmin.login.bean.LoginBean;
import next.xadmin.login.bean.PlayerBean;

public class LoginDao {
	
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
	
	public int validate(LoginBean loginBean)
	{
		
		int uid = 0;
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		String sql = "select * from user where username = ? and password =?";
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, loginBean.getUsername());
		ps.setString(2, loginBean.getPassword());
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			uid = rs.getInt("uid");
		}
		
		//System.out.println(uid);
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return uid;
	}

}
