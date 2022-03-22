package Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		ArrayList<User> list=new ArrayList<User>();
		Connection con;
		   String driver = "com.mysql.jdbc.Driver";
		   String url = "jdbc:mysql://localhost:3306/school";
		   String user = "root";
		   String password = "467502";
		   try {
	            Class.forName(driver);	             
	            con = DriverManager.getConnection(url,user,password);	     
	            Statement statement = con.createStatement();
	            String sql = "select * from user";
	             ResultSet rs = statement.executeQuery(sql);                 
	             String username = null;
	             String password1 = null;
	             while(rs.next()){
	                 username = rs.getString("username");
	                 password1 = rs.getString("password");
	                 User u=new User(username,password1);
	                 list.add(u);
	             }
	             rs.close();
	             con.close();
	         } catch(ClassNotFoundException e) {   
	             System.out.println("Sorry,can`t find the Driver!");   
	            e.printStackTrace();   
	             } catch(SQLException e) {
	             e.printStackTrace();  
	         }catch (Exception e) {
	           e.printStackTrace();
	        }finally{
	        }
		   for(int i=0;i<list.size();i++) {
			   System.out.println(list.get(i).getUsername()+"  "+list.get(i).getPassword());
		   }
	}

}
