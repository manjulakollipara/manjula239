package com.sjsu.cmpe239.src;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sjsu.cmpe239.dao.ReviewDao;
import com.sjsu.cmpe239.dto.ReviewDto;

/**
 * @author ManjulaKollipara
 *
 */
public class JSONReviewConverter {

	ReviewDto review = new ReviewDto();

	public void convert(){
		// TODO Auto-generated method stub

		String jsonFilePath = "src/com/sjsu/cmpe239/data/review.json";

		if( jsonFilePath == null || jsonFilePath.equals("")){
			System.out.println("Input file is not reachable");
		}
		JSONParser parser = new JSONParser();

		try {

			Object objects = parser.parse(new FileReader(jsonFilePath));
			JSONArray jsonObject = (JSONArray) objects;

			Iterator<JSONObject> iterator = jsonObject.iterator();

			while( iterator.hasNext()){

				JSONObject json = iterator.next();

				parseVotesArray((JSONObject) json.get("votes"));

				String user_id = (String) json.get("user_id");
				System.out.println(user_id);
				review.setUser_id(user_id);

				String review_id = (String) json.get("review_id");
				System.out.println(review_id);
				review.setReview_id(review_id);

				String business_id = (String) json.get("business_id");
				System.out.println(business_id);
				review.setBusiness_id(business_id);

				Long stars = (Long) json.get("stars");
				System.out.println(stars.toString());
				review.setStars(stars.toString());

				String date = (String) json.get("date");
				System.out.println(date);
				review.setDate(date);

				String reviewStr = (String) json.get("text");
				System.out.println(reviewStr);
				review.setReview(reviewStr);

				ReviewDao rv = new ReviewDao();
				rv.loadReview(review);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void parseVotesArray(JSONObject votesObj){

		Long cool = (Long) votesObj.get("cool");
		System.out.println(cool.toString());
		review.setCool(cool.toString());

		Long funny = (Long) votesObj.get("funny");
		System.out.println(funny);
		review.setFunny(funny.toString());

		Long useful =(Long) votesObj.get("useful");
		System.out.println(useful.toString());
		review.setUseful(useful.toString());				
	}

}


