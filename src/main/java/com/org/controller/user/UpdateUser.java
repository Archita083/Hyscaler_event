package com.org.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.UserDao;
import com.org.dto.User;

@WebServlet("/user/update_user")
public class UpdateUser extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		long mobile=Long.parseLong(req.getParameter("mobile"));
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		User user = new User();
		
		user.setId(id);
		user.setName(name);
		user.setAddress(address);
		user.setMobile(mobile);
		user.setEmail(email);
		user.setPassword(password);
		
		UserDao dao = new UserDao();
		dao.updateUserById(user);
		
		
		//resp.sendRedirect("../user/user_homepage.jsp");
	}
}
