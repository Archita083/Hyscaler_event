package com.org.controller.event;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.EventDao;
import com.org.dto.Event;

@WebServlet("/organiser/create_event")
public class CreateEvent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String event_title=req.getParameter("event_title");
		String description=req.getParameter("description");
		String event_date=req.getParameter("event_date");
		String time=req.getParameter("time");
		String location=req.getParameter("location");
		String price=req.getParameter("price");
		String count=req.getParameter("count");
		String privacy=req.getParameter("privacy");
		String ticket_types=req.getParameter("ticket_types");
		
		Event evnt = new Event();
		evnt.setEvent_title(event_title);
		evnt.setDescription(description);
		evnt.setEvent_date(event_date);
		evnt.setEvent_time(time);
		evnt.setLocation(location);
		evnt.setTicket_price(Integer.parseInt(price));
		evnt.setTickets_available(Integer.parseInt(count));
		evnt.setPrivacy(privacy);
		evnt.setTicket_type(ticket_types);
		
		
		EventDao dao = new EventDao();
		dao.saveEvent(evnt);
		
		HttpSession session=req.getSession();
		   
		   if(evnt !=null)
		   {   
			   session.setAttribute("success", "Event Created");
			   resp.sendRedirect("../organiser/create_event.jsp");
		   }
		
	}

}
