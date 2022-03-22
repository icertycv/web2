package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.User;


@WebServlet(name="LoginServletStu",urlPatterns="/LoginServletStu")
public class LoginServletStu extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServletStu() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u1;
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		u1 = new User(username, password);
		ArrayList<User> list=u1.InLoginMessage();
		String targetpath = "/HomePageStu.jsp";
		int index=-1;
		if (u1.isNull()) {
			String error = "�û��������벻��Ϊ��";
			request.setAttribute("error", error);
			targetpath = "/LoginViewStu.jsp";
		} else {
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getUsername().equals(username)&&list.get(i).getPassword().equals(password)) {
					index=i;
					break;
				}
			}
			if(index!=-1) {
				request.getSession().setAttribute("Stu", u1);// Session
			}else {
				String error = "�û������������,����������";
				request.setAttribute("error", error);
				targetpath = "/LoginViewStu.jsp";
			}
		}
		request.getRequestDispatcher(targetpath).forward(request, response);
	}

}
