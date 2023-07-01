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
@WebServlet("/StudentsViewServlet")
public class StudentsViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentsViewServlet() {
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
        out.println("<li><a class=\"active\" href='students'>Students </a></li>"); 
        out.println("<li><a href='degrees'>Degrees </a></li>");  
        out.println("<li style=\"float:right\"><a href='student-add'>(+) Add new Student</a></li>"); 
        out.println("</ul>");
        out.println("<h1>Students</h1>");  
          
        List<Student> list=StudentDao.getAllStudents();  
          
        out.print("<table width='100%'/>");  
        out.print("<thead><tr><td>Id</td><td>Name</td><td>Surname</td><td>Email</td><td>Degree</td><td colspan=\"3\">Actions</td></tr></thead>");  
        for(Student student:list){  
       	
        
      out.print("<tbody><tr><td>"+student.getId()+"</td><td>"+student.getName()+"</td><td>"+student.getSurname()+"</td><td>"+student.getEmail()+"</td><td>"+student.getDegree()+"</td>"+
      "<td><a href='subjects?studentId="+student.getId()+"&name="+student.getName()+"&surname="+student.getSurname()+"'>Subjects</a></td>"+
      "<td><a href='student-edit?id="+student.getId()+"'>Edit</a></td>"+
      "<td><a href='StudentDeleteServlet?id="+student.getId()+"'>Delete</a></td></tr>");  
        }  
        out.println("</tbody></table>"); 
          
        out.close();  
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
