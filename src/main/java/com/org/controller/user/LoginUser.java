package com.org.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.EventDao;
import com.org.dao.UserDao;
import com.org.dto.Event;
import com.org.dto.User;


@WebServlet("/user/login_user")
public class LoginUser extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
	   UserDao dao =new UserDao();
	   User user =dao.fetchUserByEmailAndPassword(email,password);
	   HttpSession session=req.getSession();
	   EventDao event_dao=new EventDao();
	   List<Event> event=event_dao.fetchAllEvents();
	   
	   if(user !=null)
	   {   
		   session.setAttribute("userObj", user);
		   session.setAttribute("evntObj", event);
		   resp.sendRedirect("../user/user_homepage.jsp");
	   }
	   else {
		   
		   session.setAttribute("fail", "Invalid email or password");
		   resp.sendRedirect("../user/user_login.jsp");
	   }
	}

}
