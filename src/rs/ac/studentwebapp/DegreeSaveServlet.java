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
@WebServlet("/DegreeSaveServlet")
public class DegreeSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DegreeSaveServlet() {
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
        String description=request.getParameter("description");  
        
        if(name != ""  && description != ""){
 
	          
	        Degree degree=new Degree();  
	        degree.setName(name);  
	        degree.setDescription(description);  

	          
	        int status=DegreeDao.save(degree);  
	        if(status>0){  
	            //
	            //request.getRequestDispatcher("index.html").include(request, response);
	        	//out.print("<p>Record saved successfully!</p>");  
	        	//out.print("<a href=StudentsViewServlet>  <- Go back</a> ");
	        	response.sendRedirect("DegreesViewServlet");
	        }else{  
	            out.println("Sorry! unable to save record");  
	        }  
        }else{
        	out.println("Please fill in the mandatory fields! (*)");
        	out.print("<a href=DegreesViewServlet>  <- Go back</a> ");
        }
        out.close();  
		
		
	}

}
