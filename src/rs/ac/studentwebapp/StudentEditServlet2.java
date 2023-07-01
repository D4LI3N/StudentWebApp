package rs.ac.studentwebapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/StudentEditServlet2")
public class StudentEditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentEditServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("name");  
        String surname=request.getParameter("surname");  
        String email=request.getParameter("email");  
        String degree=request.getParameter("degree");
        
        if(name != ""  && surname != ""){
        
	        Student student=new Student();  
	        student.setId(id);  
	        student.setName(name);  
	        student.setSurname(surname);  
	        student.setEmail(email);  
	        student.setDegree(degree);  
	          
	        int status=StudentDao.update(student);  
	        if(status>0){  
	            response.sendRedirect("students");  
	        }else{  
	            out.println("Sorry! unable to update record");  
	        }  
        }else{
        	out.println("Please fill in the mandatory fields! (*)");
        	out.print("<a href=students>  <- Go back</a> ");
        }
        out.close();  
		
	}

}
