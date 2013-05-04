package com.sjsu.cmpe239.dto;


/**
 * @author ManjulaKollipara
 *
 */
public class BusinessDto {

	private String business_id;
	private String fulladdress;
	private String open;
	private String categories;
	private String city;
	private int review_count;
	private String bz_name;
	private String longitude;
	private String latitude;
	private String state;
	private String stars;
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
	 * @return the open
	 */
	public String getOpen() {
		return open;
	}
	/**
	 * @param open the open to set
	 */
	public void setOpen(String open) {
		this.open = open;
	}
	/**
	 * @return the categories
	 */
	public String getCategories() {
		return categories;
	}
	/**
	 * @param categories the categories to set
	 */
	public void setCategories(String categories) {
		this.categories = categories;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the review_count
	 */
	public int getReview_count() {
		return review_count;
	}
	/**
	 * @param review_count the review_count to set
	 */
	public void setReview_count(int review_count) {
		this.review_count = review_count;
	}
	/**
	 * @return the bz_name
	 */
	public String getBz_name() {
		return bz_name;
	}
	/**
	 * @param bz_name the bz_name to set
	 */
	public void setBz_name(String bz_name) {
		this.bz_name = bz_name;
	}
	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BusinessDto [business_id=" + business_id + ", fulladdress="
				+ fulladdress + ", open=" + open + ", categories=" + categories
				+ ", city=" + city + ", review_count=" + review_count
				+ ", bz_name=" + bz_name + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", state=" + state + ", stars="
				+ stars + "]";
	}
	
	
	
}
