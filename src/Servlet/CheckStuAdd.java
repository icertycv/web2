package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.User;


@WebServlet(name="CheckStuAdd",urlPatterns="/CheckStuAdd")
public class CheckStuAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CheckStuAdd() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		User user=(User)request.getSession().getAttribute("Stu");//Session
		String name=user.getUsername();
		String sex=request.getParameter("sex");
		String major=request.getParameter("major");
		String degree=request.getParameter("degree");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		user.setSex(sex);
		user.setMajor(major);
		user.setDegree(degree);
		user.setPhone(phone);
		user.setEmail(email);
		user.setAddress(address);
		User u = new User(name, sex, major, address, email, degree, phone);
		String targetpath;
		if(user.accomplish()) {
			InMySQL(name,sex,major,degree,phone,email,address);
			request.getSession().setAttribute("stu1", u);// Session
			targetpath="/UserMessageStu.jsp";
			request.getRequestDispatcher(targetpath).forward(request, response);
		}else {
			String error="����δ����������Ϣ";
			request.setAttribute("error", error);
			targetpath="/AddStuMessage.jsp";
			request.getRequestDispatcher(targetpath).forward(request, response);
		}
	}
	public void InMySQL(String name,String sex,String major,String degree,String phone,String email,String address) {
		Connection con;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/school";
		String user = "root";
		String password = "467502";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			Statement statement = con.createStatement();
			String sql = "insert into student values(?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, sex);
			ps.setString(3, major);
			ps.setString(4, address);
			ps.setString(5, email);
			ps.setString(6, degree);
			ps.setString(7, phone);
			ps.executeUpdate();
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
	}
}
