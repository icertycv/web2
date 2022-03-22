package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Course;


@WebServlet(name="CheckCourseEmptyStu",urlPatterns="/CheckCourseEmptyStu")
public class CheckCourseEmptyStu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckCourseEmptyStu() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		Course c=(Course)request.getSession().getAttribute("C");//Session;
		String targetpath;
		if(c==null) {
			String error="�γ̱�Ϊ��";
			request.setAttribute("error", error);
			targetpath="/HomePageStu.jsp";
			request.getRequestDispatcher(targetpath).forward(request, response);
		}else {
			targetpath="/ShowCourseStu.jsp";
			request.getRequestDispatcher(targetpath).forward(request, response);
		}
	}

}
