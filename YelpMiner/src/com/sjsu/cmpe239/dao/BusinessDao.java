package com.sjsu.cmpe239.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sjsu.cmpe239.dto.*;

/**
 * @author ManjulaKollipara
 *
 */
public class BusinessDao {

	Connection connection = null;
	PreparedStatement stmt = null;
	String query = null;
	int queryResult;

	public void loadBusiness(BusinessDto bz){

		try{

			connection = new DaoFactory().getJdbcConnection();
			query = "insert into businesstable(business_id, fulladdress, open, categories, city, review_count, bz_name, longitude,latitude, state, stars) values(?,?,?,?,?,?,?,?,?,?,?)";

			stmt = connection.prepareStatement(query);

			//set parameter values
			stmt.setString(1, bz.getBusiness_id());
			stmt.setString(2, bz.getFulladdress());
			stmt.setString(3, bz.getOpen());
			stmt.setString(4, bz.getCategories());
			stmt.setString(5, bz.getCity());
			stmt.setInt(6, bz.getReview_count());
			stmt.setString(7, bz.getBz_name());
			stmt.setString(8, bz.getLongitude());
			stmt.setString(9, bz.getLatitude());
			stmt.setString(10, bz.getState());
			stmt.setString(11, bz.getStars());

			if(stmt.executeUpdate() > 0){
				System.out.println("BusinessDao: successfylly inserted "+ bz.toString());

			}else{
				System.out.println("UserDao: Exception while inserting a row in User table" + bz.toString());
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

