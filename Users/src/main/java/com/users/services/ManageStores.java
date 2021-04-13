package com.users.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.users.entity.Stores;

public class ManageStores {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Users");
	EntityManager manager = factory.createEntityManager();
	
	public ManageStores() {
		
	}
	public void addStore(int id, String name, String city, String state) {
		Stores store = new Stores(id,name,city,state);
		
		try {
			manager.getTransaction().begin();
			manager.persist(store);
			manager.getTransaction().commit();
		}catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("unchecked")
	public List<Stores> getAllByCity(String city){
		return manager.createNamedQuery("GetStoresCity")
				.setParameter("ucity", city)
				.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Stores> getAll(){
		return manager.createNamedQuery("getAllStores").getResultList();
	}
	public int getRows() {
		int rows = 0;
		rows = manager.createNamedQuery("getAllStores").getResultList().size();
		return rows;
	}

	
	public void endAll() {
		if(factory.isOpen()) {
			factory.close();
			
		}
		if(manager.isOpen()) {
			manager.close();
		}
		
	}
}
