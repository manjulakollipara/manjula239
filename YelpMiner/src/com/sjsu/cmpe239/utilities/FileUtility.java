package com.sjsu.cmpe239.utilities;
/**
 * @author PallaviSastry
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.sjsu.cmpe239.dao.ReviewDao;
import com.sjsu.cmpe239.dto.ReviewDto;

/**
 * 
 * @author PallaviSastry
 * 
 * This class divides reviews into 2 types, positive or negative
 * based on the rating stars given by users per review. 
 *
 */
public class FileUtility {
	private static File polarityDirectory, positiveReviewsDir,negativeReviewsDir;
	
	public static void main(String[] args){
		ReviewDao rd = new ReviewDao();
		HashMap<String, ReviewDto> postiveReviewMap=rd.getAllPositiveReviews();
		HashMap<String, ReviewDto> negativeReviewMap=rd.getAllNegativeReviews();

		int totalNumOfPostiveFiles, totalNumOfNegativeFiles;
		totalNumOfPostiveFiles = postiveReviewMap.size();
		totalNumOfNegativeFiles = negativeReviewMap.size();
		
		if(isDirectoryCreated()){
			//Create and add positive text data to positiveDir directory
			if(totalNumOfPostiveFiles > 0){
				for(Map.Entry<String, ReviewDto> positiveEntry:postiveReviewMap.entrySet()){
					String fileName = positiveEntry.getValue().getReview_id();
					String reviewContent = positiveEntry.getValue().getReview();
					createReviewFiles(positiveReviewsDir,fileName,reviewContent);
					System.out.println("**** Positive Directory Created *******");
				}
			}
			//Create and add negative text data to negativeDir directory
			if(totalNumOfNegativeFiles > 0){
				for(Map.Entry<String, ReviewDto> negativeEntry:negativeReviewMap.entrySet()){
					String fileName = negativeEntry.getValue().getReview_id();
					String reviewContent = negativeEntry.getValue().getReview();
					createReviewFiles(negativeReviewsDir,fileName,reviewContent);
					System.out.println("**** Negative Directory Created *******");
				}
			}
		}
	}
	private static boolean isDirectoryCreated(){
		System.out.println("Inside getDirectory");
		boolean isDirExists = false;
		polarityDirectory = new File("src/mining/data/polarityDir");

		try{
			positiveReviewsDir = new File("src/mining/data/polarityDir/positivesDir");
			negativeReviewsDir = new File("src/mining/data/polarityDir/negativesDir");
			
			if(!positiveReviewsDir.exists()){
				isDirExists=positiveReviewsDir.mkdirs();
			}
			if(!negativeReviewsDir.exists()){
				isDirExists=negativeReviewsDir.mkdirs();	
			}
			else{
				//if dirs exists, just return true;False is returned only if 
				//creation of a directory goes wrong
				return true;
			}
		
		}catch(SecurityException e){
			System.out.println("Security Exception while making directory"+e);
		}
		
		return isDirExists;
	}
	private static void createReviewFiles(File dir,String fname,String fcontent){
		
		File tagFile = new File(dir,fname+".txt");
		if(!tagFile.exists())
			try {
				tagFile.createNewFile();
				writeToFile(tagFile,fcontent);
			} catch (IOException e) {
				System.out.println("IO Exception while creating review text files");
				e.printStackTrace();
			}
	}
	private static void writeToFile(File tagFile,String fcontent){
		FileWriter fw;
		BufferedWriter bw;
		
		try{
			fw = new FileWriter(tagFile.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			bw.write(fcontent);
			bw.flush();
			bw.close();
		}catch(IOException e){
			System.out.println("IO Exception while writing to review text files");
			e.printStackTrace();
		}
	}
}
