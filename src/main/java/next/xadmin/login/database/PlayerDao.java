package next.xadmin.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import next.xadmin.login.bean.PlayerBean;

public class PlayerDao {

	private String dbUrl = "jdbc:mysql://localhost:3306/userdb";
	private String dbUname = "root";
	private String dbPassword = "";
	//private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	private static final String SELECT_ALL_PLAYERS = "select * from players";
	
	public PlayerDao() {
	}
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return connection;
	}
	
	public List<PlayerBean> selectAllPlayers() {
		
		List<PlayerBean> players = new ArrayList<>();
		
		//Establishing a Connection
		try (Connection connection = getConnection();

				// Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PLAYERS);) {
			//Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			//Process the ResultSet object.
			while (rs.next()) {
				int pid = rs.getInt("pid");
				String playername = rs.getString("playerName");
				double rating = rs.getDouble("rating");
				players.add(new PlayerBean(pid, playername, rating));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		
		return players;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
