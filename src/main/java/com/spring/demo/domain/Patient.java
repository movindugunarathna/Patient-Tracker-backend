package com.spring.demo.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patientId;

	@Column(name = "first_name",nullable = false, length = 512)
    @NotBlank(message = "Patient First Name cannot be blank")
	private String firstName;

	@Column(name = "last_name",nullable = false, length = 512)
    @NotBlank(message = "Patient First Name cannot be blank")
	private String lastName;
	
	@Column(name = "username",nullable = false, length = 512, unique = true)
    @NotBlank(message = "Patient First Name cannot be blank")
	private String username;

	@Column(name = "age", nullable = false)
    @NotBlank(message = "Age cannot be blank")
	private String age;

	@Column(name = "gender",nullable = false)
    @NotBlank(message = "Gender cannot be empty")
	private String gender;

	@Column(name = "contact_number",nullable = false)
    @NotBlank(message = "Contact number cannot be blank")
	@Pattern(regexp = "^\\d{10}$", message = "Contact number must be a numeric value with 10 digits")
	private String contactNumber;

	@Column(name = "notes",nullable = false)
    @NotBlank(message = "Notes cannot be empty. Add Some notes")
	private String notes;

	@OneToOne(mappedBy = "patient")
	private Prescription prescription;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Bill> bill;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "patientList", fetch = FetchType.EAGER)
	private Set<Doctor> doctorList = new HashSet<Doctor>();

	public Patient() {
		super();
	}

	public Patient(long patientId, String firstName, String lastName, String username, String age, String gender,
			String contactNumber, String notes, Prescription prescription, Set<Bill> bill, Set<Doctor> doctorList) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.notes = notes;
		this.prescription = prescription;
		this.bill = bill;
		this.doctorList = doctorList;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public Set<Bill> getBill() {
		return bill;
	}

	public void setBill(Set<Bill> bill) {
		this.bill = bill;
	}

	public Set<Doctor> getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(Set<Doctor> doctorList) {
		this.doctorList = doctorList;
	}
	
}
