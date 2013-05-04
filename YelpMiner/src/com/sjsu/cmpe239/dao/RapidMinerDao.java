package com.sjsu.cmpe239.dao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.rapidminer.Process;
import com.rapidminer.RapidMiner;
import com.sjsu.cmpe239.dto.BusinessDto;
import com.sjsu.cmpe239.dto.RapidMinerDto;


public class RapidMinerDao {
	
	public Connection connection=null;
	String city= "-";

	public ArrayList<RapidMinerDto> search(String input) throws IOException
	{
        
		Statement statement=null;
		Statement statement2=null;
		String category="-";
		String delimeter=",";
		String business_id="-";
		
		HashMap<String,ArrayList<RapidMinerDto>> objMap= new HashMap<String,ArrayList<RapidMinerDto>>();

		String val=input;
		String[] values=val.split(delimeter);
		
		ArrayList<RapidMinerDto> listOfBusiness = null;
		
		try
		{

			if(values.length!=0)
			{
				category=values[0].trim();
				if( !category.equals("") && category.length()>1){
					category=category.replace(" ", ",");
					System.out.println("Category being searched is: "+ category);
				}

				if(values.length>1)
					city=values[1].trim();
			}
		
            connection = new DaoFactory().getJdbcConnection();
			statement=connection.createStatement();
			statement2=connection.createStatement();
			String query="select business_id, bz_name, review_count from businesstable where categories LIKE '%"+category+"%' AND City like '%"+city+"%' limit 10";
			System.out.println(query);
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
                
                
				business_id=rs.getString("business_id");
				String bz_name = rs.getString("bz_name");
				System.out.println("business-id="+business_id + "\tbusiness_Name = "+ bz_name);
				
				String reviewQuery="select review_id,user_id,review from reviewtable where business_id='"+business_id+"' limit 10";
				ResultSet reviewRs = statement2.executeQuery(reviewQuery);
				ArrayList<RapidMinerDto> list= new ArrayList<RapidMinerDto>();
				
				while (reviewRs.next())
				{
					RapidMinerDto data= new RapidMinerDto();
					data.setBzname(rs.getString("bz_name"));
					data.setReview_id(reviewRs.getString("review_id"));
					data.setUser_id(reviewRs.getString("user_id"));
					data.setReview_text(reviewRs.getString("review"));
					data.setReview_count(rs.getInt("review_count"));
					System.out.println(data.getReview_id()+","+data.getReview_count()+","+data.getReview_text()+","+data.getReview_count());
					list.add(data);
				}
				System.out.println("list size="+list.size());
				objMap.put(business_id, list);
                
			}
            
			
			
			
		} catch (SQLException e) {
            
			System.out.println(e.getMessage());
			e.printStackTrace();
            
		} finally {
			try{
                
                
				if (statement != null) {
					statement.close();
				}
                
				if (statement2 != null) {
					statement2.close();
				}
                
				if (connection != null) {
					connection.close();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
		try{
			
			listOfBusiness = callRapidMiner(objMap);
			
			Collections.sort(listOfBusiness, new Comparator<RapidMinerDto>() {
				public int compare(RapidMinerDto one, RapidMinerDto other) {
			        
					return one.getPosCount() > other.getPosCount() ? one.getPosCount() : other.getPosCount();
			    }
			}); 
			
			
			Iterator<RapidMinerDto> iterator = listOfBusiness.iterator();  

			while (iterator.hasNext()) { 
				RapidMinerDto rmd = (RapidMinerDto) iterator.next();  
				System.out.println("Final List" + rmd.toString());
			}
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		
		/*Collections.sort(listOfBusiness, new Comparator<RapidMinerDto>() {
			public int compare(RapidMinerDto one, RapidMinerDto other) {
		        
				return one.getReview_stars() > other.getReview_stars() ? one.getReview_stars() : other.getReview_stars();
		    }
		}); 
		*/
		
		
		return listOfBusiness;
		
	}
	
	public ArrayList<RapidMinerDto> callRapidMiner(HashMap<String,ArrayList<RapidMinerDto>> rawMap){

		ArrayList<RapidMinerDto> list = new ArrayList<>();
		
		try{

		//	rmProcess();
			
			ReadCsv read = new ReadCsv();

			ArrayList<SentimentDao> reviewList = read.readCsv("E:\\239\\classproject\\output\\result.csv"); 
		
			list = getBusinessList(reviewList);			

			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		return list;

	}
	
	
	
	public ArrayList<RapidMinerDto> getBusinessList(ArrayList<SentimentDao> reviewList){
		
		ArrayList<RapidMinerDto> list = null;
		PreparedStatement stmt = null;
		RapidMinerDto data = null;
		
		HashMap<String, RapidMinerDto> finalList = new HashMap<>();
		
		if( connection != null){
			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		connection = new DaoFactory().getJdbcConnection();
		
		try{
			
			for(SentimentDao review : reviewList ){

				String review_id = review.getReview_id();//.replaceAll("^\"|\"$", "");;
				String polarity = review.getPolarity();

				String queryReview = "select review, business_id from reviewtable where review_id = ?";

				stmt = connection.prepareStatement(queryReview);

				//set parameter values
				stmt.setString(1, review_id);
				ResultSet resultR  = stmt.executeQuery();

				while (resultR.next()) {
					
					String bz_id = resultR.getString("business_id");
					
					if(! finalList.containsKey(bz_id)){

						data= new RapidMinerDto();
						data.setReview_text(resultR.getString("review"));
						if( polarity.equalsIgnoreCase("pos")){
							data.setPosCount(1);
						}else{
							data.setNegCount(1);
						}

						String queryBusiness = "select bz_name, fulladdress, review_count, stars from businesstable where business_id= ? ";//and city=?";

						stmt = connection.prepareStatement(queryBusiness);
						stmt.setString(1, resultR.getString("business_id"));
						//stmt.setString(2, city);
						
						ResultSet resultB  = stmt.executeQuery();

						while (resultB.next()) {

							data.setBzname(resultB.getString("bz_name"));
							data.setFulladdress(resultB.getString("fulladdress"));
							data.setReview_count(resultB.getInt("review_count"));
							data.setReview_stars(resultB.getInt("stars"));
							break;
						}
						
						System.out.println("RapidMinerDao = " + data.toString());
						finalList.put(bz_id,  data);
						
					}else{
						
						//update polarity alone 
						if( polarity.equalsIgnoreCase("pos")){
							
							// increment polarity on  bz_id;
							
							int posCount = finalList.get(bz_id).getPosCount() + 1;
							finalList.get(bz_id).setPosCount(posCount);							
						
							
						}else if( polarity.equalsIgnoreCase("neg")){
							int negCount = finalList.get(bz_id).getNegCount() + 1;
							finalList.get(bz_id).setPosCount(negCount);							
						}else{}
					}

					
				}

			}
			

			list = getFinalList(finalList);	
			
			
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			
			
			try{


				if (stmt != null) {
					stmt.close();
				}

				if (connection != null) {
					connection.close();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}	
		
		
		
		return list;
		
	}
	
	public  ArrayList<RapidMinerDto> getFinalList(HashMap<String, RapidMinerDto> list){
		
		ArrayList<RapidMinerDto> finalList = new ArrayList<>();
		RapidMinerDto bzObj = null;

		
		Map map = list;
		
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			
			Map.Entry mEntry = (Map.Entry) iter.next();
			
			bzObj = (RapidMinerDto) mEntry.getValue();
			
			if( bzObj != null){
				System.out.println("Final list items = "+ bzObj.toString());
				
				finalList.add(bzObj);
			}


		}
		

		return finalList;
	}
	
	public  void rmProcess() {

		try {

			RapidMiner.init();
			
			RapidMiner.setExecutionMode(com.rapidminer.RapidMiner.ExecutionMode.COMMAND_LINE);
			
			String testModelPath = "E://239//classproject//rmpfiles//TestModel.rmp";
			
			Process process = new Process(new File(testModelPath));
					
			process.run();
					
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	


}