package next.xadmin.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import next.xadmin.login.bean.PlayerBean;
import next.xadmin.login.bean.TeamBean;

public class TeamDao {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/userdb";
	private String dbUname = "root";
	private String dbPassword = "";
	
	private static final String INSERT_TEAM_SQL = "INSERT INTO teams" + "  (uid, pid, teamName, playerName) VALUES "
			+ " (?, ?, ?, ?);";
	private static final String SELECT_PLAYER_BY_ID = "select pid,playerName from players where pid =?";
	private static final String DELETE_PLAYER_SQL = "delete from teams where pid = ? and uid = ?;";
	private static final String SELECT_TEAM_BY_ID = "select * from teams where uid = ?;";
	
	public TeamDao() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return connection;
	}
	
	public void insertPlayer(TeamBean player) throws SQLException {
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TEAM_SQL)) {
			preparedStatement.setInt(1, player.getUid());
			preparedStatement.setInt(2, player.getPid());
			preparedStatement.setString(3, player.getTeamname());
			preparedStatement.setString(4, player.getPlayername());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public List<TeamBean> selectAllPlayers(int id) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<TeamBean> players = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TEAM_BY_ID)) {
			preparedStatement.setInt(1, id);
			
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int pid = rs.getInt("pid");
				int uid = rs.getInt("uid");
				String teamname = rs.getString("teamname");
				String playername = rs.getString("playername");
				players.add(new TeamBean(pid, uid, teamname, playername));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return players;
	}

	public boolean deletePlayer(int pid,int uid) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_PLAYER_SQL);) {
			statement.setInt(1, pid);
			statement.setInt(2, uid);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
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
