package jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.dao.ICourseDao;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class CourseService implements ICourseDao {
	private List<Course> courses = new ArrayList<Course>();
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("School");
	EntityManager manager = factory.createEntityManager();	


	@Override
	public List<Course> getAllCourses() {
		try {
			courses = manager.createQuery("SELECT e FROM Course e", Course.class).getResultList();
			return courses;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Adds new Course to Database
	 * @param id
	 * @param name
	 * @param instructor
	 */
	public void addCourse(Integer id, String name, String instructor) {
		Course c = new Course(id,name,instructor);
		if(manager.find(Course.class, c.getcId()) == null) {
			try {
				manager.getTransaction().begin();
				manager.persist(c);
				manager.getTransaction().commit();
			}catch(Exception e) {
				e.printStackTrace();
				manager.getTransaction().rollback();
			}
		}
	}
	/**
	 * Removes Course from Database
	 * @param id
	 */
	public void removeCourse(Integer id) {
		Course c = manager.find(Course.class, id);
		if(c != null) {
			try {
				manager.getTransaction().begin();
				manager.remove(c);
				manager.getTransaction().commit();
			}catch(Exception e) {
				e.printStackTrace();
				manager.getTransaction().rollback();
				
			}
		}
	}
	/**
	 * Gets Course by Id (PK)
	 * @param id
	 * @return
	 */
	public Course getCourseById(Integer id) {
		return manager.find(Course.class, id);
	}
	
	/**
	 * Gets all students registered to Course
	 * @param id
	 * @return List of Student
	 */
	public List<Student> getStudents(Integer id){
		Course c = manager.find(Course.class, id);
		
		return c.getStudents();
	}
	
	/**
	 * Closes EntityManagerFactory and EntityManager
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
