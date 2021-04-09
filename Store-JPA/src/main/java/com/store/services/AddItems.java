package com.store.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.store.entity.Item;
import com.store.entity.Orders;

public class AddItems {
	private List<Item> items;
	private Orders order;
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Store-JPA");
	EntityManager manager = factory.createEntityManager();
	
	public AddItems() {
		items = new ArrayList<Item>();
	}
	
	
	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int nrOrders() {
		try {
			int size = manager.createNamedQuery("Orders.findAll").getResultList().size();
			return size;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public void addItem(Item i) {
		try {
			manager.getTransaction().begin();
			manager.persist(i);
			manager.getTransaction().commit();
		}catch(Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		
	}
	public void addToOrder(Integer i) {
		try {
			Item it = manager.find(Item.class, i);
			items.add(it);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public List<Item> showItems() {
		
		List<Item> itemIn = manager.createNamedQuery("Item.findAll").getResultList();

		return itemIn;
		
	}
	public void createOrder(int i) {
		
		if(items.size() > 0) {
			Double tot = 0.0;
			Double tax = 0.0;
			for(Item it : items) {
				tot += it.getPrice();
			}
			tax = tot * 0.0875;
			order = new Orders(i,new Date(),tot,tax, items);
			try {
				manager.getTransaction().begin();
				manager.persist(order);
				manager.getTransaction().commit();
			}catch(Exception e) {
				manager.getTransaction().rollback();
				e.printStackTrace();
			}
		}
	}
	public void end() {
		manager.close();
		factory.close();
	}

	

}


