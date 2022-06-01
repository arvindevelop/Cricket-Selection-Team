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

import next.xadmin.login.bean.PlayerBean;
import next.xadmin.login.bean.TeamBean;
import next.xadmin.login.database.TeamDao;

/**
 * Servlet implementation class TeamServlet
 */
@WebServlet("/")
public class TeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TeamDao teamDAO;
	
	public void init() {
		teamDAO = new TeamDao();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertPlayer(request, response);
				break;
			case "/delete":
				deletePlayer(request, response);
				break;
			default:
				selectAllPlayers(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void selectAllPlayers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		List<TeamBean> listMember = teamDAO.selectAllPlayers(uid);
		request.setAttribute("listMember", listMember);
		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("member-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertPlayer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		int uid = Integer.parseInt(request.getParameter("uid"));
		String playername = request.getParameter("playername");
		String teamname = request.getParameter("teamname");
		TeamBean newMember = new TeamBean(pid,uid, playername, teamname);
		teamDAO.insertPlayer(newMember);
		response.sendRedirect("list");
	}
	
	private void deletePlayer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		int uid = Integer.parseInt(request.getParameter("uid"));
		if(teamDAO.deletePlayer(pid,uid)){
			response.sendRedirect("player");
		}
		else
		{
			response.sendRedirect("list");
		}

	}
	

}
