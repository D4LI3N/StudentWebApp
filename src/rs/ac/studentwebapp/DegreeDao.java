package rs.ac.studentwebapp;

import java.util.*;  
import java.sql.*;  

public class DegreeDao {  
  
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
    public static int save(Degree degree){  
        int status=0;  
        try{  
            Connection con=DegreeDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "INSERT INTO degrees (name,description) VALUES (?,?)");  
            ps.setString(1,degree.getName());  
            ps.setString(2,degree.getDescription());    
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Degree degree){  
        int status=0;  
        try{  
            Connection con=DegreeDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "UPDATE degrees SET name=?,description=? WHERE id=?");  
            ps.setString(1,degree.getName());  
            ps.setString(2,degree.getDescription());  

            ps.setInt(3,degree.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=DegreeDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("DELETE FROM degrees WHERE id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Degree getDegreeById(int id){  
        Degree degree=new Degree();  
          
        try{  
            Connection con=DegreeDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("SELECT id,name,description FROM degrees WHERE id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                degree.setId(rs.getInt(1));  
                degree.setName(rs.getString(2));  
                degree.setDescription(rs.getString(3));   
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return degree;  
    }  

    
    public static List<Degree> getAllDegrees(){  
        List<Degree> list=new ArrayList<Degree>();  
          
        try{  
            Connection con=DegreeDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("SELECT id,name,description FROM degrees");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Degree degree=new Degree();  
                degree.setId(rs.getInt(1));  
                degree.setName(rs.getString(2));  
                degree.setDescription(rs.getString(3));  
                list.add(degree);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}


