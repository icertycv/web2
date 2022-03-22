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



@WebServlet(name="AlterCourse",urlPatterns="/AlterCourse")
public class AlterCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AlterCourse() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("gbk");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String time = request.getParameter("time");
		String score = request.getParameter("score");
		String targetpath= "/ShowCourse.jsp";
		Object ID= request.getSession().getAttribute("ID");//Session
		AlterSC((String) ID,name,time,score);
		AlterC((String) ID,name,time,score);
		request.getRequestDispatcher(targetpath).forward(request, response);
	}

	public void AlterSC(String id,String name,String time,String score) {
		SelectCourse sc=new SelectCourse();
		ArrayList<SelectCourse> list=sc.InSC();
		String courseid=null;
		for(int i=0;i<list.size();i++) {
			if(id.equals(list.get(i).getCourseid())) {
				courseid=list.get(i).getCourseid();
				break;
			}
		}
		Connection con;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/school";
		String user = "root";
		String password = "467502";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			Statement statement = con.createStatement();
			String sql = "update sc set sc_coursename=?,sc_time=?,sc_score=? where sc_courseid=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, time);
			ps.setString(3, score);
			ps.setString(4, id);
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
	
	public void AlterC(String id,String name,String time,String score) {
		Course c=new Course();
		ArrayList<Course> list=c.InCourse();
		String courseid=null;
		for(int i=0;i<list.size();i++) {
			if(id.equals(list.get(i).getId())) {
				courseid=list.get(i).getId();
				break;
			}
		}
		Connection con;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/school";
		String user = "root";
		String password = "467502";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			Statement statement = con.createStatement();
			String sql = "update course set coursename=?,time=?,score=? where courseid=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, time);
			ps.setString(3, score);
			ps.setString(4, id);
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
