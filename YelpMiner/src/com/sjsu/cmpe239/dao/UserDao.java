package com.sjsu.cmpe239.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sjsu.cmpe239.dto.UserDto;

/**
 * @author ManjulaKollipara
 *
 */
public class UserDao {

	Connection connection = null;
	PreparedStatement stmt = null;
	String query = null;
	int queryResult;

	
	public void loadUser(UserDto user){

		try{

			connection = new DaoFactory().getJdbcConnection();
			query = "insert into usertable(user_id, name, stars, review_count, cool, funny, useful) values(?,?,?,?,?,?,?)";

			stmt = connection.prepareStatement(query);

			//set parameter values
			stmt.setString(1, user.getUser_id());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getStars());
			stmt.setString(4, user.getReview_count());
			stmt.setString(5, user.getCool());
			stmt.setString(6, user.getFunny());
			stmt.setString(7, user.getUseful());

			if(stmt.executeUpdate() > 0){
				System.out.println("successfylly inserted "+ user.toString());

			}else{
				System.out.println("UserDao: Exception while inserting a row in User table" + user.toString());
			}

		}catch(SQLException e){
			System.out.println("Exception while inserting a row in User table");
			e.printStackTrace();

		}finally{
			
			if( connection != null){
				try {
					connection.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		

	}
}
