package jpa.service;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.dao.IStudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService implements IStudentDAO {
	private List<Student> students;
	private List<Course> courses = new ArrayList<Course>();
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("School");
	EntityManager manager = factory.createEntityManager();	


	@Override
	public List<Student> getAllStudents() {
		try {
			// Named query from Student Entity
			students = manager.createNamedQuery("getAllStudents",Student.class).getResultList();
			return students;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student getStudentByEmail(String sEmail) {
		try {
			Student s = manager.find(Student.class, sEmail);
			return s;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public Boolean validateStudent(String sEmail, String sPass) {
		String email = sEmail.toLowerCase();
		try {
			// ResultList should be 1 row
			if(manager.createNamedQuery("validate",Student.class).setParameter("semail", email).setParameter("spass", sPass).getResultList().size() == 1) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void registerStudentToCourse(String sEmail, Integer sId) {
		
		Student s = manager.find(Student.class, sEmail);	
		Course c = manager.find(Course.class, sId);
		try {
			if(!s.getCourses().contains(c) ) {
				s.getCourses().add(c);
				c.getStudents().add(s);
				
				manager.getTransaction().begin();
				manager.merge(c);
				manager.merge(s);
				
				manager.getTransaction().commit();
			}
		}catch(Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Course> getStudentCourses(String sEmail) {
		Student s = manager.find(Student.class, sEmail);
		courses = s.getCourses();

		return courses;
	}
	
	/**
	 * Removes student from the Database
	 * @param email
	 */
	public void removeStudent(String email) {
		Student s = manager.find(Student.class, email);
		try {
			manager.getTransaction().begin();
			manager.remove(s);
			manager.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			
		}
	}
	/**
	 * Creates new Student and adds it to the Database
	 * @param email
	 * @param name
	 * @param pass
	 */
	public void addStudent(String email,String name, String pass) {
		Student s = new Student(email.toLowerCase(),name,pass);
		if(manager.find(Student.class, s.getsEmail()) == null) { // If student doesn't exist in the DB add it 
			try {
				manager.getTransaction().begin();
				manager.persist(s);
				manager.getTransaction().commit();
				System.out.println(s.getName() + " created");
			}catch (Exception e) {
				e.printStackTrace();
				manager.getTransaction().rollback();
			}
		}
		System.out.println(s.getsEmail() + " already exists.");
		
	}
	/**
	 * Remove a course registration
	 * @param email
	 * @param id
	 */
	public void removeStudentsCourse (String email, int id) {
		// Create Student and Course 
		Student s = manager.find(Student.class, email);
		Course c = manager.find(Course.class, id);
		
		try {
			s.getCourses().remove(c);
			c.getStudents().remove(s);
			manager.getTransaction().begin();
			manager.merge(s);
			manager.merge(c);
			manager.getTransaction().commit();
		}catch(Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
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
