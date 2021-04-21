package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;
import jpa.entitymodels.Teacher;

public interface ITeacherDAO {
	/**
	 * Gets all the teachers in the Database
	 * @return List of Teacher
	 */
	List<Teacher> getAllTeachers();
	
	/**
	 * Finds teacher by email (PK)
	 * @param email
	 * @return teacher
	 */
	Teacher getTeacherByEmail(String email);
	
	/**
	 * Checks if teacher has entered correct credentials
	 * @param email
	 * @param pass
	 * @return True or False depending on credentials
	 */
	Boolean validateTeacher(String email, String pass);
	
	/**
	 * Adds teacher to course
	 * @param email
	 * @param id
	 */
	void teachClass(String email, Integer id);
	
	/**
	 * Gets all courses taught by teacher
	 * @param email
	 * @return List of Courses
	 */
	List<Course> getTeacherCourses(String email);
	
	/**
	 * Removes taught course 
	 * @param id
	 */
	void removeCourse(String email,Integer id);
	
	
	

}
