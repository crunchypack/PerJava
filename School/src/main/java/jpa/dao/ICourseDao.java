package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;
/**
 * Interface for CourseDAO
 * @author Simon
 *
 */
public interface ICourseDao {
	/**
	 * Gets all courses in the database
	 * @return List of Course
	 */
	List<Course> getAllCourses();

}
