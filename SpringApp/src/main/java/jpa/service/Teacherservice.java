package jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.dao.ITeacherDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Teacher;

public class Teacherservice implements ITeacherDAO {
	private List<Teacher> teachers;
	private List<Course> courses;
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("School");
	EntityManager manager = factory.createEntityManager();
	

	@Override
	public List<Teacher> getAllTeachers() {
		try {
			teachers = manager.createNamedQuery("getAllTeachers", Teacher.class).getResultList();
			return teachers;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Teacher getTeacherByEmail(String email) {
		try {
			Teacher t = manager.find(Teacher.class, email);
			return t;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean validateTeacher(String email, String pass) {
		try {
			int i = manager.createNamedQuery("validateTeach", Teacher.class).setParameter("email", email).setParameter("pass", pass).getResultList().size();
					
			if(i == 1) {
				return true;
			}
			return false;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void teachClass(String email, Integer id) {
		Teacher t = manager.find(Teacher.class, email);
		Course c = manager.find(Course.class, id);
		try {
				t.getCourses().add(c);
				manager.getTransaction().begin();
				manager.merge(t);
				manager.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
		}
	}

	@Override
	public List<Course> getTeacherCourses(String email) {
		Teacher t = manager.find(Teacher.class, email);
		courses = t.getCourses();
		return courses;
	}

	@Override
	public void removeCourse(String email,Integer id) {
		Course c = manager.find(Course.class, id);
		Teacher t = manager.find(Teacher.class, email);
		
		try {
			t.getCourses().remove(c);
			manager.getTransaction().begin();
			
			manager.merge(c);
			manager.getTransaction().commit();
		}catch(Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}

	}
	
	public void addTeacher(Teacher t) {
		if(!getAllTeachers().contains(t)) {
			try {
				manager.getTransaction().begin();
				manager.persist(t);
				manager.getTransaction().commit();
			}catch(Exception e) {
				manager.getTransaction().rollback();
			}
		}
		
	}
	
	/**
	 * Removes teacher from the Database
	 * @param email
	 */
	public void removeTeacher(String email) {
		Teacher t = manager.find(Teacher.class, email);
		try {
			manager.getTransaction().begin();
			manager.remove(t);
			manager.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			
		}
	}
	
	/**
	 * Close EntityManagerFactory and EntityManager
	 */
	public void endAll() {
		if(factory.isOpen()) {
			factory.close();
			
		}
		if(manager.isOpen()) {
			manager.close();
		}
	}

}
