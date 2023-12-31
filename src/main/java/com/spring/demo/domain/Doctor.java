package com.spring.demo.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long doctorId;

	@Column(name = "FIRSTNAME")
	@NotBlank(message = "Mandatory")
    @NotNull
	@Size(min = 3, max = 20, message="Characters should be between 3 and 20")
	private String firstName;

	@Column(name = "LASTNAME")
	@NotBlank(message = "Mandatory")
    @NotNull
	@Size(min = 3, max = 20, message="Characters should be between 3 and 20")
	private String lastName;

	@Column(name = "NICNUMBER")
	@NotBlank(message = "Mandatory")
    @NotNull
	@Size(min = 9, max = 12, message="Characters should be between 9 and 12")
	private String nicNumber;

	@Column(name = "GENDER")
	@NotBlank(message = "Mandatory")
    @NotNull
	private String gender;

	@Column(name = "CONTACTNUMBER")
	@NotBlank(message = "Mandatory")
    @NotNull
	@Size(min = 10, max = 12, message="Characters should be between 10 and 12")
	private String contactNumber;

	@Column(name = "SPECIALIZATION")
	@NotBlank(message = "Mandatory")
    @NotNull
	private String specialization;

	@OneToOne(mappedBy = "doctor")
	private Prescription prescription;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "doctors_patients", joinColumns = {
			@JoinColumn(name = "doctor_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "patient_id", nullable = false, updatable = false) })
	private Set<Patient> patientList;

	public Doctor() {
	}

	public Doctor(long doctorId, String firstName, String lastName, String nicNumber, String gender,
			String contactNumber, String specialization, Prescription prescription, Set<Patient> patientList) {
		super();
		this.doctorId = doctorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nicNumber = nicNumber;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.specialization = specialization;
		this.prescription = prescription;
		this.patientList = patientList;
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

	public Set<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(Set<Patient> patientList) {
		this.patientList = patientList;
	}

}