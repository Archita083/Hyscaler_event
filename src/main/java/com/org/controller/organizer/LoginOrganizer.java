package com.org.controller.organizer;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.org.dao.OrganizerDao;
import com.org.dto.Organizer;


@WebServlet("/organiser/login_organizer")
public class LoginOrganizer extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
	   OrganizerDao dao =new OrganizerDao();
	   Organizer org =dao.fetchOrganizerByEmailAndPassword(email,password);
	   HttpSession session=req.getSession();
	   
	   
	   if(org !=null)
	   {   
		   
		   session.setAttribute("orgObj", org);
		   resp.sendRedirect("../organiser/organiser_homepage.jsp");
	   }
	   else {
		   
		   session.setAttribute("fail", "Invalid email or password");
		   resp.sendRedirect("../organiser/organiser_login.jsp");
	   }
	}

}
