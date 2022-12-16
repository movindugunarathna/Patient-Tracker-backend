package com.spring.demo.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "bill")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "patient_name", nullable = false, length = 512, unique = true)
	@NotBlank(message = "Patient name cannot be blank")
	private String name;

	@Column(name = "cost", nullable = false, length = 512)
	@NotNull(message = "Cost cannot be blank")
	private double cost;

	@Column(name = "notes", nullable = false, length = 2048)
	@NotNull(message = "Notes cannot be blank")
	private String notes;

	@Column(name = "bill_date", nullable = false, length = 512)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Bill date cannot be blank")
	private Date billDate;

	@ManyToOne
	@JoinColumn(name = "Patient_id")
	Patient patient;

	public Bill() {
		super();
	}

	public Bill(long id, @NotBlank(message = "Patient name cannot be blank") String name,
			@NotNull(message = "Cost cannot be blank") double cost,
			@NotNull(message = "Notes cannot be blank") String notes,
			@NotNull(message = "Bill date cannot be blank") Date billDate, Patient patient) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.notes = notes;
		this.billDate = billDate;
		this.patient = patient;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
