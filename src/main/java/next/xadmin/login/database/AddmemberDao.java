package next.xadmin.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import next.xadmin.login.bean.AddmemberBean;


public class AddmemberDao {
	
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
	
	public boolean validate(AddmemberBean addmemberBean)
	{
		boolean status = false;
				
		loadDriver(dbDriver);
		Connection con = getConnection();
				
		String sql = "insert into teams(uid,pid,teamName, playerName) values(?, ?, ?, ?)";
		PreparedStatement ps;
		try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, addmemberBean.getUid());
				ps.setInt(2, addmemberBean.getPid());
				ps.setString(3, addmemberBean.getTeamname());
				ps.setString(4, addmemberBean.getPlayername());
				int rs = ps.executeUpdate();
				if(rs != 0)
					status = true;
				
			} catch (SQLException e) {
					e.printStackTrace();
			}
		return status;
	}

}
