package com.users.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.users.entity.Users;

public class ManageUsers {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Users");
	EntityManager manager = factory.createEntityManager();
	public ManageUsers() {
		
	}
	
	public void createUser(String email, String name, String password, String address,String state, Integer zipcode) {
		Users user = new Users(email,name,password,address,state,zipcode);
		
		try {
			manager.getTransaction().begin();
			manager.persist(user);
			manager.getTransaction().commit();
		}catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public Users login(String email, String password) {
		List<Users> user = manager.createNamedQuery("findUser")
		.setParameter("uemail", email)
		.setParameter("upass", password)
		.getResultList();
		
		return user.get(0);
	}
	
	public Users getFromEmail(String email) {
		
		return manager.find(Users.class, email);
	}
	
	public void endAll() {
		factory.close();
		manager.close();
	}

}
