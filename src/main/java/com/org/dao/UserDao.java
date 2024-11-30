package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.org.dto.User;
import com.org.utilities.HelperClass;

public class UserDao {
	public void saveUser(User user) {
		Connection con = HelperClass.getDBConnection();

		try {
			PreparedStatement pst = con
					.prepareStatement("insert into user (name,address,mobile,email,password)values (?,?,?,?,?)");

			pst.setString(1, user.getName());
			pst.setString(2, user.getAddress());
			pst.setLong(3, user.getMobile());
			pst.setString(4, user.getEmail());
			pst.setString(5, user.getPassword());

			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public User fetchUserById(int id) {
		
		Connection con = HelperClass.getDBConnection();

		try {
			PreparedStatement pst = con.prepareStatement("select * from user where id=?");

			pst.setInt(1, id);
			
			ResultSet rst = pst.executeQuery();

			User user = null;

			if (rst.next()) {
				String name = rst.getString("name");
				String address = rst.getString("address");
				long mobile = rst.getLong("mobile");
				String email1 = rst.getString("email");
				String password1 = rst.getString("password");

				user = new User();

				user.setId(rst.getInt("id"));
				user.setName(name);
				user.setAddress(address);
				user.setMobile(mobile);
				user.setEmail(email1);
				user.setPassword(password1);
			}

			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public User fetchUserByEmailAndPassword(String email, String password) {
		Connection con = HelperClass.getDBConnection();

		try {
			PreparedStatement pst = con.prepareStatement("select * from user where email=? and password=?");

			pst.setString(1, email);
			pst.setString(2, password);

			ResultSet rst = pst.executeQuery();

			User user = null;

			if (rst.next()) {
				String name = rst.getString("name");
				String address = rst.getString("address");
				long mobile = rst.getLong("mobile");
				String email2 = rst.getString("email");
				String password2 = rst.getString("password");

				user = new User();

				user.setId(rst.getInt("id"));
				user.setName(name);
				user.setAddress(address);
				user.setMobile(mobile);
				user.setEmail(email2);
				user.setPassword(password2);
			}

			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void updateUserById(User user) {
  
		Connection con = HelperClass.getDBConnection();

		try {
			PreparedStatement pst = con
					.prepareStatement("update user set name=?,address=?,mobile=?,email=? where id=?");

			pst.setString(1, user.getName());
			pst.setString(2, user.getAddress());
			pst.setLong(3, user.getMobile());
			pst.setString(4, user.getEmail());
			pst.setInt(5, user.getId());

			pst.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
