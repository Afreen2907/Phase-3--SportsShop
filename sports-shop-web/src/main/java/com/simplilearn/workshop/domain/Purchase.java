package com.simplilearn.workshop.domain;

import java.math.BigDecimal;
import java.util.Date;


 
public class Purchase { 


	
	private long id;
	

	private long userId;
	

	private Date date;
	
	
	private BigDecimal total;


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
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}


	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}


	/**
	 * @return the total
	 */
	public BigDecimal getTotal() {
		return total;
	}


	/**
	 * @param total the total to set
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}



	
	 
}
