package rs.ac.studentwebapp;

import java.util.*;  
import java.sql.*;  

public class StudentDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
         //   Class.forName("oracle.jdbc.driver.OracleDriver");  
           // con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
        	
        	String url = "jdbc:mysql://localhost:3306/w2022?useLegacyDatetimeCode=false&serverTimezone=UTC";
    	    String username = "root";
    	    String password = "12345678";
    	    
    	Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.jdbc.Driver");  
    	 con=DriverManager.getConnection(url, username, password); 
        	
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Student student){  
        int status=0;  
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "INSERT INTO students (name,surname,email,degree) VALUES (?,?,?,?)");  
            ps.setString(1,student.getName());  
            ps.setString(2,student.getSurname());  
            ps.setString(3,student.getEmail());  
            ps.setString(4,student.getDegree());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Student student){  
        int status=0;  
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "UPDATE students SET name=?,surname=?,email=?,degree=? WHERE id=?");  
            ps.setString(1,student.getName());  
            ps.setString(2,student.getSurname());  
            ps.setString(3,student.getEmail());  
            ps.setString(4,student.getDegree());  
            ps.setInt(5,student.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("DELETE FROM students WHERE id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Student getStudentById(int id){  
        Student student=new Student();  
          
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("SELECT id,name,surname,email,degree FROM students WHERE id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                student.setId(rs.getInt(1));  
                student.setName(rs.getString(2));  
                student.setSurname(rs.getString(3));  
                student.setEmail(rs.getString(4));  
                student.setDegree(rs.getString(5));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return student;  
    }  
    public static List<Student> getAllStudents(){  
        List<Student> list=new ArrayList<Student>();  
          
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("SELECT id,name,surname,email,degree FROM students");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Student student=new Student();  
                student.setId(rs.getInt(1));  
                student.setName(rs.getString(2));  
                student.setSurname(rs.getString(3));  
                student.setEmail(rs.getString(4));  
                student.setDegree(rs.getString(5));  
                list.add(student);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
     
}  