package com.carshop.mycarapp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	public class ShoppingCart {

		private long id;
	    private String name;
	    private String color;	    
	    private int price;
	    private int quantity;
	    private String imageSrc;	    
	    private int amount;	       
	    
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public String getImageSrc() {
			return imageSrc;
		}
		public void setImageSrc(String imageSrc) {
			this.imageSrc = imageSrc;
		}
		public long getId() {
			return id;
		}
		public void setId(long l) {
			this.id = l;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	 
	    

}
