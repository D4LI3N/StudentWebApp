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
 * Servlet implementation class ViewServlet
 */
@WebServlet("/DegreesViewServlet")
public class DegreesViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DegreesViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<html><head><title>StudentApp</title><link rel='stylesheet' type='text/css' href='/StudentApp/css/style.css'/></head><body></body></html>");
        
        
        out.println("<ul>");
        out.println("<li><a href='students'>Students </a></li>"); 
        out.println("<li><a class=\"active\" href='degrees'>Degrees </a></li>");  
        out.println("<li style=\"float:right\"><a href='degree-add'>(+) Add new Degree</a></li>"); 
        out.println("</ul>");
        out.println("<h1>Degrees</h1>");  
          
        List<Degree> list=DegreeDao.getAllDegrees();  
          
        out.print("<table border='1' width='100%'/>");  
        out.print("<thead><tr><td>Id</td><td>Name</td><td>Description</td><td colspan=2>Actions</td></tr></thead>");  
        for(Degree degree:list){  
        	
        	
      out.print("<tbody><tr><td>"+degree.getId()+"</td><td>"+degree.getName()+"</td><td>"+degree.getDescription()+
    		  "</td><td><a href='degree-edit?id="+degree.getId()+"'>Edit</a></td><td><a href='DegreeDeleteServlet?id="+degree.getId()+"'>Delete</a></td></tr>");  
        }  
        out.print("<tbody></table>");  
          
        out.close();  
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
