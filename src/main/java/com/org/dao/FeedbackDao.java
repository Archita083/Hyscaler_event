package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.org.dto.Booking;
import com.org.dto.Feedback;
import com.org.utilities.HelperClass;

public class FeedbackDao {
	public void saveFeedback(Feedback feed) {
		Connection con = HelperClass.getDBConnection();

		try {
			PreparedStatement pst = con
					.prepareStatement("insert into feedback (user_id,user_name,description,event_date,event_time,feedback)values (?,?,?,?,?,?)");

			pst.setInt(1, feed.getUser_id());
			pst.setString(2, feed.getUser_name());
			pst.setString(3, feed.getDescription());
			pst.setString(4, feed.getEvent_date());
			pst.setString(5, feed.getEvent_time());
			pst.setString(6, feed.getFeedback());

			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public List<Feedback> fecthAllFeedback() {
		Connection con = HelperClass.getDBConnection();
		Feedback fed = null;
		List<Feedback> list = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement("select * from feedback");

			ResultSet rst = pst.executeQuery();

			while (rst.next()) {
				
				int user_id = rst.getInt("user_id");
				String user_name = rst.getString("user_name");
				String description = rst.getString("description");
				String event_date = rst.getString("event_date");
				String event_time = rst.getString("event_time");
				String feedback = rst.getString("feedback");
			

				fed = new Feedback();

				fed.setUser_id(user_id);
				fed.setUser_name(user_name);
				fed.setDescription(description);
				fed.setEvent_date(event_date);
				fed.setEvent_time(event_time);
				fed.setFeedback(feedback);
		

				list.add(fed);

			}
			//return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
