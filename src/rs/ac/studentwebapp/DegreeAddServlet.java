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
 * Servlet implementation class SaveServlet
 */
@WebServlet("/DegreeAddServlet")
public class DegreeAddServlet extends HttpServlet {
	public DegreeAddServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
		
		out.println("<html><head><title>StudentApp</title><link rel='stylesheet' type='text/css' href='/StudentApp/css/style.css'/></head><body></body></html>");
		
        out.println("<h1>Add Degree</h1>");  
          
        out.print("<form action='DegreeSaveServlet' method='post'>");  
        out.print("<table>");  
        
        out.print("<tr><td>Name:*</td><td><input type='text' name='name'/></td></tr>");  
        out.print("<tr><td>Description:*</td><td><input type='text' name='description' />	                </td></tr>"); 
        out.print("<tr><td></td><td><input type='hidden' name='id'/></td></tr>");  

        
        out.print("</select>");  
        out.print("</td></tr>");  
        out.print("<tr><td ><input type='submit' value='Save'/></td><td columnspan='2''><input type=\"button\" onclick=\"location.href='degrees';\" value=\"Cancel\" /></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
		
	}

}
