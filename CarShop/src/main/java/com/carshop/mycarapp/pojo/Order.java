package com.carshop.mycarapp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="order_table")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "orderID", unique=true, nullable = false)
	private long orderID;
	
	@Column(name = "userID")
	private long userID;
	
	@Column(name ="shippingAddress")
	private String shippingAddress;
	
	@Column(name ="orderplacedate")
	private String orderplacedate;
	
	@Column(name ="modeofdelivery")
	private String modeofdelivery;
	
	@Column(name ="status")
	private String status;
	
	@Column(name ="deliverydate")
	private String deliverydate;	
	
	public Order(){
		
	}

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getOrderplacedate() {
		return orderplacedate;
	}

	public void setOrderplacedate(String orderplacedate) {
		this.orderplacedate = orderplacedate;
	}

	public String getModeofdelivery() {
		return modeofdelivery;
	}

	public void setModeofdelivery(String modeofdelivery) {
		this.modeofdelivery = modeofdelivery;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
	}
	
	

	
}
