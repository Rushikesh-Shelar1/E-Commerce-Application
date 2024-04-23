package contoller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.User;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpSession;

import doa.UserDao;

/**
 * Servlet implementation class LoginServlet1
 */
@WebServlet("/userLogin")
public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet1() {
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
		PrintWriter out =response.getWriter();
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("userPass");
		
		UserDao dao=new UserDao();
		User userObj=null;
		
		try {
			 userObj=dao.signIn(userName, password);
		} catch( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		if(userObj!=null) {
			HttpSession session=request.getSession(true);
			session.setAttribute("loginInfo", userObj);
			if(userObj.getUserType().equalsIgnoreCase("ADMIN")){
				response.sendRedirect("adminTask.jsp");
			}
			
		
		else if(userObj.getUserType().equalsIgnoreCase("customer")) {
			response.sendRedirect("customerPage.jsp");
		}
		}
	}

}
