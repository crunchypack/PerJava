package com.test.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.test.jpa.employee.EmployeeEntity;

public class CreatingEmployee {

	public static void main( String[ ] args ) {
	     EntityManagerFactory emfactory=Persistence.createEntityManagerFactory("JPATest");  
	     EntityManager em=emfactory.createEntityManager();  
	      


	     EmployeeEntity employee = new EmployeeEntity(); 
	     employee.setEmail( "mk@gmai.com");
	     employee.setFirstName( "Alex" );
	     employee.setLastName("Mick");
	     employee.setEmployeeNumber(23);
	     employee.setOfficeCode(1);
	     employee.setExtension("x101");
	     employee.setJobTitle("Sales Rep");

	     try {
	    	 em.getTransaction().begin();
	    	 em.persist(employee);
	    	 em.getTransaction().commit();
	     }catch(Exception e){
	    	 em.getTransaction().rollback();
	     }finally {
	    	 em.close();
	    	 emfactory.close();
	     }
	     
	}


}
