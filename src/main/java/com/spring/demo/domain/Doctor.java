package com.spring.demo.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long doctorId;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "NICNUMBER")
	private String nicNumber;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "CONTACTNUMBER")
	private String contactNumber;

	@Column(name = "SPECIALIZATION")
	private String specialization;

	@OneToOne(mappedBy = "doctor")
	private Prescription prescription;

	public Doctor() {
	}

	public Doctor(long doctorId, String firstName, String lastName, String nicNumber, String gender,
			String contactNumber, String specialization) {
		super();
		this.doctorId = doctorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nicNumber = nicNumber;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.specialization = specialization;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
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

	public String getNicNumber() {
		return nicNumber;
	}

	public void setNicNumber(String nicNumber) {
		this.nicNumber = nicNumber;
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

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}
}