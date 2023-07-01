package rs.ac.studentwebapp;

import java.util.*;  
import java.sql.*;  

public class SubjectDao {  
  
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
    public static int save(Subject subject){  
        int status=0;  
        try{  
            Connection con=SubjectDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "INSERT INTO subjects (name,description,student_id) VALUES (?,?,?)");  
            ps.setString(1,subject.getName());  
            ps.setString(2,subject.getDescription());    
            ps.setString(3,""+subject.getStudentId());
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Subject subject){  
        int status=0;  
        try{  
            Connection con=SubjectDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "UPDATE subjects SET name=?,description=? WHERE id=?");  
            ps.setString(1,subject.getName());  
            ps.setString(2,subject.getDescription());  

            ps.setInt(3,subject.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=SubjectDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("DELETE FROM subjects WHERE id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Subject getSubjectById(int id){  
        Subject subject=new Subject();  
          
        try{  
            Connection con=SubjectDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("SELECT id,name,description FROM subjects WHERE id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                subject.setId(rs.getInt(1));  
                subject.setName(rs.getString(2));  
                subject.setDescription(rs.getString(3));   
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return subject;  
    }  

    
    public static List<Subject> getAllSubjects(){  
        List<Subject> list=new ArrayList<Subject>();  
          
        try{  
            Connection con=SubjectDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("SELECT id,student_id,name,description FROM subjects");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Subject subject=new Subject();  
                subject.setId(rs.getInt(1));  
                subject.setStudentId(rs.getInt(2));
                subject.setName(rs.getString(3));  
                subject.setDescription(rs.getString(4));  
                list.add(subject);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
    
    public static List<Subject> getAllSubjectsByStudentId(int student_id){  
        List<Subject> list=new ArrayList<Subject>();  
          
        try{  
            Connection con=SubjectDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("SELECT id,name,description FROM subjects WHERE student_id=?");  
            ps.setInt(1,student_id);    
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Subject subject=new Subject();  
                subject.setId(rs.getInt(1));  
                subject.setName(rs.getString(2));  
                subject.setDescription(rs.getString(3));  
                list.add(subject);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}


