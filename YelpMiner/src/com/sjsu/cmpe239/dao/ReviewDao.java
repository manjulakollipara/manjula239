
package com.sjsu.cmpe239.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.sjsu.cmpe239.dto.ReviewDto;


/**
 * @author ManjulaKollipara
 *
 */
public class ReviewDao {

	Connection connection = null;
	PreparedStatement stmt = null;
	String query = null;
	int queryResult;

	public void loadReview(ReviewDto review){

		try{

			connection = new DaoFactory().getJdbcConnection();
			query = "insert into reviewtable(review_id, user_id, business_id, stars, date, review, funny, cool, useful) values(?,?,?,?,?,?,?,?,?)";

			stmt = connection.prepareStatement(query);

			//set parameter values
			stmt.setString(1, review.getReview_id());
			stmt.setString(2, review.getUser_id());
			stmt.setString(3, review.getBusiness_id());
			stmt.setString(4, review.getStars());
			stmt.setString(5, review.getDate());
			stmt.setString(6, review.getReview());
			stmt.setString(7, review.getFunny());
			stmt.setString(8, review.getCool());
			stmt.setString(9, review.getUseful());

			if(stmt.executeUpdate() > 0){
				System.out.println("BusinessDao: successfylly inserted "+ review.toString());

			}else{
				System.out.println("UserDao: Exception while inserting a row in User table" + review.toString());
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
	/**
	 * @author PallaviSastry
	 * This method gets all reviews with rating stars > 3
	 */
	public HashMap<String,ReviewDto> getAllPositiveReviews(){
		
		Statement statement = null;
		ReviewDto review;// = new ReviewDto();
		HashMap<String, ReviewDto> allPositiveReviewsMap = new HashMap<>();
		String review_id;
		connection = new DaoFactory().getJdbcConnection();
		
		query = "select * from cmpe239.reviewtable where stars > 3"; //Reviews are positive if greater than 3
		
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			if(!(rs.next()))
				System.out.println("No Positive Queries Found!");
			do{
				review_id = rs.getString("review_id");
				//creating review object
				review = new ReviewDto();
				
				review.setReview_id(review_id);
				review.setUser_id(rs.getString("user_id"));
				review.setBusiness_id(rs.getString("business_id"));
				review.setReview(rs.getString("review"));
				review.setDate(rs.getString("date"));
				review.setStars(rs.getString("stars"));
				
				//Adding review object to map
				allPositiveReviewsMap.put(review_id, review);
			}while((rs.next()));
			
		} catch (SQLException e) {
			System.out.println("Exception while querying for positive reviews");
			e.printStackTrace();
		}
		return allPositiveReviewsMap;
	}
	/**
	 * @author PallaviSastry
	 * This method Gets all reviews with rating stars<=3
	 */
	public HashMap<String,ReviewDto> getAllNegativeReviews(){
		
		Statement statement = null;
		ReviewDto review;
		HashMap<String, ReviewDto> allNegativeReviewsMap = new HashMap<>();
		String review_id;
		connection = new DaoFactory().getJdbcConnection();
		
		query = "select * from cmpe239.reviewtable where stars <= 3"; //Reviews are positive if greater than 3
		
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			if(!(rs.next())){
				System.out.println("No Negative Queries Found!");
				return allNegativeReviewsMap;//empty object
			}
			do{
				review_id = rs.getString("review_id");
				
				//creating review object
				review = new ReviewDto();
				
				review.setReview_id(review_id);
				review.setUser_id(rs.getString("user_id"));
				review.setBusiness_id(rs.getString("business_id"));
				review.setReview(rs.getString("review"));
				review.setDate(rs.getString("date"));
				review.setStars(rs.getString("stars"));
				
				//Adding review object to map
				allNegativeReviewsMap.put(review_id, review);
			}while((rs.next()));
			
		} catch (SQLException e) {
			System.out.println("Exception while querying for positive reviews");
			e.printStackTrace();
		}
		return allNegativeReviewsMap;
	}
}

