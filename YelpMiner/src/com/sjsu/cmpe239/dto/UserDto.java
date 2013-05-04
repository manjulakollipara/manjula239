package com.sjsu.cmpe239.dto;

/**
 * @author ManjulaKollipara
 *
 */
public class UserDto {

	//Votes
	private String cool;
	private String funny;
	private String useful;
	
	// Other Attributes
	private String user_id;
	private String name;
	private String stars;
	private String review_count;
	private String type;
	public String getCool() {
		return cool;
	}
	public void setCool(String cool) {
		this.cool = cool;
	}
	public String getFunny() {
		return funny;
	}
	public void setFunny(String funny) {
		this.funny = funny;
	}
	public String getUseful() {
		return useful;
	}
	public void setUseful(String useful) {
		this.useful = useful;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStars() {
		return stars;
	}
	public void setStars(String stars) {
		this.stars = stars;
	}
	public String getReview_count() {
		return review_count;
	}
	public void setReview_count(String review_count) {
		this.review_count = review_count;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserDto [cool=" + cool + ", funny=" + funny + ", useful="
				+ useful + ", user_id=" + user_id + ", name=" + name
				+ ", stars=" + stars + ", review_count=" + review_count
				+ ", type=" + type + ", getCool()=" + getCool()
				+ ", getFunny()=" + getFunny() + ", getUseful()=" + getUseful()
				+ ", getUser_id()=" + getUser_id() + ", getName()=" + getName()
				+ ", getStars()=" + getStars() + ", getReview_count()="
				+ getReview_count() + ", getType()=" + getType()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
