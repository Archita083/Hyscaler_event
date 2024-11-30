package com.org.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.User;


@WebServlet("/user/register_user")
public class RegisterUser extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String mobile=req.getParameter("mobile");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		User user = new User();
		user.setName(name);
		user.setAddress(address);
		user.setMobile(Long.parseLong(mobile));
		user.setEmail(email);
		user.setPassword(password);
		
		UserDao dao = new UserDao();
		dao.saveUser(user);
		HttpSession session=req.getSession();
		   
		   if(user !=null)
		   {   
			   session.setAttribute("regi_success", "Registration Successful");
			   resp.sendRedirect("../user/user_register.jsp");
		   }
	}
}
