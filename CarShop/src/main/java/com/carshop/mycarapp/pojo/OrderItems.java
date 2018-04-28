package com.carshop.mycarapp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="orderItems_table")
public class OrderItems {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "orderItemsID", unique=true, nullable = false)
	private long orderItemsID;
	
	@Autowired
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderID")
    private Order order;
	
	@Column(name ="carID")
	private long carID;
	
	@Column(name ="price")
	private int price;
	
	@Column(name ="color")
	private String color;
	
	public OrderItems(){
		
	}

	public long getorderItemsID() {
		return orderItemsID;
	}

	public void setOrderID(long orderItemsID) {
		this.orderItemsID = orderItemsID;
	}



	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public long getCarID() {
		return carID;
	}

	public void setCarID(long carID) {
		this.carID = carID;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int i) {
		this.price = i;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
}
