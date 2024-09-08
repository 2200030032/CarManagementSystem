package com.klef.ep.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.klef.ep.models.Car;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CarServiceImpl implements CarService{

	@Override
	public String addcar(Car car) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(car);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Car Successfully Added";
	}

	@Override
	public String deletecar(int cid) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
        Car c= em.find(Car.class, cid);
        if (c != null) {
            em.remove(c);
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
            em.close();
            return "Event not found";
        }
        em.close();
        return "Car Deleted Successfully";
	}

	@Override
	public String updatecar(Car car) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("jpa");
	    EntityManager  em= emf.createEntityManager();
	    
	     em.getTransaction().begin();
	          Car c = em.find(Car.class, car.getId());
	          if (c != null) {
	             c.setMake(car.getMake());
	             c.setPrice(car.getPrice());
	             c.setBodytype(car.getBodytype());
	             c.setImage(car.getImage());
	             c.setYear(car.getYear());
	              em.getTransaction().commit();
	          } else {
	              em.getTransaction().rollback();
	              em.close();
	              return "event not found";
	          }
	          em.close();
	          return "event Updated Successfully";
	}

	@Override
	public List<Car> viewallcars() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
		EntityManager em=emf.createEntityManager();
		
		List<Car> cars = em.createQuery("SELECT c FROM Car c", Car.class).getResultList();
        em.close();
        emf.close();
        return cars;
	}

	@Override
	public Car viewCarById(int id) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("jpa");
	    EntityManager  em= emf.createEntityManager();
	         
	    Car c = em.find(Car.class, id);
	    
	    if(c==null) {
	      em.close();
	      emf.close();
	      
	      return null;
	    }
	    em.close();
	    emf.close();
	    
	    return c;
	}

}
