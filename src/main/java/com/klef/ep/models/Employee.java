package com.klef.ep.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_table")
public class Employee 
{
	@Id
	@Column(name = "empid")
   private int id;
	
    @Column(name = "empfisrtname", length = 50,nullable = false)
   private String firstname;
    
    @Column(name = "emplastname",length = 50,nullable = false)
   private String secondname;
    
    @Column(name = "empemail",length = 50,unique = true,nullable = false)
   private 	String email;
    
    @Column(name = "emppostion",length = 20,nullable = false)
   private String postion;
    
    @Column(name = "empsalary",precision = 10,scale = 5,nullable = false)
   private double salary;
    
    
	@Column(name="emp_gender",nullable = false,length = 10)
	private String gender;
	
	@Column(name="emp_contact",nullable = false,length = 20,unique = true)
	private String contact;
	
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getSecondname() {
	return secondname;
}
public void setSecondname(String secondname) {
	this.secondname = secondname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPostion() {
	return postion;
}
public void setPostion(String postion) {
	this.postion = postion;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
}
