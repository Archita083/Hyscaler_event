package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.org.dto.Organizer;
import com.org.utilities.HelperClass;

public class OrganizerDao {
	public void saveOrganizer(Organizer org) {
		Connection con = HelperClass.getDBConnection();

		try {
			PreparedStatement pst = con
					.prepareStatement("insert into organizer (name,mobile,email,password)values (?,?,?,?)");

			pst.setString(1, org.getName());
			pst.setLong(2, org.getMobile());
			pst.setString(3, org.getEmail());
			pst.setString(4, org.getPassword());

			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public Organizer fetchOrganizerByEmailAndPassword(String email, String password) {
		Connection con = HelperClass.getDBConnection();

		try {
			PreparedStatement pst = con.prepareStatement("select * from organizer where email=? and password=?");

			pst.setString(1, email);
			pst.setString(2, password);

			ResultSet rst = pst.executeQuery();

			Organizer org = null;

			if (rst.next()) {
				String name = rst.getString("name");
				long mobile = rst.getLong("mobile");
				String email1 = rst.getString("email");
				String password1 = rst.getString("password");

				org = new Organizer();

				org.setId(rst.getInt("id"));
				org.setName(name);
				org.setMobile(mobile);
				org.setEmail(email1);
				org.setPassword(password1);
			}

			return org;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
