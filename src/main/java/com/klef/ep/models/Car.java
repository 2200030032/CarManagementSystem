package com.klef.ep.models;

import java.io.Serializable;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="car_table")
public class Car implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cid")
	private int id;
	
	@Column(name="cmake",length = 30,nullable = false)
	private String make;
	
	@Column(name = "cmodel",length = 30,nullable = false)
	private String model;
	
	@Column(name = "cyear",length = 4,nullable = false)
	private int year;
	
	@Column(name = "ccolor",length = 50,nullable = false)
	private String color;
	
	@Column(name="cbodytype",length = 10,nullable = false)
	private String bodytype;
	
	@Column(name="ctransmission",length = 15,nullable = false)
	private String transmission;
	
	@Column(name="cfueltype", length = 15, nullable = false)
	private String fueltype;
	
	@Column(name="car_price",nullable = false)
    private double price;
	
	@Lob
    @Column(name ="car_image",nullable = false)
    private byte[] image;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getBodytype() {
		return bodytype;
	}
	public void setBodytype(String bodytype) {
		this.bodytype = bodytype;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public String getFueltype() {
		return fueltype;
	}
	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}
	
	public byte[] getImage() {
	        return image;
	}

	public void setImage(byte[] image) {
	        this.image = image;
	}

	public String getBase64Image() {
	    if (image != null) {
	         return Base64.getEncoder().encodeToString(image);
	    }
	   return null;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	

}
