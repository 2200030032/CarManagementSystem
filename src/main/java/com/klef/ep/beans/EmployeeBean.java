package com.klef.ep.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.servlet.RequestDispatcher;

import com.klef.ep.models.Employee;
import com.klef.ep.service.EmployeeService;

@ManagedBean(name="empbean",eager = true)
public class EmployeeBean 
{
    @EJB(lookup = "java:global/carmanagement/EmployeeServiceImpl!com.klef.ep.service.EmployeeService")
    EmployeeService  service;
    
	private List<Employee> emplist;
	
    private int id;
    private String fisrtname;
    private String secondname;
    private String gender;
    private String email;
    private String postion;
    private double salary;
    private String contactno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFisrtname() {
		return fisrtname;
	}
	public void setFisrtname(String fisrtname) {
		this.fisrtname = fisrtname;
	}
	public String getSecondname() {
		return secondname;
	}
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	
	public String Add()
	{
		Employee e=new Employee();
		e.setId(id);
		e.setFirstname(fisrtname);
		e.setSecondname(secondname);
		e.setGender(gender);
		e.setEmail(email);
		e.setPostion(postion);
		e.setSalary(salary);
		e.setContact(contactno);
		
		service.addemployee(e);
		return "viewallemps.jsf?faces-redirect=true";
	}
	public List<Employee> getEmplist() {
		return service.viewallemps();
	}
	public void setEmplist(List<Employee> emplist) {
		this.emplist = emplist;
	}
	public String delete(int eid)
	{
		service.deleteemployee(eid);
		return "viewallemps.jsf";
	}
	public String update()
	{
		Employee emp=service.viewempbyid(id);
		
		if(emp!=null)
		{
			Employee e=new Employee();
			e.setId(id);
			e.setFirstname(fisrtname);
			e.setSecondname(secondname);
			e.setSalary(salary);
			e.setContact(contactno);
			
			service.updateemployee(e);
			
			return "viewallemps.jsf";
		}
		else
		{
			System.out.println("ID Not Found");
			return "updatefail.jsf";
		}
		
	}
    
}
