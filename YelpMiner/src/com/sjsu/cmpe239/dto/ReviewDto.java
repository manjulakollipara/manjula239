package com.sjsu.cmpe239.dto;


/**
 * @author ManjulaKollipara
 *
 */
public class ReviewDto {
	
	private String review_id;
	private String user_id;
	private String business_id;
	
	private String stars;
	private String date;
	private String review;
	
	private String funny;
	private String cool;
	private String useful;
	/**
	 * @return the review_id
	 */
	public String getReview_id() {
		return review_id;
	}
	/**
	 * @param review_id the review_id to set
	 */
	public void setReview_id(String review_id) {
		this.review_id = review_id;
	}
	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the business_id
	 */
	public String getBusiness_id() {
		return business_id;
	}
	/**
	 * @param business_id the business_id to set
	 */
	public void setBusiness_id(String business_id) {
		this.business_id = business_id;
	}
	/**
	 * @return the stars
	 */
	public String getStars() {
		return stars;
	}
	/**
	 * @param stars the stars to set
	 */
	public void setStars(String stars) {
		this.stars = stars;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the review
	 */
	public String getReview() {
		return review;
	}
	/**
	 * @param review the review to set
	 */
	public void setReview(String review) {
		this.review = review;
	}
	/**
	 * @return the funny
	 */
	public String getFunny() {
		return funny;
	}
	/**
	 * @param funny the funny to set
	 */
	public void setFunny(String funny) {
		this.funny = funny;
	}
	/**
	 * @return the cool
	 */
	public String getCool() {
		return cool;
	}
	/**
	 * @param cool the cool to set
	 */
	public void setCool(String cool) {
		this.cool = cool;
	}
	/**
	 * @return the useful
	 */
	public String getUseful() {
		return useful;
	}
	/**
	 * @param useful the useful to set
	 */
	public void setUseful(String useful) {
		this.useful = useful;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReviewDto [review_id=" + review_id + ", user_id=" + user_id
				+ ", business_id=" + business_id + ", stars=" + stars
				+ ", date=" + date + ", review=" + review + ", funny=" + funny
				+ ", cool=" + cool + ", useful=" + useful + "]";
	}
	

	

}

