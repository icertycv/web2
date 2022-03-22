package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entity.User;
@WebServlet(name="CheckUserStu",urlPatterns="/CheckUserStu")
public class CheckUserStu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckUserStu() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		User user=(User)request.getSession().getAttribute("Stu");//Session
		String targetpath;
		String name=user.getUsername();
		User u=user.InMessage(name);
		if(u.accomplish()) {
			targetpath="/UserMessageStu.jsp";
			request.getSession().setAttribute("stu1", u);// Session
			request.getRequestDispatcher(targetpath).forward(request, response);
		}else {
			String error="����δ����������Ϣ";
			request.setAttribute("error", error);
			targetpath="/AddStuMessage.jsp";
			request.getRequestDispatcher(targetpath).forward(request, response);
		}
	}

}
