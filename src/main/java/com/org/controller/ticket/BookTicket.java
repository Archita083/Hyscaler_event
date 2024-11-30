package com.org.controller.ticket;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.TicketDao;
import com.org.dto.Booking;

@WebServlet("/event/book_ticket")
public class BookTicket extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_id=req.getParameter("user_id");
		String user_name=req.getParameter("user_name");
		String user_email=req.getParameter("user_email");
		String user_mobile=req.getParameter("user_mobile");
		String event_date=req.getParameter("event_date");
		String event_time=req.getParameter("event_time");
		String ticket_type=req.getParameter("ticket_type");
		String ticket_price=req.getParameter("ticket_price");
		String ticket_count=req.getParameter("ticket_count");
		String total_price=req.getParameter("total_price");
		
		
		
		Booking book=new Booking();
			book.setUser_id(Integer.parseInt(user_id));
	    	book.setUser_name(user_name);
	    	book.setUser_email(user_email);
	    	book.setUser_mobile(Long.parseLong(user_mobile));
	    	book.setEvent_date(event_date);
	    	book.setEvent_time(event_time);
	    	book.setTicket_type(ticket_type);
	    	book.setTicket_price(Integer.parseInt(ticket_price));
	    	book.setTicket_count(Integer.parseInt(ticket_count));
	    	book.setTotal_price(Integer.parseInt(total_price));
		
		
		
		TicketDao dao = new TicketDao();
		dao.saveTicket(book);
		
		//HttpSession session=req.getSession();
		   
		   if(book !=null)
		   {   
			   //session.setAttribute("success", "Event Created");
			   resp.sendRedirect("../event/payment.jsp");
		   }
		
	}

}
