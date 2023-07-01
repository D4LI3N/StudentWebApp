package rs.ac.studentwebapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/DegreeEditServlet")
public class DegreeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DegreeEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
        out.println("<h1>Update Degree</h1>");  
        int id=Integer.parseInt(request.getParameter("id"));  
        
        out.println("<html><head><title>StudentApp</title><link rel='stylesheet' type='text/css' href='/StudentApp/css/style.css'/></head><body></body></html>");
          
        Degree degree=DegreeDao.getDegreeById(id);
          
        out.print("<form action='DegreeEditServlet2' method='post'>");  
        out.print("<table>"); 
          
        out.print("<tr><td>Name:*</td><td><input type='text' name='name' value='"+degree.getName()+"'/></td></tr>");  
        out.print("<tr><td>Description:*</td><td><input type='text' name='description' value='"+degree.getDescription()+"'/>	                </td></tr>");  
        
        
        out.print("</td></tr>");
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+degree.getId()+"'/></td></tr>");
        out.print("<tr><td><input type='submit' value='Update'/></td><td columnspan='2''><input type=\"button\" onclick=\"location.href='degrees';\" value=\"Cancel\" /></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
