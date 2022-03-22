package Entity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SelectCourse implements Serializable{
	 private ArrayList<SelectCourse> List=new ArrayList<SelectCourse>();
	 private String stuname;	 
	 private String courseid;
	 private String coursename;
	 private String time;
	 private String score;
	 
	 
	public ArrayList<SelectCourse> getList() {
		return List;
	}


	public void setList(ArrayList<SelectCourse> list) {
		List = list;
	}


	public String getStuname() {
		return stuname;
	}


	public void setStuname(String stuname) {
		this.stuname = stuname;
	}


	public String getCourseid() {
		return courseid;
	}


	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}


	public String getCoursename() {
		return coursename;
	}


	public void setCoursename(String coursename) {
		this.coursename = coursename;
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


	public SelectCourse(String stuname, String courseid, String coursename, String time,
			String score) {
		super();
		this.stuname = stuname;
		this.courseid = courseid;
		this.coursename = coursename;
		this.time = time;
		this.score = score;
	}


	public SelectCourse() {
		super();
	}


	public ArrayList<SelectCourse> InSC(){
		ArrayList<SelectCourse> list=new ArrayList<SelectCourse>();
		Connection con;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/school";
		String user = "root";
		String password = "467502";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			Statement statement = con.createStatement();
			String sql = "select * from sc";
			ResultSet rs = statement.executeQuery(sql);
			String stuname = null;
			String courseid = null;
			String coursename = null;
			String time = null;
			String score = null;
			while (rs.next()) {
				stuname=rs.getString("sc_stuname");
				courseid=rs.getString("sc_courseid");
				coursename=rs.getString("sc_coursename");
				score=rs.getString("sc_score");
				time=rs.getString("sc_time");
				SelectCourse s=new SelectCourse(stuname,courseid,coursename,score,time);
				list.add(s);
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
	
	public static void main(String[] args) {

	}

}
