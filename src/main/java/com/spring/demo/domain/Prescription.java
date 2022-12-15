package com.spring.demo.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Prescription {
	@Id
	@NotNull(message = "Please enter ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long prescriptionId;

	@OneToOne
    @JoinColumn(name = "patient_id")
	private Patient patient;

	@OneToOne
    @JoinColumn(name = "doctor_id")
	private Doctor doctor;

	@Column(name = "DATE", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotBlank(message = "Prescription date cannot be blank")
	private Date prescriptionDate;

	public Prescription() {
		super();
	}

	public Prescription(@NotBlank(message = "Doctor must be selected") Patient patient,
			@NotBlank(message = "Doctor must be selected") Doctor doctor,
			@NotBlank(message = "Prescription date cannot be blank") Date prescriptionDate) {
		super();
		this.patient = patient;
		this.doctor = doctor;
		this.prescriptionDate = prescriptionDate;
	}

	public long getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(long prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Date getPrescriptionDate() {
		return prescriptionDate;
	}

	public void setPrescriptionDate(Date prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}

}
