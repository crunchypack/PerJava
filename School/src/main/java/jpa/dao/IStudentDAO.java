package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
/**
 * Interface for StudentDAO
 * @author Simon
 *
 */
public interface IStudentDAO {
	/**
	 * Gets all students in the database
	 * @return List of Student
	 */
	List<Student> getAllStudents();
	
	/**
	 * Finds student by email(PK)
	 * @param sEmail
	 * @return Student
	 */
	Student getStudentByEmail(String sEmail);
	
	/**
	 * Checks if user has entered correct credentials
	 * @param sEmail
	 * @param sPass
	 * @return True/false depending on correct credentials
	 */
	Boolean validateStudent(String sEmail, String sPass);
	
	/**
	 * Registers Student to Course
	 * @param sEmail
	 * @param sId
	 */
	void registerStudentToCourse(String sEmail, Integer sId);
	
	/**
	 * Gets all Course taken by Student
	 * @param sEmail
	 * @return List of Course
	 */
	List<Course> getStudentCourses (String sEmail);
	
	 
}
