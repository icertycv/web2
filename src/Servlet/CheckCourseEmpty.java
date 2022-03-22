package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Course;


@WebServlet(name="CheckCourseEmpty",urlPatterns="/CheckCourseEmpty")
public class CheckCourseEmpty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckCourseEmpty() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		Course c=new Course();
		ArrayList<Course> list=c.InCourse();
		String targetpath;
		if(list.size()==0) {
			String error="�γ̱�Ϊ��,����ӿγ�";
			request.setAttribute("error", error);
			targetpath="/AddCourse.jsp";
			request.getRequestDispatcher(targetpath).forward(request, response);
		}else {
			targetpath="/ShowCourse.jsp";
			request.getRequestDispatcher(targetpath).forward(request, response);
		}
	}

}
