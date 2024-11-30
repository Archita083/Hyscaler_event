package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.org.dto.Booking;
import com.org.utilities.HelperClass;

public class TicketDao {
	public void saveTicket(Booking book) {
		Connection con = HelperClass.getDBConnection();

		try {
			PreparedStatement pst = con
					.prepareStatement("insert into ticket (user_id,user_name,user_email,user_mobile,event_date,event_time,ticket_type,ticket_price,ticket_count,total_price)values (?,?,?,?,?,?,?,?,?,?)");

			pst.setInt(1, book.getUser_id());
			pst.setString(2, book.getUser_name());
			pst.setString(3, book.getUser_email());
			pst.setLong(4, book.getUser_mobile());
			pst.setString(5, book.getEvent_date());
			pst.setString(6, book.getEvent_time());
			pst.setString(7, book.getTicket_type());
			pst.setInt(8, book.getTicket_price());
			pst.setInt(9, book.getTicket_count());
			pst.setInt(10, book.getTotal_price());

			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<Booking> fetchTicketByUserId(int id) {
		
		Connection con = HelperClass.getDBConnection();
		Booking bok = null;
		List<Booking> list = new ArrayList<>();

		try {
			PreparedStatement pst = con.prepareStatement("select * from ticket where user_id=?");

			pst.setInt(1, id);
			
			ResultSet rst = pst.executeQuery();

			while (rst.next()) {
				String event_date = rst.getString("event_date");
				String event_time = rst.getString("event_time");
				String ticket_type = rst.getString("ticket_type");
				int ticket_price = rst.getInt("ticket_price");
				int ticket_count = rst.getInt("ticket_count");
				int total_price = rst.getInt("total_price");

				bok = new Booking();
				
				bok.setId(rst.getInt("id"));
				bok.setEvent_date(event_date);
				bok.setEvent_time(event_time);
				bok.setTicket_type(ticket_type);
				bok.setTicket_price(ticket_price);
				bok.setTicket_count(ticket_count);
				bok.setTotal_price(total_price);
				
				list.add(bok);
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public List<Booking> fetchAllBookings() {
		Connection con = HelperClass.getDBConnection();
		Booking book = null;
		List<Booking> list = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement("select * from ticket");

			ResultSet rst = pst.executeQuery();

			while (rst.next()) {
				int id=rst.getInt("id");
				int user_id = rst.getInt("user_id");
				String user_name = rst.getString("user_name");
				String user_email = rst.getString("user_email");
				long user_mobile = rst.getLong("user_mobile");
				String event_date = rst.getString("event_date");
				String event_time = rst.getString("event_time");
				String ticket_type = rst.getString("ticket_type");
				int ticket_price = rst.getInt("ticket_price");
				int ticket_count = rst.getInt("ticket_count");
				int total_price = rst.getInt("total_price");

				book = new Booking();

				book.setId(id);
				book.setUser_id(user_id);
				book.setUser_name(user_name);
				book.setUser_email(user_email);
				book.setUser_mobile(user_mobile);
				book.setEvent_date(event_date);
				book.setEvent_time(event_time);
				book.setTicket_type(ticket_type);
				book.setTicket_price(ticket_price);
				book.setTicket_count(ticket_count);
				book.setTotal_price(total_price);

				list.add(book);

			}
			//return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
