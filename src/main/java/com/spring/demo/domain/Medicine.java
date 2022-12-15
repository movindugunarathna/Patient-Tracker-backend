package com.spring.demo.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "medicine")
public class Medicine {
	
	@Id
	private long serialNumber;
	
    @Column(name = "medicine_name")
	private String medicineName;
	
    @Column(name = "price")
	private double price;
	
    @Column(name = "manufactured_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date manufacturedDate;
	
    @Column(name = "expiry_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expiryDate;
	
    @Column(name = "notes")
	private String notes;

	public Medicine() {
		super();
	}

	public Medicine(long serialNumber, String medicineName, double price, Date manufacturedDate, Date expiryDate,
			String notes) {
		super();
		this.serialNumber = serialNumber;
		this.medicineName = medicineName;
		this.price = price;
		this.manufacturedDate = manufacturedDate;
		this.expiryDate = expiryDate;
		this.notes = notes;
	}

	public long getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(Date manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
