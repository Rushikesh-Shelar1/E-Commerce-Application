package contoller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Admin;
import model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import doa.AdminDao;

/**
 * Servlet implementation class AdminSignupServlet
 */
@WebServlet("/AdminReg")
public class AdminSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSignupServlet() {
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
		
		//reading all inputs from client
		int adminId=Integer.parseInt(request.getParameter("id"));
		String adminName=request.getParameter("name");
		String adminAddress= request.getParameter("address");
		String adminEmail=request.getParameter("mail");
		long ph=Long.parseLong(request.getParameter("phone"));
		String dob=request.getParameter("dob");
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		Date adminDob=null;
		try {
			adminDob=format.parse(dob);
		}catch(ParseException e) {
			System.out.println(e);
		}
		//getting user object from session
		HttpSession session =request.getSession(false);
		User user=(User)session.getAttribute("user-key");
		
		Admin adminObj=new Admin(adminId,adminName,adminAddress,adminEmail,ph,adminDob,user);
		
		AdminDao dao=new AdminDao();
		Admin insertedStatus=dao.addAdmin(adminObj);
		if(insertedStatus!=null) {
			out.println("<center><h3><font color='blue'>Registration completed Successfully</font></h3></center>");
			out.println("<a href='login.jsp'>Login Here</a>");
			
		}
		else {
			out.println("<center><h3><font color='red'>Registration failed</font></h3></center>");
		}
	}

}
