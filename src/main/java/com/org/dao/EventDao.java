package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.org.dto.Event;
import com.org.utilities.HelperClass;

public class EventDao {

	public void saveEvent(Event evnt) {
		Connection con = HelperClass.getDBConnection();

		try {
			PreparedStatement pst = con
					.prepareStatement("insert into event (event_title,description,event_date,event_time,location,ticket_price,tickets_available,privacy,ticket_type)values (?,?,?,?,?,?,?,?,?)");

			pst.setString(1, evnt.getEvent_title());
			pst.setString(2, evnt.getDescription());
			pst.setString(3, evnt.getEvent_date());
			pst.setString(4, evnt.getEvent_time());
			pst.setString(5, evnt.getLocation());
			pst.setInt(6, evnt.getTicket_price());
			pst.setInt(7, evnt.getTickets_available());
			pst.setString(8, evnt.getPrivacy());
			pst.setString(9, evnt.getTicket_type());

			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public List<Event> fetchEventByLocationAndDate(String location, String event_date) {
		Connection con = HelperClass.getDBConnection();
		Event evnt = null;
		List<Event> list = new ArrayList<>();
		
		try {
			PreparedStatement pst = con.prepareStatement("select * from event where location=? and event_date=?");

			pst.setString(1, location);
			pst.setString(2, event_date);

			ResultSet rst = pst.executeQuery();
			

			while(rst.next()) {
				String event_title = rst.getString("event_title");
				String description = rst.getString("description");
				String event_date1 = rst.getString("event_date");
				String event_time = rst.getString("event_time");
				String location1 = rst.getString("location");
				int ticket_price = rst.getInt("ticket_price");
				int tickets_available = rst.getInt("tickets_available");
				String ticket_type = rst.getString("ticket_type");
				
				evnt = new Event();
				evnt.setId(rst.getInt("event_id"));
				evnt.setEvent_title(event_title);
				evnt.setDescription(description);
				evnt.setEvent_date(event_date1);
				evnt.setEvent_time(event_time);
				evnt.setLocation(location1);
				evnt.setTicket_price(ticket_price);
				evnt.setTickets_available(tickets_available);
				evnt.setTicket_type(ticket_type);
				
				list.add(evnt);
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		//return null;
	}
	public List<Event> fetchAllEvents() {
		Connection con = HelperClass.getDBConnection();
		Event evnt = null;
		List<Event> list = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement("select * from event");

			ResultSet rst = pst.executeQuery();

			while (rst.next()) {
				int event_id = rst.getInt("event_id");
				String event_title = rst.getString("event_title");
				String description = rst.getString("description");
				String event_date1 = rst.getString("event_date");
				String event_time = rst.getString("event_time");
				String location1 = rst.getString("location");
				int ticket_price = rst.getInt("ticket_price");
				int tickets_available = rst.getInt("tickets_available");
				String ticket_type = rst.getString("ticket_type");

				evnt = new Event();

				evnt.setId(event_id);
				evnt.setEvent_title(event_title);
				evnt.setDescription(description);
				evnt.setEvent_date(event_date1);
				evnt.setEvent_time(event_time);
				evnt.setLocation(location1);
				evnt.setTicket_price(ticket_price);
				evnt.setTickets_available(tickets_available);
				evnt.setTicket_type(ticket_type);

				list.add(evnt);

			}
			//return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Event fetchEventById(int id) {
		
		Connection con = HelperClass.getDBConnection();

		try {
			PreparedStatement pst = con.prepareStatement("select * from event where event_id=?");

			pst.setInt(1, id);
			
			ResultSet rst = pst.executeQuery();

			Event evnt = null;

			if (rst.next()) {
				String event_title = rst.getString("event_title");
				String description = rst.getString("description");
				String event_date1 = rst.getString("event_date");
				String event_time = rst.getString("event_time");
				String location1 = rst.getString("location");
				int ticket_price = rst.getInt("ticket_price");
				int tickets_available = rst.getInt("tickets_available");
				String ticket_type = rst.getString("ticket_type");

				evnt = new Event();
				
				evnt.setId(rst.getInt("event_id"));
				evnt.setEvent_title(event_title);
				evnt.setDescription(description);
				evnt.setEvent_date(event_date1);
				evnt.setEvent_time(event_time);
				evnt.setLocation(location1);
				evnt.setTicket_price(ticket_price);
				evnt.setTickets_available(tickets_available);
				evnt.setTicket_type(ticket_type);
			}

			return evnt;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
