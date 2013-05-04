package com.sjsu.cmpe239.dao;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import com.sjsu.cmpe239.dao.*;

public class ReadCsv {


	public static ArrayList<SentimentDao> readCsv(String path)
	{
		ArrayList<SentimentDao> results= new ArrayList<SentimentDao>();

		try
		{

			FileInputStream fstream = new FileInputStream(path);
			// Get the object of DataInputStream

			String review="-";
			String polarity="-";
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			LineNumberReader ln= new LineNumberReader(br);
			String strLine;

			while(((strLine = ln.readLine()) != null)&&((ln.getLineNumber()==1)))
			{	  
				// System.out.println ("Line 1"+strLine);
			}

			while (((strLine = ln.readLine()) != null) )  

			{

				// count++;
				//  System.out.println ("next by line"+strLine);
				String[] values = strLine.split(";");
				review=values[1].substring(1, values[1].length()-1);
				polarity=values[6].substring(1, values[6].length()-1);;
				System.out.println("review="+review);
				System.out.println("polarity="+polarity);
				String[] rmvtxt=review.split("\\.");
				
				review=rmvtxt[0];
				
				SentimentDao senti = new SentimentDao();
				senti.setPolarity(polarity);
				senti.setReview_id(review);
				
				results.add(senti);

			}
		}
		catch (Exception e){
			//Catch exception if any
			System.err.println("Error: " + e.getMessage());
			System.err.println("Error: " + e.getStackTrace());
			e.printStackTrace();

		}
		
		return results;
	}

		/*public static void main(String args[]) throws IOException
		{
			ArrayList<SentimentDao> results= new ArrayList<SentimentDao>();
			results= readCsv("E:\\239\\classproject\\output\\result.csv");
			for(int i=0;i<results.size();i++)
			{
				System.out.println(results.get(i));
			}
			
		}*/
}
