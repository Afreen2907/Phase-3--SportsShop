package com.simplilearn.workshop.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;  


@Entity
@Table(name= "purchase_items")   
public class PurchaseItem { 


	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private long purchaseId;
	

	private long productId;


	private long userId;


	private BigDecimal rate;


	private int qty;


	private BigDecimal price;


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
	 * @return the purchaseId
	 */
	public long getPurchaseId() {
		return purchaseId;
	}


	/**
	 * @param purchaseId the purchaseId to set
	 */
	public void setPurchaseId(long purchaseId) {
		this.purchaseId = purchaseId;
	}


	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}


	/**
	 * @param productId the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
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
	 * @return the rate
	 */
	public BigDecimal getRate() {
		return rate;
	}


	/**
	 * @param rate the rate to set
	 */
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}


	/**
	 * @return the qty
	 */
	public int getQty() {
		return qty;
	}


	/**
	 * @param qty the qty to set
	 */
	public void setQty(int qty) {
		this.qty = qty;
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

	
	
	
	

}
