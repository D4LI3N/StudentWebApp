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
@WebServlet("/DegreeEditServlet2")
public class DegreeEditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet() 
     */
    public DegreeEditServlet2() {
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
        String description=request.getParameter("description");  
        
        if(name != ""  && description != ""){
        
	        Degree degree = new Degree();  
	        degree.setId(id);  
	        degree.setName(name);  
	        degree.setDescription(description);  
 
	          
	        int status=DegreeDao.update(degree);  
	        if(status>0){  
	            response.sendRedirect("degrees");  
	        }else{  
	            out.println("Sorry! unable to update record");  
	        }  
        }else{
        	out.println("Please fill in the mandatory fields! (*)");
        	out.print("<a href=degrees>  <- Go back</a> ");
        }
        out.close();  
		
	}

}
