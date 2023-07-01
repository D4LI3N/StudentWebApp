package rs.ac.studentwebapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/StudentSaveServlet")
public class StudentSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("name");  
        String surname=request.getParameter("surname");  
        String email=request.getParameter("email");  
        String degree=request.getParameter("degree");  
        
        if(name != ""  && surname != ""){
 
	          
	        Student student=new Student();  
	        student.setName(name);  
	        student.setSurname(surname);  
	        student.setEmail(email);  
	        student.setDegree(degree);  
	          
	        int status=StudentDao.save(student);  
	        if(status>0){  
	            //
	            //request.getRequestDispatcher("index.html").include(request, response);
	        	//out.print("<p>Record saved successfully!</p>");  
	        	//out.print("<a href=StudentsViewServlet>  <- Go back</a> ");
	        	response.sendRedirect("StudentsViewServlet");
	        }else{  
	            out.println("Sorry! unable to save record");  
	        }  
        }else{
        	out.println("Please fill in the mandatory fields! (*)");
        	out.print("<a href=StudentsViewServlet>  <- Go back</a> ");
        }
        out.close();  
		
		
	}

}
