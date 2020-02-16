package com.database.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.log4j.Logger;

import com.userpojo.Test;

import saveInterface.IUserDaoInterface;

public class Userdao implements IUserDaoInterface{

	final static Logger logger=Logger.getLogger(Userdao.class);
	
	public void saveUser(Test test) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			logger.info("jdbc connection");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/log", "root", "root");
			PreparedStatement ps = connection.prepareStatement("insert into sprin (name,email,password,moblie) values(?,?,?,?)");
			ps.setString(1, test.getName());
			ps.setString(2, test.getEmail());
			ps.setString(3, test.getPassword());
			ps.setString(4, test.getMobile());
			ps.executeUpdate();
			connection.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		

		
	}

	
		public List<Test> loginUser(String email, String password) {
			
			logger.info("jdbc connection");
			
		return null;
	}


	


	@Override
	public List<Test> userList() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int deleteUser(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
