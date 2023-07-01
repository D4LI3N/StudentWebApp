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
@WebServlet("/StudentsSubjectsViewServlet")
public class StudentsSubjectsViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentsSubjectsViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
		int sid=Integer.parseInt(request.getParameter("studentId")); 
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
        PrintWriter out=response.getWriter(); 
        
        out.println("<html><head><title>StudentApp</title><link rel='stylesheet' type='text/css' href='/StudentApp/css/style.css'/></head><body></body></html>");
        
        
        out.println("<ul>");
        out.println("<li><a href='students'>Students </a></li>"); 
        out.println("<li><a href='degrees'>Degrees </a></li>");  
        out.println("<li class=\"active\" style=\"float:right\"><a href='subject-add?studentId="+sid+"'>(+) Add new Subject</a></li>"); 
        out.println("</ul>");
        out.println("<h1>Subjects for student: "+name+" "+surname+"</h1>");  
          
        List<Subject> list=SubjectDao.getAllSubjectsByStudentId(sid);  
          
        out.print("<table border='1' width='100%'/>");  
        out.print("<thead><tr><td>Subject</td><td>Description</td><td colspan=2>Actions</td</tr></thead>");  
        for(Subject subject:list){  
      
	      out.print("<tbody><tr><td>"+subject.getName()+"</td><td>"+subject.getDescription()+"</td>"+
	      "<td><a href='subject-edit?Id="+subject.getId()+"'>Edit</a></td>"+
	      "<td><a href='SubjectDeleteServlet?id="+subject.getId()+"'>Delete</a></td></tr>");  
        }  
        out.print("</tbody></table>");  
          
        out.close();  
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
