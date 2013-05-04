package com.sjsu.cmpe239.src;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import com.sjsu.cmpe239.dao.*;
import com.sjsu.cmpe239.dto.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author ManjulaKollipara
 *
 */
public class JSONUserConverter {
	UserDto user = new UserDto();
	
	public void convert(){
		// TODO Auto-generated method stub

		String jsonFilePath = "src/com/sjsu/cmpe239/data/user.json";
		
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
				//String votes = (String) jsonObject.get("votes");
				//System.out.println(votes);

				String user_id = (String) json.get("user_id");
				System.out.println(user_id);
				user.setUser_id(user_id);

				String name = (String) json.get("name");
				System.out.println(name);
				user.setName(name);

				Double average_stars = (Double) json.get("average_stars");
				System.out.println(average_stars.toString());
				user.setStars(average_stars.toString());

				Long review_count = (Long) json.get("review_count");
				System.out.println(review_count.toString());
				user.setReview_count(review_count.toString());

				String type = (String) json.get("type");
				System.out.println(type);
				user.setType(type);

				UserDao userData = new UserDao();
				userData.loadUser(user);
				
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
		user.setCool(cool.toString());
		
		Long funny = (Long) votesObj.get("funny");
		System.out.println(funny);
		user.setFunny(funny.toString());
		
		Long useful =(Long) votesObj.get("useful");
		System.out.println(useful.toString());
		user.setUseful(useful.toString());				
	}

}