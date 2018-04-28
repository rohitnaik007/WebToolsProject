package com.carshop.mycarapp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car_table")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carID", unique = true, nullable = false)
	private long carID;

	@Column(name = "brand")
	private String brand;

	@Column(name = "modelNo")
	private String modelNo;

	@Column(name = "makeYear")
	private String makeYear;

	@Column(name = "price")
	private int price;

	@Column(name = "imageSrc")
	private String imageSrc;

	@Column(name = "description")
	private String description;

	public long getCarID() {
		return carID;
	}

	public void setCarID(long carID) {
		this.carID = carID;
	}

	public String getMakeYear() {
		return makeYear;
	}

	public void setMakeYear(String makeYear) {
		this.makeYear = makeYear;
	}

	public String getColorsAvailable() {
		return colorsAvailable;
	}

	public void setColorsAvailable(String colorsAvailable) {
		this.colorsAvailable = colorsAvailable;
	}

	@Column(name = "colorsAvailable")
	private String colorsAvailable;

	public Car() {

	}

	public Car(String brand, String colorsAvailable, String description, String imageSrc, String makeYear,
			String modelNo, int price) {
		// TODO Auto-generated constructor stub
		this.brand = brand;
		this.colorsAvailable = colorsAvailable;
		this.description = description;
		this.imageSrc = imageSrc;
		this.makeYear = makeYear;
		this.modelNo = modelNo;
		this.price = price;
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
