package com.spring.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Clerk")
public class Clerk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clerkID;

    @NotNull(message = "Firstname is mandatory")
    @Column(name = "FirstName")
    private String firstName;
    
    @NotNull(message = "Lasttname is mandatory")
    @Column(name = "lastName")
    private String lastName;

    @NotNull(message = "Age is mandatory")
    @Column(name = "age")
    private String age;

    @NotNull(message = "Gender is mandatory")
    @Column(name = "gender")
    private String gender;

    @Pattern(regexp = "^\\d{10}$", message = "Please Enter Valid Phone Number")
    @NotNull(message = "Contact Number is mandatory")
    @Column(name = "contactNo")
    private String contactNo;

    @NotNull(message = "Department is mandatory")
    @Column(name = "department")
    private String department;

    public Clerk(){

    }

    public Clerk(long clerkID, String firstName, String lastName, String age, String contactNo, String gender, String department){
        this.clerkID = clerkID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.contactNo = contactNo;
        this.department = department;
    }

    public long getClerkID() {
        return clerkID;
    }

    public void setClerkID(long clerkID) {
        this.clerkID = clerkID;
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

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
