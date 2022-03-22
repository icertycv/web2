package Entity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Course implements Serializable{
	 private ArrayList<Course> List=new ArrayList<Course>();
	 private String id;
	 private String name;
	 private String time;
	 private String score;

	public ArrayList<Course> getList() {
		return List;
	}

	public void setList(ArrayList<Course> list) {
		List = list;
	}

	public void AddCourse(Course c) {
		List.add(c);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Course() {
		super();
	}

	public Course(String id, String name, String time, String score) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.score = score;
	}
	
	public ArrayList<Course> InCourse(){
		ArrayList<Course> list=new ArrayList<Course>();
		Connection con;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/school";
		String user = "root";
		String password = "467502";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			Statement statement = con.createStatement();
			String sql = "select * from course";
			ResultSet rs = statement.executeQuery(sql);
			String courseid = null;
			String coursename = null;
			String time = null;
			String score = null;
			while (rs.next()) {
				courseid=rs.getString("courseid");
				coursename=rs.getString("coursename");
				score=rs.getString("score");
				time=rs.getString("time");
				Course c=new Course(courseid,coursename,time,score);
				list.add(c);
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
		return list;
	}
	
	public boolean accomplish() {
		if (id == null || name == null || time == null|| score == null)
			return false;
		if (id.equals("") || name.equals("") || time.equals("")|| score.equals(""))
			return false;
		return true;
	}
}

