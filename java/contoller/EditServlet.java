package contoller;

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
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditProduct")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		int id=Integer.parseInt(request.getParameter("p1"));
		System.out.println(id);
		ProductDao dao=new ProductDao();
		Product pobj=dao.viewByProduct(id);

		out.println("<form action='updateProduct' method='post'>");
		   out.println("<label for='ID'>Enter ID:</lebel>");
		   out.println("<input type='text' name='t1' value='"+pobj.getProductId()+"' readonly='readonly'><br>");
		   
		   out.println("<label for='NAME'>Enter NAME:</lebel>");
		   out.println("<input type='text' name='t2' value='"+pobj.getProductName()+"'><br>");
		   
		   out.println("<label for='Category'>Enter Category:</lebel>");
		   out.println("<input type='text' name='t3' value='"+pobj.getProductCategory()+"'><br>");
		   
		   out.println("<label for='price'>Enter Price:</lebel>");
		   out.println("<input type='text' name='t4' value='"+pobj.getProductPrice()+"'><br>");
		   
		   out.println("<label for='brand'>Enter Brand:</lebel>");
		   out.println("<input type='text' name='t5' value='"+pobj.getProductBrand()+"'><br>");
		   
		   out.println("<label for='date'>Enter Date:</lebel>");
		   out.println("<input type='date' name='t6' value='"+pobj.getProductMfd()+"'><br>");
		   
		   out.println("<input type='submit' value='Update'>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
