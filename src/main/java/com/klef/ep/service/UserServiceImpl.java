package com.klef.ep.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import com.klef.ep.models.User;


@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UserServiceImpl  implements UserService
{

	@Override
	public String registrationUser(User user)
	{
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(user); 
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "User Registered Successfully";
	}

	@Override
	public List<User> viewallusers() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
		EntityManager em=emf.createEntityManager();
		
		List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        em.close();
        emf.close();
        return users;
	}

	@Override
	public User checkUserLogin(String username, String password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Query qry= em.createQuery("select a from User a where a.username=? and a.password=?");
		qry.setParameter(1,username);
		qry.setParameter(2, password);
		
		User user=null;
		
		if(qry.getResultList().size()>0)
		{
			user=(User)qry.getSingleResult();
		}
		return user;
	}

}
