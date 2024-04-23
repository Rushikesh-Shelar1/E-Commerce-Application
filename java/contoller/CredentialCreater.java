package contoller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;
import java.io.PrintWriter;

import doa.UserDao;

/**
 * Servlet implementation class CredentialCreater
 */
@WebServlet("/BasicReg")
public class CredentialCreater extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CredentialCreater() {
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


		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		UserDao dao=new UserDao();
		int userId=Integer.parseInt(request.getParameter("t1"));
		String userName=request.getParameter("t2");
		String userPass=request.getParameter("t3");
		String userTpye=request.getParameter("t4");
		User userObj=new User(userId,userName,userPass,userTpye);
		User insertUser=dao.addUser(userObj);
		if(insertUser!=null) {
			User user=dao.getUserById(userId);
			if(user!=null) {
				HttpSession session =request.getSession(true);
				session.setAttribute("user-key", user);
				out.print("<script>alert('user credential created')</script>");
				RequestDispatcher rd=request.getRequestDispatcher("AdminReg.jsp");
				rd.include(request, response);
			}
		}
		else {
			out.print("<h3><font color ='red'>User not ableto register</font></h3>");
		}
		
	}

}
