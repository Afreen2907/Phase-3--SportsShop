package com.simplilearn.workshop.domain;

import java.math.BigDecimal;
import java.util.Date;


public class Product { 
	
	private long ID;
	

	private String name;
	

	private BigDecimal price;
	

	private Date dateAdded;  


	private long categoryId;


	/**
	 * @return the iD
	 */
	public long getID() {
		return ID;
	}


	/**
	 * @param iD the iD to set
	 */
	public void setID(long iD) {
		ID = iD;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	/**
	 * @return the dateAdded
	 */
	public Date getDateAdded() {
		return dateAdded;
	}


	/**
	 * @param dateAdded the dateAdded to set
	 */
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}


	/**
	 * @return the categoryId
	 */
	public long getCategoryId() {
		return categoryId;
	}


	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}  
	

	
}
