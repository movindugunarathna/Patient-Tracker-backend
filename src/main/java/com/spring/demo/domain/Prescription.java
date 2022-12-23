package com.spring.demo.domain;

import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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

	@ManyToMany
	@JoinTable(name = "prescription_medicine", joinColumns = @JoinColumn(name = "prescription_id"), inverseJoinColumns = @JoinColumn(name = "medicine_id"))
	private Set<Medicine> medicineList;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotBlank(message = "Prescription date cannot be blank")
	@Column(name = "DATE", nullable = false)
	private Date prescriptionDate;

	@Column(name = "NOTES", nullable = false)
	@NotBlank(message = "Please enter notes")
	private String notes;

	public Prescription() {
		super();
	}

	public Prescription(@NotNull(message = "Please enter ID") long prescriptionId, Patient patient, Doctor doctor,
			Set<Medicine> medicineList, @NotBlank(message = "Prescription date cannot be blank") Date prescriptionDate,
			@NotBlank(message = "Please enter notes") String notes) {
		super();
		this.prescriptionId = prescriptionId;
		this.patient = patient;
		this.doctor = doctor;
		this.medicineList = medicineList;
		this.prescriptionDate = prescriptionDate;
		this.notes = notes;
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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Set<Medicine> getMedicineList() {
		return medicineList;
	}

	public void setMedicineList(Set<Medicine> medicineList) {
		this.medicineList = medicineList;
	}

}
