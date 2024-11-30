package com.org.controller.event;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.EventDao;
import com.org.dto.Event;

@WebServlet("/event/search_event")
public class SearchEvent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String location=req.getParameter("location");
		String event_date=req.getParameter("event_date");
		
		//Event evnt = new Event();
		//evnt.setLocation(location);
		//evnt.setEvent_date(event_date);
		
		EventDao dao = new EventDao();
		List<Event> list=dao.fetchEventByLocationAndDate(location, event_date);
		
		
		HttpSession session=req.getSession();
		
		//RequestDispatcher r=req.getRequestDispatcher("eventObj");
		//r.forward(req, resp);
		
		if(list !=null)
		   {   
			   session.setAttribute("evntObj", list);
			   session.setAttribute("eventObj", list);
			   resp.sendRedirect("../user/searched_event.jsp");
		   }
		else
		   {
			session.setAttribute("fail", "No such event found");
			resp.sendRedirect("../user/searched_event.jsp");
		   }
		   
	}

}
