package com.org.controller.feedback;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.FeedbackDao;
import com.org.dto.Feedback;

@WebServlet("/user/send_feedback")
public class SaveFeedback extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_id=req.getParameter("user_id");
		String user_name=req.getParameter("user_name");
		String description=req.getParameter("description");
		String event_date=req.getParameter("event_date");
		String event_time=req.getParameter("event_time");
		String feedback=req.getParameter("feedback");
		
		Feedback feed=new Feedback();
		feed.setUser_id(Integer.parseInt(user_id));
    	feed.setUser_name(user_name);
    	feed.setDescription(description);
    	feed.setEvent_date(event_date);
    	feed.setEvent_time(event_time);
    	feed.setFeedback(feedback);
    	
    	
    	FeedbackDao dao = new FeedbackDao();
		dao.saveFeedback(feed);
	}
}
