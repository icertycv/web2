package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Course;
import Entity.SelectCourse;
import Entity.User;

@WebServlet(name="StuDeleteCourse",urlPatterns="/StuCourseDelete")
public class StuCourseDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public StuCourseDelete() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("gbk");
		request.setCharacterEncoding("UTF-8");
		String id1 = request.getParameter("id");
		Delete(id1);
		request.getRequestDispatcher("/MyCourse.jsp").forward(request, response);
	}
	
	public void Delete(String id) {
		Connection con;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/school";
		String user = "root";
		String password = "467502";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			Statement statement = con.createStatement();
			String sql = "delete from sc where sc_courseid=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			ps.close();
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
