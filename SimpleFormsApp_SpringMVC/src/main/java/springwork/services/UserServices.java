package springwork.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import springwork.entities.User;

public class UserServices {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("SimpleFormsApp");
	EntityManager manager = factory.createEntityManager();
	
	public User getByEmail(String email) {
		try {
			User u = manager.createQuery("Select e From User e Where e.email = :email", User.class).setParameter("email",email).getSingleResult();
			return u;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeAll() {
		if(factory.isOpen()) factory.close();
		
		if(manager.isOpen()) manager.close();
	}


}
