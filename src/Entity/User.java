package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User implements Serializable {
	private String username;
	private String password;
	private String sex;
	private String major;
	private String address;
	private String email;
	private String degree;
	private String phone;
	private ArrayList<Course> List = new ArrayList<Course>();
	public ArrayList<Course> getList() {
		return List;
	}
	public void Add(Course c) {
		List.add(c);
	}
	public void setList(ArrayList<Course> list) {
		List = list;
	}
	public String getAddress() {
		return address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getUsername() {
		return username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public User() {
		super();
	}

	public User(String username, String sex, String major, String address, String email, String degree, String phone) {
		super();
		this.username = username;
		this.sex = sex;
		this.major = major;
		this.address = address;
		this.email = email;
		this.degree = degree;
		this.phone = phone;
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public boolean isNull() {
		if (username == null)
			return true;
		if (password == null)
			return true;
		if (username.equals("") || password.equals("")) {
			return true;
		}
		return false;
	}

	public boolean accomplish() {
		if (phone == null || sex == null || major == null || degree == null || address == null || email == null)
			return false;
		if (phone.equals("") || sex.equals("") || major.equals("") || degree.equals("") || address.equals("")
				|| email.equals(""))
			return false;
		return true;
	}

	public ArrayList<User> InLoginMessage(){
		ArrayList<User> list=new ArrayList<User>();
		Connection con;
		   String driver = "com.mysql.cj.jdbc.Driver";
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
		return list;
	}
	
	public User InMessage(String name) {
		User u = new User();
		Connection con;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/school";
		String user = "root";
		String password = "467502";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			Statement statement = con.createStatement();
			String sql = "select * from student";
			ResultSet rs = statement.executeQuery(sql);
			String username = null;
			String sex = null;
			String major = null;
			String email = null;
			String address = null;
			String degree = null;
			String phone = null;
			while (rs.next()) {
				username = rs.getString("stuname");
				if (username.equals(name)) {
					sex = rs.getString("sex");
					major = rs.getString("major");
					email = rs.getString("email");
					address = rs.getString("address");
					degree = rs.getString("degree");
					phone = rs.getString("phone");
					u = new User(username, sex, major, address, email, degree, phone);
					break;
				}

			}
			rs.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return u;

	}

	public static void main(String[] args) {

	}

}
