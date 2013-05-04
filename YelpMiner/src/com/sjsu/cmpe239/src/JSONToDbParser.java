package com.sjsu.cmpe239.src;


/**
 * @author ManjulaKollipara
 *
 */
public class JSONToDbParser {

	static JSONUserConverter user = null;
	static JSONBusinessConverter business = null;
	static JSONReviewConverter review = null;
	
	public static void main(String[] args){
	
		JSONUserConverter user = new JSONUserConverter();
		user.convert();
		
		JSONBusinessConverter business = new JSONBusinessConverter();
		business.convert();		
		
		JSONReviewConverter review = new JSONReviewConverter();
		review.convert();
		
		/*String restName = args[1];
		String city = args[2];
		
		
		HashMap<Object, Object) resultSet = QueryDb(restName, city);*/
		
	}

}
