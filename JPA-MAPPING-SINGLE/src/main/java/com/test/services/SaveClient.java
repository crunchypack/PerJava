package com.test.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.test.entity.NonTeachingStaff;
import com.test.entity.Staff;
import com.test.entity.TeachingStaff;

public class SaveClient {

	public static void main(String[]args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA-MAPPING-SINGLE");		
		EntityManager entityM = emfactory.createEntityManager();
		
		TeachingStaff ts1 = new TeachingStaff(1,"Natalie", "MSs OccuBe","English");
		TeachingStaff ts2 = new TeachingStaff(2, "Jack", "BSc", "Maths");
		
		NonTeachingStaff nts1 = new NonTeachingStaff(3, "Ramon", "Accounts");
		NonTeachingStaff nts2 = new NonTeachingStaff(4, "Ali", "Office Admin");
		
		Staff staff = new Staff(5,"Jack");
		
		try {
			entityM.getTransaction().begin();
			entityM.persist(staff);
//			entityM.persist(ts2);
//			entityM.persist(nts1);
//			entityM.persist(nts2);
			entityM.getTransaction().commit();
		}catch(Exception e) {
			entityM.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			entityM.close();
			emfactory.close();
		}
		
	}

}
