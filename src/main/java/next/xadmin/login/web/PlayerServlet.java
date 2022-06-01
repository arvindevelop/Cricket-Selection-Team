package next.xadmin.login.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import next.xadmin.login.bean.PlayerBean;
import next.xadmin.login.bean.TeamBean;
import next.xadmin.login.database.PlayerDao;
import next.xadmin.login.database.TeamDao;

/**
 * Servlet implementation class PlayerServlet
 */
@WebServlet("/player")
public class PlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlayerDao playerDAO;
	private TeamDao teamDAO;
		
	public void init() {
			playerDAO = new PlayerDao();
			teamDAO = new TeamDao();
	}
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				try {
					listPlayer(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}


	private void listPlayer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<PlayerBean> listPlayer = playerDAO.selectAllPlayers();
		request.setAttribute("listPlayer", listPlayer);
		
		HttpSession s=request.getSession();
		int uid = (int) s.getAttribute("uid");
		List<TeamBean> listMember = teamDAO.selectAllPlayers(uid);
		request.setAttribute("listMember", listMember);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("player-list.jsp");
		dispatcher.forward(request, response);
	}


}
