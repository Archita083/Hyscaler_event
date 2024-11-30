package com.org.controller.organizer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.OrganizerDao;
import com.org.dto.Organizer;

@WebServlet("/organiser/register_organizer")
public class RegisterOrganizer extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String mobile=req.getParameter("mobile");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		
		Organizer org = new Organizer();
		org.setName(name);
		org.setMobile(Long.parseLong(mobile));
		org.setEmail(email);
		org.setPassword(password);
		
		OrganizerDao dao = new OrganizerDao();
		dao.saveOrganizer(org);
	}

}
