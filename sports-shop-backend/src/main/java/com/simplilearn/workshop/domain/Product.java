package com.simplilearn.workshop.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;  


@Entity
@Table(name= "eproduct")   
public class Product { 


	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	

	private String name;
	

	private BigDecimal price;
	

	private Date dateAdded;  


	private long categoryId;




	public Product(long id, String name, BigDecimal price, Date dateAdded, long categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.dateAdded = dateAdded;
		this.categoryId = categoryId;
	}


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
