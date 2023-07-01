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
@WebServlet("/StudentEditServlet")
public class StudentEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
        out.println("<h1>Update Student</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        
        out.println("<html><head><title>StudentApp</title><link rel='stylesheet' type='text/css' href='/StudentApp/css/style.css'/></head><body></body></html>");
          
        Student student=StudentDao.getStudentById(id);
        List<Degree> list=DegreeDao.getAllDegrees();
          
        out.print("<form action='StudentEditServlet2' method='post'>");  
        out.print("<table>");  
        
        out.print("<tr><td>Name:*</td><td><input type='text' name='name' value='"+student.getName()+"'/></td></tr>");  
        out.print("<tr><td>Surname:*</td><td><input type='text' name='surname' value='"+student.getSurname()+"'/>	                </td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+student.getEmail()+"'/></td></tr>");  
        out.print("<tr><td>Degree:</td><td>");  
        out.print("<select name='degree' style='width:150px'>");  
        
        for(Degree degree:list) {
        	out.print("<option>"+degree.getName()+"</option>"); 
        }
        
        
        out.print("</select>");  
        
        out.print("</td></tr>");
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+student.getId()+"'/></td></tr>");  
        out.print("<tr><td><input type='submit' value='Update'/></td><td columnspan='2''><input type=\"button\" onclick=\"location.href='students';\" value=\"Cancel\" /></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
