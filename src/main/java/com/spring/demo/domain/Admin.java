package com.spring.demo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Admin {
	@Id
	@NotNull(message = "Please enter ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long adminId;

	@Column(name = "FIRST_NAME", nullable = false)
	@NotBlank(message = "Please enter first name")
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	@NotBlank(message = "Please enter last name")
	private String lastName;

	@Column(name = "AGE", nullable = false)
	@NotBlank(message = "Please enter age")
	private String age;

	@Column(name = "GENDER", nullable = false)
	@NotBlank(message = "Please enter gender")
	private String gender;

	@Column(name = "CONTACT_NUMBER", nullable = false)
	@NotBlank(message = "Please enter contact number")
	@Pattern(regexp = "^[0-9]*$", message = "Contact number must be a numeric value")
	private String contactNumber;

	@Column(name = "PASSWORD", nullable = false)
	@NotBlank(message = "Please enter password")
	private String password;

	public Admin() {
	}

	public Admin(long adminId, String firstName, String lastName, String age, String gender, String contactNumber,
			String password) {
		this.adminId = adminId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.password = password;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}