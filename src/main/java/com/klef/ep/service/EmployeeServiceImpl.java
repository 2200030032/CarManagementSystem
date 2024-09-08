package com.klef.ep.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Employee;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class EmployeeServiceImpl implements EmployeeService
{

	@Override
	public String addemployee(Employee employee) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(employee); 
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Employee Registered Successfully";

	}

	@Override
	public String updateemployee(Employee employee) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Employee e = em.find(Employee.class, employee.getId());
		e.setFirstname(employee.getFirstname());
		e.setSecondname(employee.getSecondname());
		e.setSalary(employee.getSalary());
		e.setContact(employee.getContact());
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return "Employee Updated Successfully";
		
	}

	@Override
	public String deleteemployee(int eid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Employee e = em.find(Employee.class, eid);
		em.remove(e);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Employee Deleted Successfully";
		
	}

	@Override
	public List<Employee> viewallemps() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Query qry = em.createQuery("select e from Employee e");
		// e is an alias of Employee Class
		List<Employee> emplist = qry.getResultList();
		
	    em.close();
	    emf.close();
	    
	    return emplist;
		
	}

	@Override
	public Employee viewempbyid(int eid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Employee e = em.find(Employee.class, eid);
		
		//check if the object is null or not 
		//if null set to null(imp)
		if(e==null)
		{
			em.close();
			emf.close();
			
			return null;
		}
		
		em.close();
		emf.close();
		
		return e;
	}

}
