package next.xadmin.login.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import next.xadmin.login.bean.AddmemberBean;
import next.xadmin.login.bean.LoginBean;
import next.xadmin.login.database.AddmemberDao;
import next.xadmin.login.database.LoginDao;

/**
 * Servlet implementation class AddMemberServlet
 */
@WebServlet("/addmember")
public class AddMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession s=request.getSession();
		int uid = (int) s.getAttribute("uid");
		int pid = Integer.parseInt(request.getParameter("pid"));
		String playername = request.getParameter("playername");
		String teamname = request.getParameter("teamname");
		
		AddmemberBean addmemberBean = new AddmemberBean();
		addmemberBean.setUid(uid);
		addmemberBean.setPid(pid);
		addmemberBean.setTeamname(teamname);
		addmemberBean.setPlayername(playername);
		
		AddmemberDao addmemberDao = new AddmemberDao();
		
		if(addmemberDao.validate(addmemberBean))
		{
			response.sendRedirect("player");
		}
		else
		{
			response.sendRedirect("player");
		}
	}

}
