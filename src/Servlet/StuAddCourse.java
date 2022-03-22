package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Course;
import Entity.User;

@WebServlet(name="StuAddCourse",urlPatterns="/StuAddCourse")
public class StuAddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StuAddCourse() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String id1 = request.getParameter("id");
		User user=(User)request.getSession().getAttribute("Stu");//Session
		Course c=new Course();
		ArrayList<Course> list=c.InCourse();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id1)) {
				Course a=list.get(i);
				String stuname=user.getUsername();
				String courseid=a.getId();
				String coursename=a.getName();
				String time=a.getTime();
				String score=a.getScore();
				InMySQL(stuname,courseid,coursename,time,score);
			}
		}
		request.getRequestDispatcher("/ShowCourseStu.jsp").forward(request, response);
	}

	public void InMySQL(String stuname,String courseid,String coursename,String time,String score) {
		Connection con;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/school";
		String user = "root";
		String password = "467502";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			Statement statement = con.createStatement();
			String sql = "insert into sc values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, stuname);
			ps.setString(2, courseid);
			ps.setString(3, coursename);
			ps.setString(4, time);
			ps.setString(5, score);
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
