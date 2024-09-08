package com.klef.ep.service;

import java.util.List;

import com.klef.ep.models.Employee;

public interface EmployeeService
{
	//CRUD Operations 
	public String addemployee(Employee employee); //Registration
	public String updateemployee(Employee employee);
	public String deleteemployee(int eid);
	public List<Employee> viewallemps();
	public Employee viewempbyid(int eid);
	
}
