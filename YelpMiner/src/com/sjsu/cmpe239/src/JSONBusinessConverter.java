package com.sjsu.cmpe239.src;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.sjsu.cmpe239.dao.BusinessDao;
import com.sjsu.cmpe239.dto.BusinessDto;
import com.sjsu.cmpe239.interfaces.Converter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author ManjulaKollipara
 *
 */
public class JSONBusinessConverter implements Converter{

	BusinessDto business = new BusinessDto();
	
	public void convert(){
		// TODO Auto-generated method stub

		String jsonFilePath = "src/com/sjsu/cmpe239/data/business.json";
		
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

				String business_id = (String) json.get("business_id");
				System.out.println(business_id);
				business.setBusiness_id(business_id);
				
				String fulladdress = (String) json.get("full_address");
				System.out.println(fulladdress);
				business.setFulladdress(fulladdress);

				boolean open = (boolean) json.get("open");
				System.out.println(String.valueOf(open));
				business.setOpen(String.valueOf(open));

				parseCategories((JSONArray) json.get("categories"));
				
				String city = (String) json.get("city");
				String[] cityName = city.split(" ");
				System.out.println(cityName[0]);
				business.setCity(cityName[0]);
				
				Long review_count = (Long) json.get("review_count");
				System.out.println(review_count.intValue());
				business.setReview_count(review_count.intValue());
				
				String bz_name = (String) json.get("name");
				System.out.println(bz_name);
				business.setBz_name(bz_name);
				
				Double longitude = (Double) json.get("longitude");
				System.out.println(longitude.toString());
				business.setLongitude(longitude.toString());
				
				Double latitude = (Double) json.get("latitude");
				System.out.println(latitude.toString());
				business.setLatitude(latitude.toString());
				
				String state = (String) json.get("state");
				System.out.println(state);
				business.setState(state);
				
				Double stars = (Double) json.get("stars");
				System.out.println(stars.toString());
				business.setStars(stars.toString());
				
				BusinessDao bz = new BusinessDao();
				bz.loadBusiness(business);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	
	public void parseCategories(JSONArray categories){
		
		ArrayList<String> list = new ArrayList<String>();
						
		if (categories != null) { 
			for (int i=0;i<categories.size();i++){ 
				list.add(categories.get(i).toString()); 
			} 
		}
		
		StringBuffer str = new StringBuffer();
		
		Iterator<String> iterator = list.iterator();
		
		while(iterator.hasNext()){
			String temp = (String) iterator.next();
			str.append(temp);
			str.append(",");
		}
		
		business.setCategories(str.toString()); 
		
		
	}

}