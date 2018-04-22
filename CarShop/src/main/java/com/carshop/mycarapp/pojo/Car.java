package com.carshop.mycarapp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


	@Entity
	@Table(name="car_table")
	public class Car {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="carID", unique = true, nullable = false)
	    private long carID;
		
		@Column(name="brand")
	    private String brand;
		
		@Column(name="modelNo")
	    private String modelNo;
		
		@Column(name="price")
	    private int price;
		
		@Column(name="activated")
	    private String activated;
		
		@Column(name="imageSrc")
	    private String imageSrc;
		
		@Column(name="description")
	    private String description;

		public Car(){
			
		}
		
		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getModelNo() {
			return modelNo;
		}

		public void setModelNo(String modelNo) {
			this.modelNo = modelNo;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public String getActivated() {
			return activated;
		}

		public void setActivated(String activated) {
			this.activated = activated;
		}

		public String getImageSrc() {
			return imageSrc;
		}

		public void setImageSrc(String imageSrc) {
			this.imageSrc = imageSrc;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		
		
		

}
