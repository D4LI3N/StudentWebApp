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
@WebServlet("/StudentAddServlet")
public class StudentAddServlet extends HttpServlet {
	public StudentAddServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
		List<Degree> list=DegreeDao.getAllDegrees();
		
		out.println("<html><head><title>StudentApp</title><link rel='stylesheet' type='text/css' href='/StudentApp/css/style.css'/></head><body></body></html>");
		
        out.println("<h1>Add Student</h1>");  
          
        out.print("<form action='StudentSaveServlet' method='post'>");  
        out.print("<table id='table1'>");  
         
        out.print("<tr><td>Name:*</td><td><input type='text' name='name'/></td></tr>");  
        out.print("<tr><td>Surname:*</td><td><input type='text' name='surname' />	                </td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='email' name='email'/></td></tr>");  
        out.print("<tr><td>Degree:</td><td>");  
        out.print("<select name='degree' style='width:150px'>"); 
        
        for(Degree degree:list) {
        	out.print("<option>"+degree.getName()+"</option>"); 
        }  
        
        out.print("</select>");  
        out.print("</td></tr>");  
        out.print("<tr><td></td><td><input type='hidden' name='id'/></td></tr>"); 
        out.print("<tr><td ><input type='submit' value='Save'/></td><td columnspan='2''><input type=\"button\" onclick=\"location.href='students';\" value=\"Cancel\" /></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
		
	}

}
