package contoller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

import java.io.IOException;
import java.io.PrintWriter;

import doa.ProductDao;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteProduct")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		int id=Integer.parseInt(request.getParameter("p1"));
		System.out.println(id);
		ProductDao dao=new ProductDao();
		int pobj=dao.removeProduct(id);
		if(pobj!=0) {
			out.println("<script>alert('product deleted successfully')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("adminTask.jsp");
			rd.include(request, response);
			
		}
		else {
			out.println("<h3><font color='red'>Not able to delete product</font></h3>");
		}
	}

}
