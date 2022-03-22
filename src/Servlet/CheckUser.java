package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entity.User;
@WebServlet(name="CheckUser",urlPatterns="/CheckUser")
public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckUser() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		User user=(User)request.getSession().getAttribute("user");//Session
		String targetpath;
		String name=user.getUsername();
		User u=user.InMessage(name);
		if(u.accomplish()) {
			targetpath="/UserMessage.jsp";
			request.getSession().setAttribute("u", u);// Session
			request.getRequestDispatcher(targetpath).forward(request, response);
		}else {
			String error="����δ����������Ϣ";
			request.setAttribute("error", error);
			targetpath="/AddUserMessage.jsp";
			request.getRequestDispatcher(targetpath).forward(request, response);
		}
	}

}
