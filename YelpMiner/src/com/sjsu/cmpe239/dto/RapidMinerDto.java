package com.sjsu.cmpe239.dto;

public class RapidMinerDto {
	String bzname;
	String review_id;
	String review_text;
	int review_count;
	String user_id;
	private int review_stars;
	private String polarity;
	String url;
	
	
	int posCount = 0;
	int negCount = 0;
	
	String fulladdress;
	
	
	public String getReview_id() {
		return review_id;
	}

	public void setReview_id(String review_id) {
		this.review_id = review_id;
	}

	public String getReview_text() {
		return review_text;
	}

	public void setReview_text(String review_text) {
		this.review_text = review_text;
	}

	public int getReview_count() {
		return review_count;
	}

	public void setReview_count(int review_count) {
		this.review_count = review_count;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getReview_stars() {
		return review_stars;
	}

	public void setReview_stars(int review_stars) {
		this.review_stars = review_stars;
	}

	/**
	 * @return the bzname
	 */
	public String getBzname() {
		return bzname;
	}

	/**
	 * @param bzname the bzname to set
	 */
	public void setBzname(String bzname) {
		this.bzname = bzname;
	}

	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RapidMinerDto [bzname=" + bzname + ", review_id=" + review_id
				+ ", review_text=" + review_text + ", review_count="
				+ review_count + ", user_id=" + user_id + ", review_stars="
				+ review_stars + ", polarity=" + polarity + ", posCount="
				+ posCount + ", negCount=" + negCount + ", address=" + fulladdress
				+ "]";
	}

	/**
	 * @return the polarity
	 */
	public String getPolarity() {
		return polarity;
	}

	/**
	 * @param polarity the polarity to set
	 */
	public void setPolarity(String polarity) {
		this.polarity = polarity;
	}

	/**
	 * @return the posCount
	 */
	public int getPosCount() {
		return posCount;
	}

	/**
	 * @param posCount the posCount to set
	 */
	public void setPosCount(int posCount) {
		this.posCount = posCount;
	}

	/**
	 * @return the negCount
	 */
	public int getNegCount() {
		return negCount;
	}

	/**
	 * @param negCount the negCount to set
	 */
	public void setNegCount(int negCount) {
		this.negCount = negCount;
	}

	/**
	 * @return the fulladdress
	 */
	public String getFulladdress() {
		return fulladdress;
	}

	/**
	 * @param fulladdress the fulladdress to set
	 */
	public void setFulladdress(String fulladdress) {
		this.fulladdress = fulladdress;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	
	
	
	
}
